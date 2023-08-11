package com.example.libarayapp.data

import Items
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit
import java.io.IOException

class Curtain {
    interface Callback {
        fun onSuccess(items: List<Items>)
        fun onFailure(errorMessage: String)
    }

    fun call(category: String, callback: Callback) {
        val apiService = retrofit.apiServiceInstance()

        CoroutineScope(Dispatchers.Default).launch {
            try {
                val response = apiService.getBooks(category)

                if (response.isSuccessful) {
                    val result = response.body()?.items ?: emptyList()
                    callback.onSuccess(result)
                } else {
                    val errorMessage = "Error: ${response.code()} - ${response.message()}"
                    callback.onFailure(errorMessage)
                }
            } catch (e: IOException) {
                e.printStackTrace()

            }
        }
    }
}