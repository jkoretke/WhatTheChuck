package com.ebookfrenzy.whatthechuck.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.ebookfrenzy.whatthechuck.ChuckNorrisFact
import com.ebookfrenzy.whatthechuck.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private var chuckNorrisFact = ChuckNorrisFact()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val chuckNorrisFactObserver = Observer<ChuckNorrisFact> {
            message.text = it.value
        }

        viewModel.chuckNorrisFactLiveData.observe(viewLifecycleOwner, chuckNorrisFactObserver)

        chuckButton.setOnClickListener {
            viewModel.setChuckNorrisFact()
        }
    }
}