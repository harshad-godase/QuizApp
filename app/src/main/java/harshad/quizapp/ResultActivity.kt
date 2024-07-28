package harshad.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName : TextView = findViewById(R.id.tv_name)
        val tvscore : TextView = findViewById(R.id.tv_score)
        val btnfinish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        val totalquestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctanswer = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        tvscore.text = "Your Score is $correctanswer out of $totalquestion"
        btnfinish.setOnClickListener{
        startActivity(Intent(this,MainActivity::class.java))
      }
    }
}