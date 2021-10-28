package com.moten.springbootdemo.pojo

import org.springframework.stereotype.Component

@Component
class CarBalance {
    lateinit var msg: String
    var code: Int = 404
    var balance:Int = 0
}