package com.dev.basketscore

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ScoreEntity (val local: String, val visit: String, val msgfinal: String) : Parcelable
