package com.example.myfirstapp

import android.util.Log
import com.example.myfirstapp.api.LottoService
import com.example.myfirstapp.api.RetrofitInstance
import com.example.myfirstapp.data.LottoData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "LottoController"

class LottoController(private val service: LottoService = RetrofitInstance.service) {
    fun getLottoNumber(num: Int, onSuccess: (LottoData) -> Unit, onError: (String) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            runCatching {
                val result = withContext(Dispatchers.IO) { service.getLottoNumber(num = num) }
                onSuccess(result.toLottoData())
            }.onFailure {
                Log.e(TAG, "getLottoNumber() failed! : ${it.message}")
                onError(it.message ?: "Unknown error")
            }
        }
    }
}