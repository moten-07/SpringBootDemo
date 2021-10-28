package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class TrafficLightStatus(
    @JsonProperty("RESULT")
    val result: String? = "S",
    @JsonProperty("ERRMSG")
    val errMsg: String? = "成功",
    @JsonProperty("Data")
    val data: List<LightInfo>
) {
    constructor(data: List<LightInfo>) : this("S", "成功", data)

    class LightInfo(
        @JsonProperty("Status")
        val status: String,
        @JsonProperty("Time")
        val time: Int
    )
}
