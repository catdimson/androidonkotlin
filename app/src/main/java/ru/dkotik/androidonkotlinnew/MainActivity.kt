package ru.dkotik.androidonkotlinnew

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import ru.dkotik.androidonkotlinnew.lesson1.MyDataClassPerson

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var btn: Button? = null

    /*companion object {
        val TAG = "MAIN_ACTIVITY"

        fun doSomething() {

        }
    }*/

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)
        btn?.setOnClickListener(
                View.OnClickListener { Toast.makeText(this@MainActivity, "Hello World", Toast.LENGTH_SHORT).show() }
        )
        Repository.addWeather(Weather("Курск", -5), 9)
        val w = Weather("Грайворон", 6)
        val w2 = Weather("Грайворон", 6)
        //val w3 = w2.copy(town = "Шебекино", temperature = 20)
        val t =
                if (w == w2) {
                    1
                } else {
                    2
                }
        val t2 = w?.town ?: "no towm"
        Repository.addWeather(w, id = 9) // .addWeather(id = 9, weather = w)


        /** Сформировать data class с двумя свойствами и вывести их на экран приложения. */
        val person1 = MyDataClassPerson("Дмитрий", "Невзоров", 29)
        val person2 = MyDataClassPerson("Николай", "Фоменко", 35)
        print(person1.toString())
        print(person2.toString())

        /** Создать Object. В Object вызвать copy и вывести значения скопированного класса на экран. */
        val person1Copy = person1.copy("Александр")
        print(person1Copy)

        /** Вывести значения из разных циклов в консоль, используя примеры из методических материалов. */
        val weatherList = Repository.getWeather();
        for (weather in weatherList) {
            print(weather.toString())
        }
        for (i in 0..(weatherList.size - 1)) {
            print(weatherList.toString())
        }
        for (i in (weatherList.size - 1) downTo 1 step 1) {
            print(weatherList.toString())
        }
        for (i in 0 until weatherList.size) {
            print(weatherList.toString())
        }

        val text: TextView = findViewById(R.id.text_output)
        val btn1: Button = findViewById(R.id.button)
        btn1.setOnClickListener(
                View.OnClickListener {
                    text.setText(person1.toString())
                }
        )
        val btn2: Button = findViewById(R.id.button2)
        btn2.setOnClickListener(
                View.OnClickListener {
                    text.setText(person2.toString())
                }
        )
        val btn3: Button = findViewById(R.id.button3)
        btn3.setOnClickListener(
                View.OnClickListener {
                    text.setText(person1Copy.toString())
                }
        )
    }

    override fun onClick(v: View?) {
        val result = when(v?.id) {
            R.id.button -> 0
            R.id.button2 -> 1
            R.id.button3 -> 2
//            R.id.button -> {}
//            R.id.button2 -> {}
//            R.id.button3 -> {}
            else -> 3
        }
    }
}