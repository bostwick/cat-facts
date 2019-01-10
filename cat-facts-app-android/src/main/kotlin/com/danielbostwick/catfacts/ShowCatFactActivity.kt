package com.danielbostwick.catfacts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.danielbostwick.catfacts.databinding.ActivityCatFactShowBinding

class CatFactShowActivity : BaseActivity(), Intents.ShowCatFact.Arguments {

    private lateinit var binding: ActivityCatFactShowBinding
    private lateinit var viewModel: CatFactShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_fact_show)
        viewModel = ViewModelProviders.of(this).get(CatFactShowViewModel::class.java)

        binding.toolbar.setNavigationOnClickListener { viewModel.onNavigationBackClicked() }

        viewModel.catFact.observe(this, Observer { binding.catFact = it })
        viewModel.catFactAuthor.observe(this, Observer { binding.author = it })
        viewModel.navigateBackEvents.observe(this, Observer { finish() })
    }

    override fun onStart() {
        super.onStart()
        viewModel.fetchCatFact(argCatFactId)
    }
}
