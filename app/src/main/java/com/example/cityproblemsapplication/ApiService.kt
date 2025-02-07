package com.example.cityproblemsapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/submit_problem")
    fun submitProblem(@Body problem: Problem): Call<ResponseMessage>
}

data class ResponseMessage(
    val message: String
)