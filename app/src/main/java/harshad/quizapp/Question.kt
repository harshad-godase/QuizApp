package harshad.quizapp

data class Question(
    val id : Int,
    val question : String,
    val image : Int,
    val optionone : String,
    val optiontwo : String,
    val optionthree : String,
    val optiofour : String,
    val correctanswer : Int
)