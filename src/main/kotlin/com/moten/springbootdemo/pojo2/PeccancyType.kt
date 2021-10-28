package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class PeccancyType(
    @JsonProperty("ERRMSG")
    val errMsg: String,
    @JsonProperty("RESULT")
    val result: String,
    @JsonProperty("ROWS_DETAIL")
    val rows_detail: List<RowsDetail>
) {
    constructor(rows_detail: List<RowsDetail>):this("S","成功",rows_detail)
    class RowsDetail(
        val pcode: String,
        val pmoney: Int,
        val premarks: String,
        val pscore: Int
    )
}