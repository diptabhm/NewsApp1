package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class categoryRvAdapter(private var categoryRVmodals: ArrayList<Category>,
                        private var context: Context,
                        private var CategoryClickInterface: Categorycilckinterface):
                        RecyclerView.Adapter<categoryRvAdapter.ViewHolder>() {


         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
             val itemView = LayoutInflater.from(parent.context).inflate(R.layout.categories_items, parent, false)
              return categoryRvAdapter.ViewHolder(itemView)
        }

          override fun onBindViewHolder(holder: ViewHolder, position: Int) {
              val currentItem = categoryRVmodals[position]
              holder.categoryTV.text = currentItem.category
              Picasso.get().load(currentItem.categoryImageUrl).into(holder.CategoryIm)

              holder.itemView.setOnClickListener {
                  CategoryClickInterface.onCategoryClick(position)
              }
          }

        override fun getItemCount(): Int {
            return categoryRVmodals.size
        }

    interface Categorycilckinterface{
        fun onCategoryClick(position: Int)
    }

        class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
            var categoryTV : TextView = itemView.findViewById(R.id.category_text)
            var CategoryIm : ImageView = itemView.findViewById(R.id.image_category)
        }

    }
