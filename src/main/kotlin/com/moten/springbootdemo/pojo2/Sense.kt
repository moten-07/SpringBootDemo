package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class Sense(
    @JsonProperty("RESULT")
    val result: String? ="S",
    @JsonProperty("ERRMSG")
    val errMsg: String? = "成功",
    @JsonProperty("pm2.5")
    val pm: Int,
    @JsonProperty("co2")
    val co2: Int,
    @JsonProperty("LightIntensity")
    val light: Int,
    @JsonProperty("humidity")
    val humidity: Int,
    @JsonProperty("temperature")
    val temperature: Int
)