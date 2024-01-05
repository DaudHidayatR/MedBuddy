package com.android.myapplication

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIApi {
    @Headers("Content-Type: application/json", "Authorization: Bearer ")
    @POST("v1/chat/completions")
    suspend fun generateResponse(@Body requestBody: OpenAIRequestBody): OpenAIResponse
}

data class OpenAIRequestBody(
    val model: String = "gpt-3.5-turbo",
    val messages: List<Message>,
    val max_tokens: Int = 70,
    val n: Int = 1,
    val temperature: Double = 0.0
)

data class OpenAIResponse(
    val choices: List<MessageResponse>
)

data class MessageResponse(
    val message: Message
)