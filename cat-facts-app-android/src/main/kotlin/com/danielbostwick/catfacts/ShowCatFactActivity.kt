package com.danielbostwick.catfacts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class ShowCatFactActivity : BaseActivity(), Intents.ShowCatFact.Arguments {

    private lateinit var binding: com.danielbostwick.catfacts.databinding.ActivityShowCatFactBinding
    private lateinit var viewModel: CatFactShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_cat_fact)
        viewModel = ViewModelProviders.of(this).get(CatFactShowViewModel::class.java)
        viewModel.fetchCatFact(argCatFactId)

        binding.toolbar.setNavigationOnClickListener { viewModel.onNavigationBackClicked() }

        viewModel.catFact.observe(this, Observer { binding.catFact = it })
        viewModel.catFactAuthor.observe(this, Observer { binding.author = it })
        viewModel.navigateBackEvents.observe(this, Observer { finish() })
    }
}
