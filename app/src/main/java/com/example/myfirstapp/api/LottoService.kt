package com.example.myfirstapp.api

import com.example.myfirstapp.data.LottoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface LottoService {
    @GET("common.do")
    suspend fun getLottoNumber(
        @Query("drwNo") num: Int,    // 회차 정보
        @Query("method") method: String = "getLottoNumber"
    ): LottoModel
}