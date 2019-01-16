package com.danielbostwick.catfacts

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielbostwick.catfacts.api.client.CatFactsApi
import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.type.UUID
import com.danielbostwick.catfacts.util.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListCatFactsViewModel : ViewModel() {

    companion object {
        const val TAG = "ListCatFactsViewModel"
    }

    private val catFactsApi: CatFactsApi = CatFactsApp.instance.services.catFactsApi

    private val _catFactEntries: MutableLiveData<List<CatFact>> = MutableLiveData()
    private val _navigationToCatFact: SingleLiveEvent<UUID> = SingleLiveEvent()

    val catFactEntries: LiveData<List<CatFact>>
        get() = _catFactEntries
    val navigateToCatFact: LiveData<UUID>
        get() = _navigationToCatFact

    init {
        fetchCatFacts()
    }

    fun onCatFactClicked(catFact: CatFact) {
        _navigationToCatFact(catFact.id)
    }

    @SuppressLint("CheckResult")
    private fun fetchCatFacts() {
        catFactsApi.fetchAllCatFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_catFactEntries::postValue, ::logError)
    }

    private fun logError(t: Throwable) {
        Log.e(TAG, Log.getStackTraceString(t))
    }
}
