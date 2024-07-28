package harshad.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_ans"



    fun getQuestions(): ArrayList<Question> {
        val questionlist = ArrayList<Question>()
        val que1 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_india,"Argentina","America",
            "India","Brazil",
            3
        )

        questionlist.add(que1)
        val que2 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_brazil,"Argentina","America",
            "India","Brazil",
            4
        )
        questionlist.add(que2)
        val que3 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_argentina,"Argentina","America",
            "India","Brazil",
            1
        )
        questionlist.add(que3)

        val que4 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_australia,"Argentina","australia",
            "India","Brazil",
            2
        )
        questionlist.add(que1)

        val que5 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_belgium,"belgium","America",
            "India","Brazil",
            1
        )
        questionlist.add(que5)

        val que6 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_fiji,"belgiu","America",
            "India","fiji",
            4
        )
        questionlist.add(que6)

        val que7 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_germany,"India","America",
            "germany","Brazil",
            3
        )
        questionlist.add(que7)

        val que8 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_kuwait,"india","America",
            "kuwait","Brazil",
            3
        )
        questionlist.add(que8)

        val que9 = Question(
            1,"What Country flag This belong to?",
            R.drawable.ic_flag_of_new_zealand,"Argentina","America",
            "India","zealand",
            4
        )
        questionlist.add(que9)
        return questionlist
    }
}