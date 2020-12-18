package com.example.gantestapplication.services

import com.example.gantestapplication.models.BreakingCharacters
import retrofit2.Call
import retrofit2.http.GET

interface BreakingCharacterServices {

    @GET("characters")
    fun getBreakingBadCharacterList(): Call<List<BreakingCharacters>>
}