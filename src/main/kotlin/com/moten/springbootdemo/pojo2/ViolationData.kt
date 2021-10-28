package com.moten.springbootdemo.pojo2

import com.fasterxml.jackson.annotation.JsonProperty

data class ViolationData(
    @JsonProperty("RESULT")
    val result: String,
    @JsonProperty("ERRMSG")
    val errMsg: String,
    @JsonProperty("ROWS_DETAIL")
    val rows_detail: List<RowsDetail>
) {
    constructor(rows_detail: List<RowsDetail>) : this("S", "成功", rows_detail)

    class RowsDetail(
        @JsonProperty("carnumber")
        val carNumber: String,
        @JsonProperty("datetime")
        val dateTime: String,
        @JsonProperty("paddr")
        val pAddress: String,
        @JsonProperty("pcode")
        val pCode: String
    ){
        override fun toString(): String {
            return "{carnumber='$carNumber', datetime='$dateTime', paddr='$pAddress', pcode='$pCode'}"
        }
    }
}