package com.danielbostwick.catfacts

import android.app.Application
import com.danielbostwick.catfacts.api.client.CatFactsApi
import okhttp3.logging.HttpLoggingInterceptor

class CatFactsApp : Application() {

    companion object {
        lateinit var instance: CatFactsApp
            private set
    }

    lateinit var services: CatFactAppServices

    override fun onCreate() {
        CatFactsApp.instance = this
        super.onCreate()

        services = CatFactAppServices()
    }

    class CatFactAppServices {
        val catFactsApi: CatFactsApi = CatFactsApi.create(
            apiRoot = CatFactsApi.API_ROOT_ANDROID_EMULATOR_LOCALHOST,
            interceptors = listOf(
                HttpLoggingInterceptor()
            )
        )
    }
}
