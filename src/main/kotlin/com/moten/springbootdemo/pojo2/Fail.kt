package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class Fail(
    @JsonProperty("RESULT")
    val result: String?="F",
    @JsonProperty("ERRMSG")
    val errMsg: String?="失败",
){
    constructor(errMsg: String?):this("F",errMsg)
}