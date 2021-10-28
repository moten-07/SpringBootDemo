package com.moten.springbootdemo.controller

import com.moten.springbootdemo.pojo.*
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/transport_service")
class First {
    @RequestMapping("/")
    fun hello(): String = "hello"

    @GetMapping("/weather")
    fun weather(): WeatherModel {

        val data = WeatherModel.DataDTO()
        data.temperature = 30
        data.humidity = 30
        data.air = 2349

        val weather = WeatherModel()
        weather.msg = "susses"
        weather.code = 200
        weather.data = data
        println("${weather.data}")

        return weather
    }

    @PostMapping("/road_state")
    fun road(@RequestBody param: Map<*, *>): Any {
        val road = RoadModel()
        val error = BaseModel()
        error.code = 500
        error.msg = "输入参数缺少"
        if (param["roadId"] == null || param["userId"] == null) {
            return error
        }
        road.msg = "查询成功"
        road.code = 200
        road.roadState = when (param["roadId"]) {
            1 -> 2
            2 -> 3
            3 -> 4
            else -> 0
        }

        return road
    }

    @PostMapping("/car_recharge")
    fun recharge(@RequestBody map: Map<*, *>): BaseModel {
        if (map["carId"] == null || map["money"] == null || map["userId"] == null) {
            val error = BaseModel()
            error.code = 500
            error.msg = "充值失败"
            return error
        }
        val result = BaseModel()
        result.code = 200
        result.msg = "充值成功"
        return result
    }

    @PostMapping("/traffic_light")
    fun light(@RequestBody map: Map<*, *>): Any {
        if (map["trafficLightId"] == null || map["userId"] == null) {
            val error = BaseModel()
            error.msg = "查询失败"
            error.code = 500
            return error
        }
        val result = TrafficLightModel()
        result.code = 200
        result.msg = "查询成功"
        result.status = when (map["trafficLightId"]) {
            1 -> arrayListOf(
                TrafficLightModel.LightInfo(5, TrafficLightModel.LightInfo.LightStatus.Red),
                TrafficLightModel.LightInfo(2, TrafficLightModel.LightInfo.LightStatus.Yellow),
                TrafficLightModel.LightInfo(8, TrafficLightModel.LightInfo.LightStatus.Green),
            )
            2 -> arrayListOf(
                TrafficLightModel.LightInfo(3, TrafficLightModel.LightInfo.LightStatus.Red),
                TrafficLightModel.LightInfo(2, TrafficLightModel.LightInfo.LightStatus.Yellow),
                TrafficLightModel.LightInfo(5, TrafficLightModel.LightInfo.LightStatus.Green),
            )
            3 -> arrayListOf(
                TrafficLightModel.LightInfo(6, TrafficLightModel.LightInfo.LightStatus.Green),
                TrafficLightModel.LightInfo(2, TrafficLightModel.LightInfo.LightStatus.Yellow),
                TrafficLightModel.LightInfo(3, TrafficLightModel.LightInfo.LightStatus.Red),
            )
            else -> arrayListOf()
        }
        return result
    }

    @PostMapping("/traffic_violation")
    fun violation(@RequestBody map: Map<*, *>): Any? {
        if (map["carnumber"] == null || map["userId"] == null) {
            val error = BaseModel()
            error.msg = "查询失败"
            error.code = 500
            return error
        }
        val result = ViolationModel()
        result.code = 200
        result.msg = "查询成功"
        result.data = arrayListOf(
            ViolationModel.Data("粤A4836J0", "2021/09/26", "珠海大道", "N210927"),
            ViolationModel.Data("粤BSB9408", "2021/09/26", "珠海大道", "N210927"),
            ViolationModel.Data("粤C126556", "2021/09/27", "珠海大道", "N210927"),
            ViolationModel.Data("粤DW3DJ60", "2021/09/27", "珠海大道", "N210927"),
            ViolationModel.Data("粤EWD08F5", "2021/09/28", "珠海大道", "N210927"),
            ViolationModel.Data("粤F126556", "2021/09/29", "珠海大道", "N210927"),
            ViolationModel.Data("粤G123456", "2021/09/30", "金湖大道", "R210928")
        )
        return result
    }

    @PostMapping("/traffic_unViolation")
    fun violation2(@RequestBody map: Map<*, *>): Any? {
        val result = ViolationModel()
        result.code = 200
        result.msg = "查询成功"
        result.data = arrayListOf(
            ViolationModel.Data("粤A4836J0", "2021/09/21"),
            ViolationModel.Data("粤BSB9408", "2021/09/22"),
            ViolationModel.Data("粤C126556", "2021/09/23"),
            ViolationModel.Data("粤DW3DJ60", "2021/09/24"),
            ViolationModel.Data("粤EWD08F5", "2021/09/24"),
            ViolationModel.Data("粤F126556", "2021/09/25"),
            ViolationModel.Data("粤F126556", "2021/09/25"),
            ViolationModel.Data("粤F126556", "2021/09/26"),
            ViolationModel.Data("粤F126556", "2021/09/26"),
            ViolationModel.Data("粤F126556", "2021/09/27"),
            ViolationModel.Data("粤F126556", "2021/09/27"),
            ViolationModel.Data("粤F126556", "2021/09/27"),
            ViolationModel.Data("粤F126556", "2021/09/27"),
            ViolationModel.Data("粤F126556", "2021/09/28"),
            ViolationModel.Data("粤F126556", "2021/09/28"),
            ViolationModel.Data("粤F126556", "2021/09/28"),
            ViolationModel.Data("粤F126556", "2021/09/29"),
            ViolationModel.Data("粤F126556", "2021/09/29"),
            ViolationModel.Data("粤F126556", "2021/09/30"),
            ViolationModel.Data("粤F126556", "2021/09/29"),
            ViolationModel.Data("粤F126556", "2021/09/29"),
            ViolationModel.Data("粤F126556", "2021/09/30"),
            ViolationModel.Data("粤F126556", "2021/09/30"),
            ViolationModel.Data("粤G123456", "2021/09/30")
        )
        return result
    }
}