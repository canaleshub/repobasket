package com.dev.basketscore
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.basketscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    var msgfinal: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnReset.setOnClickListener(){
            fnReset()
        }

        /* LOCAL */
        binding.btnOneLocal.setOnClickListener(){
            val num = viewModel.val_local
            fnAddPuntosLocal(num)
        }

        binding.btnTwoLocal.setOnClickListener(){
            val num = binding.scorelocal.text.toString().toInt()
            fnAddTwoPuntosLocal(num)
        }

        binding.btnNegativeLocal.setOnClickListener(){
            val num = binding.scorelocal.text.toString().toInt()
            fnNegativeLocal(num)
        }

        /* VISITANTE */
        binding.btnOneVisit.setOnClickListener(){
            val num = binding.scorevisit.text.toString().toInt()
            fnAddPuntosVisit(num)
        }

        binding.btnTwoVisit.setOnClickListener(){
            val num = binding.scorevisit.text.toString().toInt()
            fnAddTwoPuntosVisit(num)
        }

        binding.btnNegativeVisit.setOnClickListener(){
            val num = binding.scorevisit.text.toString().toInt()
            fnNegativeVisit(num)
        }

        binding.btnNext.setOnClickListener(){
            val num1 = binding.scorevisit.text.toString().toInt()
            val num2 = binding.scorelocal.text.toString().toInt()
            fnScoreFinal(num1,num2)
        }


    }

    private fun fnScoreFinal(localscore: Int, visitscore: Int) {
        if(localscore>visitscore){
            msgfinal = "Equipo local gana."
        }
        if(visitscore>localscore){
            msgfinal = "Equipo visita gana."
        }
        if(visitscore==localscore){
            msgfinal = "Fue un empate."
        }
        val score = ScoreEntity(localscore.toString(),visitscore.toString(),msgfinal)
        fnOpenDetail(score)
    }

    private fun fnAddPuntosLocal(localpoint : Int) {
        viewModel.fnAddPuntosLocal(localpoint)
        binding.scorelocal.text = viewModel.val_local.toString()
    }

    private fun fnAddTwoPuntosLocal(localespts: Int) {
        viewModel.fnAddTwoPuntosLocal(localespts)
        binding.scorelocal.text = viewModel.val_local.toString()
    }

    private fun fnReset(){
        viewModel.fnReset()
        binding.scorelocal.text = viewModel.val_local.toString()
        binding.scorevisit.text = viewModel.val_visit.toString()
    }

    private fun fnNegativeLocal(localespts: Int) {
        val scoreInt = localespts
        if(scoreInt>0){
            val res = scoreInt - 1
            binding.scorelocal.text = res.toString()
        }else{
            Toast.makeText(this,"El score local llego a cero", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fnAddPuntosVisit(visitpoint : Int) {
        viewModel.fnAddPuntosVisit(visitpoint)
        binding.scorevisit.text = viewModel.val_visit.toString()
    }

    private fun fnAddTwoPuntosVisit(visitpoint: Int) {
        viewModel.fnAddTwoPuntosVisit(visitpoint)
        binding.scorevisit.text = viewModel.val_visit.toString()
    }

    private fun fnNegativeVisit(visitpoint: Int) {
        val scoreInt = visitpoint
        if(scoreInt>0){
            val res = scoreInt - 1
            binding.scorevisit.text = res.toString()
        }else{
            Toast.makeText(this,"El score visita llego a cero", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fnOpenDetail(score : ScoreEntity) {
        val intent = Intent(this,ScoreDetail::class.java)
        intent.putExtra("SCORE_KEY",score)
        startActivity(intent)
    }


}