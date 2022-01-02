package ru.dkotik.androidonkotlinnew

data class Weather(var town: String, var temperature: Int, var id: Int = 3) {

    protected val weatherVal = "weather_value"

}