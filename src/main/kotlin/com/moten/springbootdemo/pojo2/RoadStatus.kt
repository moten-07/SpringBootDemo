package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class RoadStatus(
    @JsonProperty("RESULT")
    val result: String? = "S",
    @JsonProperty("ERRMSG")
    val errMsg: String? = "成功",
    @JsonProperty("Status")
    val status: Int
)