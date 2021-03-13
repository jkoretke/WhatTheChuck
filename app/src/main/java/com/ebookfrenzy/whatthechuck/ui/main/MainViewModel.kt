package com.ebookfrenzy.whatthechuck.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.ebookfrenzy.whatthechuck.utils.ChuckNorrisFactRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var fact = ChuckNorrisFact()
    private val chuckNorrisFactMutableLiveData: MutableLiveData<ChuckNorrisFact> = MutableLiveData()
    val chuckNorrisFactLiveData : LiveData<ChuckNorrisFact> = chuckNorrisFactMutableLiveData

    fun getChuckNorrisFact(){
        viewModelScope.launch(Dispatchers.IO) {
            fact = ChuckNorrisFactRequest.getChuckNorrisFactFromAPI()
            chuckNorrisFactMutableLiveData.postValue(fact)
        }
    }
}