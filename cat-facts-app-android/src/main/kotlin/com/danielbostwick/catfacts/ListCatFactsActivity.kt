package com.danielbostwick.catfacts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielbostwick.catfacts.ui.CatFactsAdapter

class ListCatFactsActivity : BaseActivity() {

    private lateinit var binding: com.danielbostwick.catfacts.databinding.ActivityListCatFactsBinding
    private lateinit var viewModel: ListCatFactsViewModel
    private val catFactsAdapter: CatFactsAdapter = CatFactsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_cat_facts)
        viewModel = ViewModelProviders.of(this).get(ListCatFactsViewModel::class.java)

        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = catFactsAdapter
        catFactsAdapter.onItemClickedListener = viewModel::onCatFactClicked

        viewModel.catFactEntries.observe(this, Observer {
            catFactsAdapter.updateData(it)
        })
        viewModel.navigateToCatFact.observe(this, Observer { catFactId ->
            startActivity(Intents.ShowCatFact.create(this, catFactId))
        })
    }
}
