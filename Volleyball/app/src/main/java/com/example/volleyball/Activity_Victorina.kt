package com.example.volleyball

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import data.Question
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class Activity_Victorina : AppCompatActivity() {

    private val questionListAspect = listOf(
        Question(
            "Какая высота сетки у мужчин?",
            listOf("2.55 м", "2.43 м", "3.20 м", "2.10 м"),
            1
        ),
        Question(
            "Какой периметр у площадки?",
            listOf("18х9 м", "9х9 м", "10х9 м", "15х8 м"),
            0
        ),
        Question(
            "Из скольки зон состоит площадка?",
            listOf("1", "4", "8", "6"),
            3
        ),
        Question(
            "Какой размер у антенны?",
            listOf("1 м", "2 м", "1.8 м", "1.5 м"),
            2
        ),
        Question(
            "Какая высота сетки у женщин?",
            listOf("2.24 м", "2 м", "100 см", "2.10 м"),
            0
        ),
        Question(
            "Какой элемент волейбола производится из-за лицевой линии?",
            listOf("прием", "пас", "подача", "удар"),
            2
        )
    )


    private val questionListHistory = listOf(
        Question(
            "Кто придумал волейбол?",
            listOf("Уильям Морган", "Майкл Джексон", "Фокичев Сергей", "Фог Аллен"),
            0
        ),
        Question(
            "В каком году волейбол появился на свет?",
            listOf("1900", "1940", "1895", "1800"),
            2
        ),
        Question(
            "В каком городе впервые появился волейбол?",
            listOf("Вашингтон", "Холиск", "Кисловодск", "Новый Орлеан"),
            1
        ),
        Question(
            "Первоначальное название волейбола?",
            listOf("Боллволей", "Нэтболл", "Минтонет", "Воллей"),
            2
        ),
        Question(
            "Сколько нужно было набрать очков для победы в партии до становления современного волейбола?",
            listOf("10", "15", "30", "7"),
            1
        ),
        Question(
            "В каком городе был первый чемпионат мира по волейболу?",
            listOf("Москва", "Париж", "Рим", "Прага"),
            3
        )
    )


    private val questionListRules = listOf(
        Question(
            "Сколько человек находится в каждой команде?",
            listOf("20", "6", "12", "10"),
            1
        ),
        Question(
            "Сколько замен имеет право сделать команда?",
            listOf("1", "4", "9", "6"),
            3
        ),
        Question(
            "Сколько человек может быть в заявке на игру?",
            listOf("6", "10", "20", "14"),
            3
        ),
        Question(
            "Сколько секунд дается на подачу?",
            listOf("5", "8", "10", "3"),
            1
        ),
        Question(
            "Какой игрок на площадке должен иметь другую форму?",
            listOf("либеро", "доигровщик", "связующий", "никто"),
            0
        ),
        Question(
            "Сколько партий нужно выиграть для победы?",
            listOf("5", "1", "3", "6"),
            2
        )
    )


    private val questionListSelection = listOf(
        Question(
            "На каких соревнованиях в волейбол играют сидя?",
            listOf("Паралимпиада", "Чемпионат мира", "Лига чемпионов", "Никакие"),
            0
        ),
        Question(
            "В какой вид спорта играет Олег Стояновский?",
            listOf("Волейбол", "Футбол", "Ганбол", "Пляжный волейбол"),
            3
        ),
        Question(
            "Разновидность пляжного волейбола?",
            listOf("На песке", "На снегу", "На листве", "На камнях"),
            1
        ),
        Question(
            "В какую разновидность волейбола все играли в школе?",
            listOf("Миниволейбол", "Фаустбол", "Пионербол", "Воллибол"),
            2
        ),
        Question(
            "В чем особенность кертнбола?",
            listOf("Плотный материал вместо сетки", "Нет сетки", "Мяч отбивают ногами", "Что это?"),
            0
        )
    )

    private var currentQuestionIndex = 0
    private var correctAnswersCount = 0
    private var currentQuestionList = listOf<Question>()
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victorina)

        textView = findViewById(R.id.textTitleTopic)

        val imageView: ImageView = findViewById(R.id.img_Back)

        val buttonTitle = intent.getStringExtra("BUTTON_TITLE")
        textView.text = buttonTitle

        if (buttonTitle == "Технические аспекты") {
            currentQuestionList = questionListAspect
            displayNextQuestion()
        }
        if (buttonTitle == "История волейбола") {
            currentQuestionList = questionListHistory
            displayNextQuestion()
        }
        if (buttonTitle == "Правила волейбола") {
            currentQuestionList = questionListRules
            displayNextQuestion()
        }
        if (buttonTitle == "Виды волейбола") {
            currentQuestionList = questionListSelection
            displayNextQuestion()
        }

        imageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayNextQuestion() {
        if (currentQuestionIndex < currentQuestionList.size) {
            val nextQuestion = currentQuestionList[currentQuestionIndex]
            displayQuestion(nextQuestion)
        } else {
            val message = "Викторина завершена. Правильных ответов: $correctAnswersCount из ${currentQuestionList.size}"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun displayQuestion(question: Question) {
        val questTitle: TextView = findViewById(R.id.textTitleQuest)
        questTitle.text = question.questionText

        val optionButtonIds = listOf(R.id.optionButton1, R.id.optionButton2, R.id.optionButton3, R.id.optionButton4)
        val optionButtons = optionButtonIds.map { findViewById<Button>(it) }

        if (question.options.size == optionButtons.size) {
            for (i in question.options.indices) {
                optionButtons[i].text = question.options[i]
            }
        }

        setOptionButtonClickListeners(question)
    }

    private fun setOptionButtonClickListeners(question: Question) {
        val optionButtonIds = listOf(R.id.optionButton1, R.id.optionButton2, R.id.optionButton3, R.id.optionButton4)
        val optionButtons = optionButtonIds.map { findViewById<Button>(it) }

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val selectedAnswerIndex = index
                val correctAnswerIndex = question.correctAnswerIndex

                currentQuestionIndex++

                if (selectedAnswerIndex == correctAnswerIndex) {
                    correctAnswersCount++
                }

                displayNextQuestion()
            }
        }
    }
}
