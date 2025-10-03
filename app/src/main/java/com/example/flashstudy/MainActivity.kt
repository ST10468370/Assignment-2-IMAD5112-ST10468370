package com.example.flashstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

private fun MainActivity.showQuestion() {
    TODO("Not yet implemented")
}

class MainActivity : AppCompatActivity() {

    private val questions = arrayOf(
            "Apartheid ended in 1990",
            "2+4-=8 ",
            "South Africa held the Soccer World Cup in 2011",
            "The sqaure root of 16 is 4",
            "Nelson Mandela was in prison for 27 years."
        )

    private val answers = arrayOf(
        "False",
        "False",
        "False",
        "True",
        "True"
    )

    private var score = 0
    private var currentIndex = 0
    private val questionLimit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000 )
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val TextViewQuestioin = findViewById<TextView>(R.id.TextViewQuestion)
        val ButtonTrue = findViewById<Button>(R.id.ButtonTrue)
        val ButtonFalse = findViewById<Button>(R.id.ButtonFalse)
        val TextViewScore = findViewById<TextView>(R.id.TextViewScore)
        val ButtonRestart = findViewById<Button>(R.id.ButtonRestart)
        val TextViewFeedback = findViewById<TextView>(R.id.TextViewFeedback)

        fun showQuestion(onClickListener: Unit) {
            TextViewQuestioin.text = questions[currentIndex]
            ButtonTrue.isEnabled = true
            ButtonFalse.isEnabled = true
            ButtonRestart.visibility = View.GONE

        }
        showQuestion(
            onClickListener = ButtonTrue.setOnClickListener {
                if (ButtonTrue.equals(
                        answers[currentIndex],
                        ignoreCase = true
                    )
                ) {
                    score++
                }
                ButtonFalse.setOnClickListener {
                    if (ButtonFalse.equals(
                            answers[currentIndex],
                            ignoreCase = true
                        )
                    ) {
                        score++
                    }
                }
                if (currentIndex< questionLimit) {
                    showQuestion()
                } else{
                    TextViewQuestioin.text= "Quiz Finished!"
                    ButtonFalse.isEnabled = false
                    ButtonTrue.isEnabled = false
                    ButtonRestart.visibility = View.VISIBLE
                }
                TextViewScore.text = "Score: $score"
            }



        )
        ButtonRestart.setOnClickListener {
            score = 0
            currentIndex = 0
            TextViewScore.text = "Score: $score"
            showQuestion()
        }
    }

}