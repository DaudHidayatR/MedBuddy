package com.android.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messages = mutableStateListOf<Message>()

    init {
        // Panggil fungsi untuk memulai percakapan saat ViewModel diinisialisasi
        startConversation()
    }

    private fun startConversation() {
        // Tambahkan pesan awal dari sistem
        val systemMessage = "Anda adalah asisten yang suka membantu. balas pesan ini dengan = (Perkenalkan saya Gabut dari OpenAi siap menjawab pertanyaan anda.)"
        messages.add(Message(systemMessage, "system"))

        // Kirim permintaan ke API untuk mendapatkan respons sistem
        viewModelScope.launch {
            val response = ApiService.openAIApi.generateResponse(OpenAIRequestBody(messages = messages))
            messages.add(response.choices.first().message)
        }
    }
    fun sendMessage(text: String, isUser: Boolean = true) {
        messages.add(Message(text, "user"))
        if (isUser) {
            viewModelScope.launch {
                val response = ApiService.openAIApi.generateResponse(OpenAIRequestBody(messages = messages))
                messages.add(response.choices.first().message)
            }
        }
    }
}

data class Message(val content: String, val role: String) {
    val isUser: Boolean
        get() = role == "user"
}