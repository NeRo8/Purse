package com.example.nero.purse.purse

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.nero.purse.R
import com.example.nero.purse.database.purse.Purse

class PurseAdapter internal constructor(context: Context, val onUpdate: (Purse) -> Unit) :
        RecyclerView.Adapter<PurseAdapter.PurseViewHolder>() {

    private var purseList = emptyList<Purse>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurseViewHolder {
        return PurseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_purse_view, parent, false))
    }

    inner class PurseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val purseName by lazy { view!!.findViewById<TextView>(R.id.tv_purse_name) }
        val purseImage by lazy { view!!.findViewById<ImageView>(R.id.iv_purse_pictures) }
        val purseValue by lazy { view!!.findViewById<TextView>(R.id.tv_purse_value) }
        val purseType by lazy { view!!.findViewById<TextView>(R.id.tv_purse_type) }
    }

    override fun onBindViewHolder(holder: PurseViewHolder, position: Int) {
        holder.purseName.text = purseList[position].purseName
        holder.purseValue.text = purseList[position].purseValue.toString()
        holder.purseType.text = purseList[position].purseType

        when (purseList[position].purseType) {
            "UAH" -> holder.purseImage.setImageResource(R.drawable.ic_ukraine)
            "USD" -> holder.purseImage.setImageResource(R.drawable.ic_united_states)
            "EUR" -> holder.purseImage.setImageResource(R.drawable.ic_european_union)
        }

        //Вот так релізовується клік по обєкту
        holder.itemView.setOnClickListener {
            onUpdate(purseList[position])
        }
    }

    override fun getItemCount() = purseList.size

    internal fun updatePurseList(purseList: List<Purse>) {
        this.purseList = purseList
        notifyDataSetChanged()
    }
}