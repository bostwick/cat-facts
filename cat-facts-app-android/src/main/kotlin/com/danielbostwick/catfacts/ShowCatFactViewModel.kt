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
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CatFactShowViewModel : ViewModel() {

    companion object {
        const val TAG = "CatFactShowViewModel"
    }

    private val catFactsApi: CatFactsApi = CatFactsApp.instance.services.catFactsApi

    private val _catFact: MutableLiveData<CatFact> = MutableLiveData()
    private val _catFactAuthor: MutableLiveData<CatFactAccount> = MutableLiveData()
    private val _navigateBack: SingleLiveEvent<Any> = SingleLiveEvent()

    val catFact: LiveData<CatFact>
        get() = _catFact
    val catFactAuthor: LiveData<CatFactAccount>
        get() = _catFactAuthor
    val navigateBackEvents: LiveData<Any>
        get() = _navigateBack

    @SuppressLint("CheckResult")
    fun fetchCatFact(catFactId: UUID) {
        catFactsApi.fetchCatfact(catFactId)
            .doOnSuccess(_catFact::postValue)
            .flatMap { catFactsApi.fetchAccount(it.authorId) }
            .doOnSuccess(_catFactAuthor::postValue)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, ::logError)
    }

    fun onNavigationBackClicked() {
        _navigateBack.call()
    }

    private fun logError(t: Throwable) {
        Log.e(TAG, Log.getStackTraceString(t))
    }
}
