package com.ebookfrenzy.whatthechuck.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.ebookfrenzy.whatthechuck.utils.ChuckNorrisFactRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val chuckNorrisFactMutableLiveData: MutableLiveData<ChuckNorrisFact> = MutableLiveData()
    val chuckNorrisFactLiveData : LiveData<ChuckNorrisFact> = chuckNorrisFactMutableLiveData

    suspend fun setChuckNorrisFact(){
        val fact = get()
        chuckNorrisFactMutableLiveData.postValue(fact)
    }

    suspend fun get(): ChuckNorrisFact =
        withContext(Dispatchers.IO){
            ChuckNorrisFactRequest.getChuckNorrisFactFromAPI()
        }
}