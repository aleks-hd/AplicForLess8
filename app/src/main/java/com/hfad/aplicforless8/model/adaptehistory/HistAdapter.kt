package com.hfad.aplicforless8.model.adaptehistory


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hfad.aplicforless8.R
import com.hfad.aplicforless8.model.ResulltFilm

class HistAdapter() : RecyclerView.Adapter<HistAdapter.ViewHolder>() {


    private var listFilmDB : List<ResulltFilm> = listOf()

    fun setData(data: List<ResulltFilm>) {
        listFilmDB = data
        notifyDataSetChanged()
    }

  inner  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(films: ResulltFilm) {
           itemView.findViewById<TextView>(R.id.id_film_db).text = films.id.toString()
           itemView.findViewById<TextView>(R.id.title_db).text = films.title.toString()
           val pictures = films.poster_path.toString()
            itemView.findViewById<AppCompatImageView>(R.id.image_db)
                .load("https://image.tmdb.org/t/p/w200${pictures}")
            itemView.findViewById<TextView>(R.id.abult).text = films.adult.toString()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_local_film, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val films = listFilmDB.get(position)
        holder.bind(films)
    }

    override fun getItemCount(): Int {
        return listFilmDB.size
    }
}