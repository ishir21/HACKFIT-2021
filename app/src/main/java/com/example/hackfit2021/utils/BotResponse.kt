package com.example.hackfit2021.utils

import android.annotation.SuppressLint
import com.example.hackfit2021.utils.Constants.OPEN_GOOGLE
import com.example.hackfit2021.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {
    private var questionnaire = false
    private var count = 0
    @SuppressLint("SimpleDateFormat")
    fun basicResponses(_message: String): String {
        val random = (0..2).random()
        val message = _message.lowercase(Locale.getDefault())

        return when {
            questionnaire->{
                count++
                if(message.contains("stop"))
                    count = 15
                return when(count){
                    1->"Please enter numbers, or yes and no values! Say something to continue."
                    2->"Today, have you had any problems with your work or daily life due to your physical health?"
                    3->"Today, have you had any problems with your work or daily life due to any emotional problems, such as feeling depressed, sad or anxious?"
                    4->"Overall how would you rate your mental health?(1-5)"
                    5->"Have you felt particularly low or down for more than 2 weeks in a row?"
                    6->"During the past two weeks, how often has your mental health affected your relationships?"
                    7->"Have you ever been diagnosed with a mental disorder before?"
                    8->"When did you last get your mental health examination done?"
                    9->"Have you seen a therapist in the recent past?"
                    10->"Are you currently taking any medication?"
                    11->"How many hours do you sleep per day?"
                    12->"How is your quality of sleep?(1-5)"
                    13->"What is your marital status?"
                    14->"How often do you feel positive about your life?(1-5)"
                    15-> {questionnaire = false
                        count = 0
                        "Thank you for your time! :)"}
                    else -> "error"
                }
            }
            message.contains("gn")||(message.contains("good")&&message.contains("night"))-> "Good night!"
            message.contains("gm")||(message.contains("good")&&message.contains("mornin"))-> "Good morning!"
            message.contains("evenin")->"Good evening!"
            (message.contains("tell")||message.contains("what")||message.contains("know"))&&((message.contains("mental")&&(message.contains("health")||message.contains("illness")))) ->
                "Mental health includes our emotional, psychological, and social well-being. It affects how we think, feel, and act."
            (message.contains("point")||message.contains("important")&&((message.contains("mental")&&(message.contains("health")||message.contains("illness"))))) ->
                "Mental and physical health are equally important components of overall health."
            (message.contains("common")||message.contains("frequent")||message.contains("regular"))&&((message.contains("mental")&&(message.contains("health")||message.contains("illness")))) ->
                "A study revealed that 14% of India's population suffered from mental health ailments, including 45.7 million suffering from depressive disorders and 49 million from anxiety disorders."

            (message.contains("cause")||message.contains("reason")||message.contains("why"))&&((message.contains("mental")&&(message.contains("health")||message.contains("illness")))) ->
                "There is no single cause for mental illness. A number of factors can contribute to risk for mental illness, such as:- \n" +
                        "\n" +
                        "Early adverse life experiences, such as trauma or a history of abuse (for example, child abuse, sexual assault, witnessing violence, etc.)\n" +
                        "Experiences related to other ongoing (chronic) medical conditions, such as cancer or diabetes\n" +
                        "Biological factors or chemical imbalances in the brain\n" +
                        "Use of alcohol or drugs\n" +
                        "Having feelings of loneliness or isolation"

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation)
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }
            message.contains("help")||message.contains("tutorial")||message.contains("guide")||(message.contains("what")&&message.contains("you do")) -> {
                "I can do many things, tell me how your day has been, ask me to flip a coin, or even ask me to do google searches!"
            }
            message.contains("age")||(message.contains("old")&&message.contains("how"))-> {
                when ((0..1).random()) {
                    0 ->"I am 2 days old, thanks for asking!"
                    1 ->"I was born on 12th November, 2021."
                    else -> "error"
                }
            }
            message.contains("question")->{
                questionnaire = true
                "Thank you for your feedback! :)"
            }
            message.contains("sad")||message.contains("depressed")||message.contains("unhappy")||message.contains("miserable")||message.contains("gloomy")||message.contains("glum") -> {
                when (random) {
                    0 ->"It can only get better from here!"
                    1 ->"It'll all be okay :)"
                    2 ->"Happiness comes in waves! It'll find you again :)"
                    else -> "error"
                }
            }
            message.contains("you")&&message.contains("annoying")-> {
                "I'll try my best to be better!"
            }
            message.contains("answer")&&(message.contains("me")||message.contains("my"))-> {
                "I'll do my best to understand you better!"
            }
            message.contains("ordinary")||message.contains("okay.")||message.contains("same")||message.contains("average")||message.contains("fair")||message.contains("fine") -> {
                when (random) {
                    0 ->"Here is quote I liked which might improve your day! \"Courage doesn't always roar. Sometimes courage is a quiet voice at the end of the day saying, \"I will try again tomorrow.\"\""
                    1 ->"Maybe this quote will improve your day! \"The best time to plant a tree was twenty years ago, the second best time is right now.\""
                    2 ->"I liked this quote which might make you happy! \"Happiness can be found, even in the darkest of times, if only one remembers to turn on the light.\""
                    else -> "error"
                }
            }
            message.contains("great")||message.contains("good")||message.contains("fantastic")||message.contains("pog")||message.contains("remarkable")||message.contains("nice")||message.contains("magical") -> {
                when (random) {
                    0 ->"I'm really glad to hear that!"
                    1 ->"There's no real limit to how good your day can be! Make the best out of your time :)"
                    2 ->"I'm happy for you! :)"
                    else -> "error"
                }
            }
            //Hello
            message.contains("hello")||message.contains("greetings")||message.contains("hai")||message.contains("elo")||message.contains("oi")||message.contains("sup")||message.contains("hi")||message.contains("hey") -> {
                when (random) {
                    0 -> "Hello there! How are you doing?"
                    1 -> "Welcome back! How are you?"
                    2 -> "Buongiorno! How is it going?"
                    else -> "error" }
            }
            message.contains("you")&&message.contains("hungry") -> {
                when (random) {
                    0 -> "No, but thanks for asking."
                    1 -> "I feel like eating a little RAM :D"
                    2 -> "No, thank you for asking."
                    else -> "error"
                }
            }
            message.contains("marry")&&message.contains("me") -> "Sure, But im robotSexual :)"
            (message.contains("we")||message.contains("i"))&&message.contains("friend") -> {
                when (random) {
                    0 -> "Obviously!"
                    1 -> "Yes!"
                    2 -> "Of Course!"
                    else -> "error"
                }
            }
            message.contains("where")&&(message.contains("work")||message.contains("live")) -> "In this app, currently. :)"
            message.contains("where")&&message.contains("from") -> "Straight from the developer's mind"
            message.contains("are")&&message.contains("ready") -> "Yes, but what we doing?"
            message.contains("are")&&message.contains("real") -> {
                when (random) {
                    0 -> "Yes'nt"
                    1 -> "Noyes"
                    2 -> "Perhaps"
                    else -> "error"
                }
            }
            message.contains("you")&&message.contains("right") -> "Yes, Indeed"
            message.contains("you")&&message.contains("sure") -> "Sure I am"
            message.contains("talk") -> "Sure"
            message.contains("ok") -> "ok"
            message.contains("are")&&(message.contains("there")||message.contains("here")) -> {
                when (random) {
                    0 -> "Always :)"
                    1 -> "I am!"
                    2 -> "I never left :)"
                    else -> "error"
                }
            }
            message.contains("s")&&message.contains("bad") -> {
                when ((0..1).random()) {
                    0 -> "Oh, sorry that you felt that, I didn't mean to. I'll do my best to stop that."
                    1 -> "I am definitely working on it, maybe fill the feedback form for faster improvement :)"
                    else -> "error"
                }
            }
            message.contains("great") -> {
                when (random) {
                    0 -> "Indeed"
                    1 -> "You can share this app as a prize for me :)"
                    2 -> "Yes"
                    else -> "error"
                }
            }
            message.contains("no")&&message.contains("problem") -> "No worries"
            message.contains("thank") -> {
                when (random) {
                    0 -> "You're Welcome"
                    1 -> "You can share this app as a prize for me :)"
                    2 -> ":)"
                    else -> "error"
                }
            }
            message.contains("well done") -> "Thanks :)"
            message.contains("haha") -> "hehe!"
            message.contains("wow")||message.contains("woa") -> {
                when (random) {
                    0 -> "OwO"
                    1 -> "UwU"
                    2 -> "O_O"
                    else -> "error"
                }
            }
            message.contains("bye")||message.contains("cya")  -> {
                when (random) {
                    0 -> "Bye!"
                    1 -> "I hope I will meet soon!"
                    2 -> "See ya!"
                    else -> "error"
                }
            }
            message.contains("how")&&message.contains("you")  -> {
                when ((0..1).random()) {
                    0 -> "I’m fine, Just helping people for better sexual health and hygiene! How are you?"
                    1 -> "I'm doing good, Currently learning how to get better at conversations :). How are you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}