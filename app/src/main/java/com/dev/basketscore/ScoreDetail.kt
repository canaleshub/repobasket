package com.dev.basketscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dev.basketscore.databinding.ActivityScoreDetailBinding
import kotlinx.android.synthetic.main.activity_score_detail.*

class ScoreDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityScoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val score_entity = bundle.getParcelable<ScoreEntity>("SCORE_KEY")!!

        binding.resultado.text =score_entity.msgfinal
        binding.score.text = score_entity.local.plus(" - ").plus(score_entity.visit)
    }
}