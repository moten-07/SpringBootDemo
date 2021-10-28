package com.moten.springbootdemo.pojo

import org.springframework.stereotype.Component

@Component
class ViolationModel {
    var code: Int? = null
    var data: List<Data>? = null
    var msg: String? = null

    class Data(
        var carnumber: String,
        var datetime: String,
        var paddr: String? = null,
        var pcode: String? = null
    )
}
