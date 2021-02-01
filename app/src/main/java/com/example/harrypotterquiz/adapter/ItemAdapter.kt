package com.example.harrypotterquiz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterquiz.OnCheckedChangeListener
import com.example.harrypotterquiz.R
import com.example.harrypotterquiz.model.Question



class ItemAdapter (
        private val context: Context,
        private val dataset: List<Question>,
        private val onCheckedChangeListener: OnCheckedChangeListener
): RecyclerView.Adapter<ItemAdapter.ImageViewHolder>(){
    class ImageViewHolder(private val view: View, onCheckedChangeListener: OnCheckedChangeListener): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_question)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val radioButton1: RadioButton = view.findViewById(R.id.item_option_1)
        val radioButton2: RadioButton = view.findViewById(R.id.item_option_2)
        val radioButton3: RadioButton = view.findViewById(R.id.item_option_3)
        val radioGroupMain: RadioGroup = view.findViewById(R.id.item_options)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ImageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return ItemAdapter.ImageViewHolder(adapterLayout, onCheckedChangeListener)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ImageViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.radioButton1.text = context.resources.getString(item.option1ResourceId)
        holder.radioButton2.text = context.resources.getString(item.option2ResourceId)
        holder.radioButton3.text = context.resources.getString(item.option3ResourceId)



        holder.radioGroupMain.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener { group, checkedId ->

                    onCheckedChangeListener.onCheckedChanged(position, checkedId)
                    holder.radioButton1.isEnabled= false
                    holder.radioButton2.isEnabled= false
                    holder.radioButton3.isEnabled= false
                })
    }

    override fun getItemCount() = dataset.size


}