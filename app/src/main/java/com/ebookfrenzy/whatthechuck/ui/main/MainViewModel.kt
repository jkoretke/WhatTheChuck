package com.ebookfrenzy.whatthechuck.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.ebookfrenzy.whatthechuck.utils.ChuckNorrisFactRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var chuckNorrisFact: MutableLiveData<ChuckNorrisFact> = MutableLiveData()

    fun getChuckNorrisFactLiveData(): MutableLiveData<ChuckNorrisFact>{

        var fact = ChuckNorrisFact()
        viewModelScope.launch(Dispatchers.IO) {
            fact = ChuckNorrisFactRequest.getChuckNorrisFact()
        }

        chuckNorrisFact.value = fact
        return chuckNorrisFact
    }
}