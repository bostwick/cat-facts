package com.danielbostwick.catfacts

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielbostwick.catfacts.api.client.CatFactsApi
import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.util.SingleLiveEvent

class CatFactShowViewModel : ViewModel() {

    private val catFactsApi: CatFactsApi = CatFactsApp.instance.catFactsApi

    private val mutableCatFact: MutableLiveData<CatFact> = MutableLiveData()
    private val mutableCatFactAuthor: MutableLiveData<CatFactAccount> = MutableLiveData()
    private val mutableNavigateBack: SingleLiveEvent<Any> = SingleLiveEvent()

    val catFact: LiveData<CatFact>
        get() = mutableCatFact
    val catFactAuthor: LiveData<CatFactAccount>
        get() = mutableCatFactAuthor
    val navigateBackEvents: LiveData<Any>
        get() = mutableNavigateBack

    @SuppressLint("CheckResult")
    fun fetchCatFact(catFactId: UUID) {
        catFactsApi.fetchCatfact(catFactId)
            .subscribe(mutableCatFact::postValue, ::logError)
    }

    fun onNavigationBackClicked() {
        mutableNavigateBack.call()
    }

    private fun logError(t: Throwable) {
        Log.e(CatFactsListViewModel.TAG, Log.getStackTraceString(t))
    }
}
