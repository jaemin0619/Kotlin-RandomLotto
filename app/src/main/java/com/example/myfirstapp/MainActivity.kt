package com.example.myfirstapp
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberOne = findViewById<TextView>(R.id.number_one)
        val numberTwo = findViewById<TextView>(R.id.number_two)
        val numberThree = findViewById<TextView>(R.id.number_three)
        val numberFour = findViewById<TextView>(R.id.number_four)
        val numberFive = findViewById<TextView>(R.id.number_five)
        val numberSix = findViewById<TextView>(R.id.number_six)
        val numberBonus = findViewById<TextView>(R.id.number_bonus)
        val randomButton = findViewById<Button>(R.id.random_button)

        randomButton.setOnClickListener {
            val winNumbers = generateLottoNumbers().sorted()
            numberOne.text = winNumbers[0].toString()
            numberTwo.text = winNumbers[1].toString()
            numberThree.text = winNumbers[2].toString()
            numberFour.text = winNumbers[3].toString()
            numberFive.text = winNumbers[4].toString()
            numberSix.text = winNumbers[5].toString()
            numberBonus.text = winNumbers[6].toString()
            //val winNumbersView = listOf(numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberBonus)
            //winNumbers.mapIndexed { index, number -> winNumbersView[index].text = number.toString() }
        }
    }

    private fun generateLottoNumbers(): Set<Int> {
        val numbers = mutableSetOf<Int>()
        while (numbers.size < 7) {
            val randomNumber = Random.nextInt(1, 46) // 1부터 45까지의 숫자 중 랜덤 선택
            numbers.add(randomNumber)
        }
        return numbers
    }
}