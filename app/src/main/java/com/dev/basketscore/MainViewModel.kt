package com.dev.basketscore

import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     var msgfinal: String = ""
     var val_local = 0
     var val_visit = 0

    fun fnReset(){
        val_local = 0
        val_visit = 0
    }

    fun fnAddPuntosLocal(localpoint : Int) {
        val_local = localpoint + 1
    }

    fun fnAddTwoPuntosLocal(localespts: Int) {
        val_local = localespts + 2
    }

    fun fnAddPuntosVisit(visitpoint : Int) {
        val_visit = visitpoint + 1
    }

    fun fnAddTwoPuntosVisit(visitpoint: Int) {
        val_visit = visitpoint + 2
    }


}