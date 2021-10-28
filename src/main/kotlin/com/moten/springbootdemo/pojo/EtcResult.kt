package com.moten.springbootdemo.pojo

import org.springframework.stereotype.Component

@Component
class EtcResult {
    lateinit var msg: String
    var code: Int = 404
}