package com.example.gantestapplication.helpers

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gantestapplication.Activities.DetailActivity
import com.example.gantestapplication.R
import com.example.gantestapplication.models.BreakingCharacters
import com.squareup.picasso.Picasso
import java.io.Serializable

class BreakingCharacterAdapter(
    private val BreakingList: List<BreakingCharacters>,
    private val context: Context,
) :
    RecyclerView.Adapter<BreakingCharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${BreakingList.size} ")

        holder.itemView.setOnClickListener(){

            val data = BreakingList[position]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("detail", data)
            context.startActivity(intent)

        }
        return holder.bind(BreakingList[position])
    }

    override fun getItemCount(): Int {
        return BreakingList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.image_view)
        var name = itemView.findViewById<TextView>(R.id.tv_char_name)
        fun bind(breakingCharacters: BreakingCharacters) {
            Picasso.get().load(breakingCharacters.img).into(image)
            name.text = breakingCharacters.name

        }
    }
}

