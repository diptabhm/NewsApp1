package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.NonDisposableHandle.parent

class newsRvAdapter(private var articlesArraylist: ArrayList<Article>, private var context: Context): RecyclerView.Adapter<newsRvAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.new_rv_item, parent, false)
        return newsRvAdapter.ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articlesArraylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = articlesArraylist[position]
        holder.heading.text = currentItem.title
        holder.subheading.text = currentItem.description
        Picasso.get().load(currentItem.urlToImage).into(holder.Imageurl)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, News_details::class.java)
            intent.putExtra("title",currentItem.title)
            intent.putExtra("content",currentItem.content)
            intent.putExtra("description",currentItem.description)
            intent.putExtra("image",currentItem.urlToImage)
            intent.putExtra("url",currentItem.url)
            context.startActivity(intent)
        }
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var heading : TextView = itemView.findViewById(R.id.News_headline)
        var subheading : TextView = itemView.findViewById(R.id.Subheading)
        var Imageurl : ImageView = itemView.findViewById(R.id.News_image)
    }

}

//class filterAdapter(private var dataList: ArrayList<filterData>) :
//    RecyclerView.Adapter<filterAdapter.MyViewHolder>() {
//
//    var selectedItemPosition: Int = 0
//    private lateinit var mListener : onItemClickListener
//
//    interface onItemClickListener{
//
//        fun onItemClick(category: String)
//
//    }
//
//    fun setOnItemClickListener(listener: onItemClickListener){
//
//        mListener = listener
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): filterAdapter.MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.filter_item,
//            parent, false)
//        return filterAdapter.MyViewHolder(itemView,mListener)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = dataList[position]
//        holder.category.text = currentItem.category
//
//        holder.itemView.setOnClickListener {
//            selectedItemPosition = position
//            notifyDataSetChanged()
//            mListener.onItemClick(currentItem.category)
//        }
//
//        if(selectedItemPosition == position)
//            holder.itemView.findViewById<LinearLayout>(R.id.item_linearl).setBackgroundColor(Color.parseColor("#FDC102"))
//        else
//            holder.itemView.findViewById<LinearLayout>(R.id.item_linearl).setBackgroundColor(Color.parseColor("#FFFFFF"))
//    }
//
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    class MyViewHolder (itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
//        var category : TextView = itemView.findViewById(R.id.category)
//
//    }
//
//}

