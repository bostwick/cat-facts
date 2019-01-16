package com.danielbostwick.catfacts.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import com.danielbostwick.catfacts.R
import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.databinding.ViewCatFactListItemBinding

class CatFactListItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = DataBindingUtil.inflate<ViewCatFactListItemBinding>(
        LayoutInflater.from(context), R.layout.view_cat_fact_list_item, this, true
    )

    var catFact: CatFact?
        get() = binding.catFact
        set(value) {
            binding.catFact = value
        }

    var author: CatFactAccount?
        get() = binding.author
        set(value) {
            binding.author = value
        }
}