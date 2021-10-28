package com.moten.springbootdemo.controller

import com.moten.springbootdemo.pojo2.*
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat
import javax.annotation.Resource

@RestController
@RequestMapping("/transportservice/action")
class Second {
    @Resource
    val jdbcTemp: JdbcTemplate = JdbcTemplate()

    // 查询传感器
    @PostMapping("/GetAllSense")
    fun getSenseByName(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["UserName"] == null) -> Fail()
            (param["UserName"] !is String) -> Fail("参数错误")
            (param["UserName"] != "user1") -> Fail("用户错误")
            else -> Sense(
                pm = (0..10).random(),
                co2 = (350..4000).random(),
                light = (0..2000).random(),
                humidity = (30..90).random(),
                temperature = (15..27).random()
            )
        }
        println(data)
        return data
    }

    // 查询路况
    @PostMapping("/GetRoadStatus")
    fun roadStatus(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["RoadId"] == null || param["UserName"] == null) -> Fail("参数缺少")
            (param["RoadId"] !is Int || param["UserName"] !is String) -> Fail("参数类型错误")
            (param["RoadId"] == 1) -> RoadStatus(status = 3)
            (param["RoadId"] == 2) -> RoadStatus(status = 1)
            (param["RoadId"] == 3) -> RoadStatus(status = 5)
            else -> Fail()
        }
        println(data)
        return data
    }

    // 查询余额
    @PostMapping("/GetCarAccountBalance")
    fun carAccount(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["CarId"] == null || param["UserName"] == null) -> Fail("参数缺少")
            (param["CarId"] !is Int || param["UserName"] !is String) -> Fail("参数错误")
            else -> jdbcTemp.query("select * from carBalance") { rs, _ ->
                CarBalanceSQL(
                    rs.getInt("carId"),
                    rs.getInt("balance")
                )
            }.forEach { item ->
                if (item.carId == param["CarId"]) {
                    println(CarRecharge(balance = item.balance))
                    return CarRecharge(balance = item.balance)
                }
            }
        }
        println(data)
        return data
    }

    // 小车充值
    @PostMapping("/SetCarAccountRecharge")
    fun carRecharge(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["CarId"] == null || param["UserName"] == null || param["Money"] == null) -> Fail("参数缺少")
            (param["CarId"] !is Int || param["Money"] !is Int || param["UserName"] !is String) -> Fail("参数错误")
            else -> {
                jdbcTemp.update("update carBalance set balance = balance+${param["Money"]} where carId = ${param["CarId"]};")
                Fail("S", "成功")
            }
        }
        println(data)
        return data
    }

    // 查询红绿灯当前状态
    @PostMapping("/GetTrafficLightNowStatus")
    fun trafficStatus(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["TrafficLightId"] !is Int || param["UserName"] !is String) -> Fail("参数错误")
            (param["TrafficLightId"] == 1) -> TrafficLightStatus(
                listOf(
                    TrafficLightStatus.LightInfo("Red", 5),
                    TrafficLightStatus.LightInfo("Yellow", 2),
                    TrafficLightStatus.LightInfo("Green", 8)
                )
            )
            (param["TrafficLightId"] == 2) -> TrafficLightStatus(
                listOf(
                    TrafficLightStatus.LightInfo("Yellow", 2),
                    TrafficLightStatus.LightInfo("Red", 3),
                    TrafficLightStatus.LightInfo("Green", 5)
                )
            )
            (param["TrafficLightId"] == 3) -> TrafficLightStatus(
                listOf(
                    TrafficLightStatus.LightInfo("Red", 3),
                    TrafficLightStatus.LightInfo("Green", 6),
                    TrafficLightStatus.LightInfo("Yellow", 2),
                )
            )
            else -> Fail()
        }
        println(data)
        return data
    }

    // 查询车辆违章记录
    @PostMapping("/GetCarPeccancy")
    fun carViolationRecords(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["carNumber"] == null || param["UserName"] == null) -> Fail("参数缺少")
            (param["carNumber"] !is Int || param["UserName"] != "user1") -> Fail("参数错误")
            else -> {
                val list = jdbcTemp.query("select * from ViolationData") { rs, _ ->
                    ViolationData.RowsDetail(
                        rs.getString("carNumber"),
                        SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTime("datetime")),
                        rs.getString("pAddress"),
                        rs.getString("pCode")
                    )
                }
                ViolationData(list)
            }
        }
        println(data)
        return data
    }

    // 车辆信息
    @PostMapping("/GetAllCarInfo")
    fun carInfo(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["UserName"] != "user1") -> Fail()
            else -> {
                val list = jdbcTemp.query("select * from carInfo") { rs, _ ->
                    CarInfoData.RowsDetail(
                        rs.getString("pCardId"),
                        rs.getString("buyData"),
                        rs.getString("carBrand"),
                        rs.getString("carNumber"),
                        rs.getInt("number")
                    )
                }
                CarInfoData(list)
            }
        }
        println(data)
        return data
    }

    // 查询违章代码
    @PostMapping("/GetPeccancyType")
    fun peccancyType(@RequestBody param: Map<*, *>): Any {
        val data: Any = when {
            (param["UserName"] != "user1") -> Fail()
            else -> {
                val list = jdbcTemp.query("select  * from peccancyType") { rs, _ ->
                    PeccancyType.RowsDetail(
                        rs.getString("pCode"),
                        rs.getInt("pMoney"),
                        rs.getString("pRemarks"),
                        rs.getInt("pScore"),
                    )
                }
                PeccancyType(list)
            }
        }
        println(data)
        return data
    }
    

}