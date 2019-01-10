package com.danielbostwick.catfacts

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.danielbostwick.catfacts.core.CatFact

class CatFactsAdapter(context: Context) : RecyclerView.Adapter<CatFactListItemViewHolder>() {

    private val data: MutableList<CatFact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactListItemViewHolder =
        CatFactListItemViewHolder(parent.context)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatFactListItemViewHolder, position: Int) {
//        (holder.itemView as CatFactListItemView).viewModel
    }
}

class CatFactListItemViewHolder(context: Context) : RecyclerView.ViewHolder(CatFactListItemView(context))

class CatFactListItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr)
