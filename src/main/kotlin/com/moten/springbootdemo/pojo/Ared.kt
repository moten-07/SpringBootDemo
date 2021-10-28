package com.moten.springbootdemo.pojo

data class AredItem(
    val provinceCode: String,
    val provinceName: String,
    var mallCityList: List<MallCity>
)

data class MallCity(
    val cityCode: String,
    val cityName: String,
    val mallAreaList: List<MallArea>
)

data class MallArea(
    val areaCode: String,
    val areaName: String
)