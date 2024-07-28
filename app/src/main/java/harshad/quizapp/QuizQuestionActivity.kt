package harshad.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var  mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    private var musername:String? = null
    private var mcorrectanswer : Int = 0


    private var progressBar : ProgressBar? = null
    private var tvprogress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivimage : ImageView? = null

    private var tvoptionone : TextView? = null
    private var tvoptiontwo : TextView? = null
    private var tvoptionthree : TextView? = null
    private var tvoptionfour : TextView? = null

    private var btnSubmit : Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        musername = intent.getStringExtra(Constants.USER_NAME)


        progressBar = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivimage = findViewById(R.id.iv_image)

        tvoptionone = findViewById(R.id.tv_option_one)
        tvoptiontwo = findViewById(R.id.tv_option_two)
        tvoptionthree = findViewById( R.id.tv_option_three)
        tvoptionfour = findViewById(R.id.tv_option_four)

        btnSubmit = findViewById((R.id.btn_submit))

        tvoptionone?.setOnClickListener (this)
        tvoptiontwo?.setOnClickListener (this)
        tvoptionthree?.setOnClickListener (this)
        tvoptionfour?.setOnClickListener (this)
        btnSubmit?.setOnClickListener (this)



        mQuestionList  = Constants.getQuestions()


        SetQuestion()


    }

    private fun SetQuestion() {

       DeafultOptionView()

        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvprogress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvoptionone?.text = question.optionone
        tvoptiontwo?.text = question.optiontwo
        tvoptionthree?.text = question.optionthree
        tvoptionfour?.text = question.optiofour

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }
       private fun DeafultOptionView (){
           val options = ArrayList<TextView>()
           tvoptionone?.let {
               options.add(0,it)
               tvoptiontwo?.let {
                   options.add(1, it)
                   tvoptionthree?.let {
                       options.add(2, it)
                       tvoptionfour?.let {
                           options.add(3, it)
                       }
                       for (option in options) {
                           option.setTextColor(Color.parseColor("#7A8089"))
                           option.typeface = Typeface.DEFAULT
                           option.background = ContextCompat.getDrawable(
                               this, R.drawable.border_bg
                           )

                       }
                   }
               }
           }
       }
    private fun selectedOptionView(tv: TextView, selectoptionNum: Int) {
        DeafultOptionView()
        mSelectedOptionPosition = selectoptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
       when (view?.id){
           R.id.tv_option_one -> {
              tvoptionone?.let {
                  selectedOptionView(it,1)
              }
           }
           R.id.tv_option_two -> {
               tvoptiontwo?.let {
                   selectedOptionView(it,2)
               }
           }
           R.id.tv_option_three -> {
               tvoptionthree?.let {
                   selectedOptionView(it,3)
               }
           }
           R.id.tv_option_four -> {
               tvoptionfour?.let {
                   selectedOptionView(it,4)
               }
           }
           R.id.btn_submit ->{
               if (mSelectedOptionPosition == 0){
                   mCurrentPosition++
                   when{
                       mCurrentPosition <= mQuestionList!!.size ->{
                           SetQuestion()
                       }
                       else->{
                           val intent = Intent(this,ResultActivity::class.java)
                           intent.putExtra(Constants.USER_NAME,musername)
                           intent.putExtra(Constants.CORRECT_ANSWER,mcorrectanswer)
                           intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                           startActivity(intent)
                           finish()

                       }
                   }
               }else{
                   val question = mQuestionList?.get(mCurrentPosition-1)
                   if (question!!.correctanswer!=mSelectedOptionPosition){
                       answerview(mSelectedOptionPosition,R.drawable.wrong_border_bg)
                   }else{
                       mcorrectanswer++
                   }
                   answerview(question.correctanswer,R.drawable.correct_border_bg)

                   if (mCurrentPosition == mQuestionList!!.size){
                       btnSubmit?.text = "FINISH"
                   }else{
                       btnSubmit?.text = "Go TO Next Question"
                   }
                   mSelectedOptionPosition =  0
               }

           }
       }
    }

    private fun answerview (answer:Int,drawableView:Int){
        when(answer){
            1->{
                tvoptionone?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                tvoptiontwo?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,drawableView
                )
            }
            3->{
                tvoptionthree?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,drawableView
                )
            }
            4->{
                tvoptionfour?.background = ContextCompat.getDrawable(
                    this@QuizQuestionActivity,drawableView
                )
            }
        }
    }
}