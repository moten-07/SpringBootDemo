package com.moten.springbootdemo.pojo

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.stereotype.Component

@Component
class WeatherModel {
    var msg: String? = null
    var code: Int? = null
    var data: DataDTO? = null

    class DataDTO {
        var temperature: Int? = null
        var humidity: Int? = null

        @JsonProperty("pm2.5")
        var air: Int? = null

    }

}