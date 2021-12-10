package com.test.viewmodellivedataroom.data

data class SUBusSearch(
    val error: Error,
    val resultList: List<Result>
)

data class Error(
    val errorCode: String,
    val errorMessage: String
)

data class Result(
    val busRouteId: String,
    val busRouteNm: String,
    val corpNm: String,
    val corpNm2: String,
    val corpNm3: String,
    val edStationNm: String,
    val firstBusTm: String,
    val firstLowTm: String,
    val lastBusTm: String,
    val lastBusYn: String,
    val lastLowTm: String,
    val length: String,
    val routeType: String,
    val stStationNm: String,
    val term: String,
    val term_all: String,
    val tm_all: String
)