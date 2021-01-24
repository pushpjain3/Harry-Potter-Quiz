package com.example.harrypotterquiz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterquiz.R
import com.example.harrypotterquiz.model.Question

class ItemAdapter (
    private val context: Context,
    private val dataset: List<Question>,
    private val onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<ItemAdapter.ImageViewHolder>(){
    class ImageViewHolder(private val view: View, onItemClickListener: OnItemClickListener ): RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.item_question)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val radioButton1: RadioButton = view.findViewById(R.id.item_option_1)
        val radioButton2: RadioButton = view.findViewById(R.id.item_option_2)
        val radioButton3: RadioButton = view.findViewById(R.id.item_option_3)

        init{
            view.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ImageViewHolder(adapterLayout, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.radioButton1.text = context.resources.getString(item.option1ResourceId)
        holder.radioButton2.text = context.resources.getString(item.option2ResourceId)
        holder.radioButton3.text = context.resources.getString(item.option3ResourceId)


        holder.radioButton1.setOnClickListener {
            if(holder.radioButton1.isChecked) {
                holder.radioButton2.isChecked = false
                holder.radioButton3.isChecked = false
//                MainActivity.MARKED_OPTIONS[position] = item.option1ResourceId
            }

        }
        holder.radioButton2.setOnClickListener {
            if(holder.radioButton2.isChecked){
            holder.radioButton1.isChecked = false
            holder.radioButton3.isChecked = false
//            MainActivity.MARKED_OPTIONS[position] = item.option2ResourceId
        }
        }
       holder.radioButton3.setOnClickListener {
           if(holder.radioButton3.isChecked){
           holder.radioButton1.isChecked = false
           holder.radioButton2.isChecked= false
//           MainActivity.MARKED_OPTIONS[position] = item.option3ResourceId
       }  }

    }

    override fun getItemCount() = dataset.size

    interface OnItemClickListener {
        fun onClick(position: Int)
        fun onLongClick(position: Int)

    }


}