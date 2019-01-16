package com.danielbostwick.catfacts.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danielbostwick.catfacts.core.model.CatFact

class CatFactsAdapter : RecyclerView.Adapter<CatFactListItemViewHolder>() {

    private val data: MutableList<CatFact> = mutableListOf()

    var onItemClickedListener: ((CatFact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactListItemViewHolder =
        CatFactListItemViewHolder(parent.context)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatFactListItemViewHolder, position: Int) {
        val view = holder.itemView as CatFactListItemView
        val catFact = data[position]

        view.catFact = catFact
        view.setOnClickListener { onItemClickedListener?.invoke(catFact) }
    }

    fun updateData(catfacts: List<CatFact>) {
        data.clear()
        data.addAll(catfacts)
        notifyDataSetChanged()
    }
}
