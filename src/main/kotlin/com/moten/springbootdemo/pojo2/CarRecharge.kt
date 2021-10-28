package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.stereotype.Component

@Component
class CarRecharge(
    @JsonProperty("RESULT")
    val result: String? = "S",
    @JsonProperty("ERRMSG")
    val errMsg: String? = "成功",
    @JsonProperty("Balance")
    val balance: Int? = null
){
    override fun toString(): String {
        return "CarRecharge(result=$result, errMsg=$errMsg, balance=$balance)"
    }
}