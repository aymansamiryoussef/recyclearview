package android.example.recyclearview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class customAdpter(private val listener: MainActivity): RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<news> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem.Title
        holder.author.text = currentItem.Author
        Glide.with(holder.itemView.context).load(currentItem.ImageUrl).into(holder.image)
    }

    fun updateNews(updatedNews: ArrayList<news>) {
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.textOne)
    val image: ImageView = itemView.findViewById(R.id.imageOne)
    val author: TextView = itemView.findViewById(R.id.textTwo)
}

interface NewsItemClicked {
    fun onItemClicked(item: news)
}