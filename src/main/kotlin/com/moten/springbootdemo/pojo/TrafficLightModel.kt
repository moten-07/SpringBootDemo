package com.moten.springbootdemo.pojo

import org.springframework.stereotype.Component

@Component
class TrafficLightModel {
    var code: Int? = null
    var msg: String? = null
    var status: List<LightInfo>? = null

    class LightInfo(var time: Int?, var status: LightStatus?) {
        enum class LightStatus {
            Red, Green, Yellow
        }
    }

}