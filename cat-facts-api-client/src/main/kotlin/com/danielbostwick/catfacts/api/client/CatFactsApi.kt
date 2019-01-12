@file:Suppress("unused")

package com.danielbostwick.catfacts.api.client

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.UUID
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CatFactsApi {

    companion object {
        
        const val API_ROOT_ANDROID_EMULATOR_LOCALHOST = ""

        const val API_ROOT_LOCALHOST = "http://127.0.0.1:8080/"

        const val API_ROOT_PROD = "http://bostwick-cat-facts.herokuapp.com/"

        fun create(apiRoot: String, interceptors: List<Interceptor> = emptyList()): CatFactsApi =
            Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(createObjectMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .baseUrl(apiRoot)
                .client(createOkHttpClient(interceptors))
                .build()
                .create(CatFactsApi::class.java)

        private fun createObjectMapper(): ObjectMapper =
            ObjectMapper().apply {
                registerModule(KotlinModule())

                configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            }

        private fun createOkHttpClient(interceptors: List<Interceptor>): OkHttpClient =
            OkHttpClient.Builder()
                .apply { interceptors.forEach { i -> addInterceptor(i) } }
                .build()
    }

    @GET("account/:id")
    fun fetchAccount(@Path("id") accountId: UUID): Single<CatFactAccount>

    @GET("catfacts")
    fun fetchAllCatFacts(): Single<List<CatFact>>

    @GET("catfact/:id")
    fun fetchCatfact(@Path("id") catfactId: UUID): Single<CatFact>
}
