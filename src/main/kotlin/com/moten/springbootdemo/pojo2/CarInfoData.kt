package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class CarInfoData(
    @JsonProperty("RESULT")
    val result: String,
    @JsonProperty("ERRMSG")
    val errMsg: String,
    @JsonProperty("ROWS_DETAIL")
    val rows_detail: List<RowsDetail>
) {
    constructor(rows_detail: List<RowsDetail>):this("S","成功",rows_detail)
    class RowsDetail(
        @JsonProperty("pcardid")
        val pCardId: String,
        @JsonProperty("buydata")
        val buyData: String,
        @JsonProperty("carbrand")
        val carBrand: String,
        @JsonProperty("carnumber")
        val carNumber: String,
        val number: Int
    )
}