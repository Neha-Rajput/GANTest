package com.example.gantestapplication.Activities

import com.example.gantestapplication.models.BreakingCharacters
import com.example.gantestapplication.services.BreakingCharacterServices
import com.example.gantestapplication.services.ServiceBuilder
import org.junit.Assert
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ListActivityTest  {



    @Test
    fun  loadBreakingBadCharactersTest() {
        val destinationService = ServiceBuilder.buildService(BreakingCharacterServices::class.java)
        val requestCall = destinationService.getBreakingBadCharacterList()
        var result : List<BreakingCharacters>
        requestCall.enqueue(object : Callback<List<BreakingCharacters>> {
            override fun onResponse(
                call: Call<List<BreakingCharacters>>,
                response: Response<List<BreakingCharacters>>) {
                if(response.isSuccessful){
                    result= response.body()!!
                    Assert.assertEquals(result, requestCall)
                }
            }
            override fun onFailure(call: Call<List<BreakingCharacters>>, t: Throwable) {
                Assert.assertEquals("Some thing went wrong. Please try after some time", requestCall)
            }
        })
    }




}