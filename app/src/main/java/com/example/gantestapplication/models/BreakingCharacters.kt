package com.example.gantestapplication.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class BreakingCharacters  (

    val appearance: List<Int>,
    val birthday: String,
    val category: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
    ):Parcelable
