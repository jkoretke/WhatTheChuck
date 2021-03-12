package com.ebookfrenzy.whatthechuck.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.ebookfrenzy.whatthechuck.utils.ChuckNorrisFactRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var chuckNorrisFactLiveData: MutableLiveData<ChuckNorrisFact> = MutableLiveData()

    fun setChuckNorrisFact(){
        var fact = ChuckNorrisFact()
        viewModelScope.launch(Dispatchers.IO) {
            fact = ChuckNorrisFactRequest.getChuckNorrisFact()
        }

        chuckNorrisFactLiveData.value = fact


    }


}