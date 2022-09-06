package android.example.recyclearview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class customAdpter(val list:ArrayList<word>): RecyclerView.Adapter<customAdpter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.listitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.image.setImageResource(current.imagenumber)
        holder.textOne.text=current.textone
        holder.textTwo.text=current.textTwo


    }

    override fun getItemCount(): Int {
        return list.size
    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image :ImageView = itemView.findViewById(R.id.imageOne)
        val textOne :TextView =itemView.findViewById(R.id.textOne)
        val textTwo :TextView =itemView.findViewById(R.id.textTwo)

    }
}