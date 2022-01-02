package ru.dkotik.androidonkotlinnew

import android.util.Log

object Repository {

    private val weatherList: List<Weather>
    private val otherList = arrayListOf<Weather>(Weather("Belgorod", 0))

    init {
        weatherList = arrayListOf(
                Weather("Москва", -5),
                Weather("Воронеж", 3),
                Weather("Орел", -5),
                Weather("Курск", 10),
                Weather("Белгород", -7),
                Weather("Тула", -12)
        )
        otherList.add(Weather("Орёл", 4))
    }

//     Сокращенный вариант ниже
    fun getWeather(): List<Weather> {
        for (w in weatherList) {
            Log.d("", w.town)
        }
        for (w in 1..10) {
            Log.d("", w.toString())
        }
        for (w in 10 downTo 1 step 2) {
            Log.d("", w.toString())
        }
        return weatherList;
    }

//    fun getWeather() = weatherList;

    fun addWeather(weather: Weather, id: Int) {
        otherList.add(weather)
    }

    fun getItemCount() = weatherList.size
}