package com.hfad.aplicforless8.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.hfad.aplicforless8.R
import com.hfad.aplicforless8.model.ResulltFilm

class MainAdapter() : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

     lateinit var clickHandler: ClickEventHandler
    private var listFilms: List<ResulltFilm> = listOf()

    fun setFilms(data: List<ResulltFilm>){
        listFilms = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: ClickEventHandler){
        clickHandler = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fimltime = listFilms.get(position)
        holder.bind(fimltime)
        /* holder.itemView.setOnClickListener (object : View.OnClickListener{
             override fun onClick(view: View?) {
                 val activity = view!!.context as AppCompatActivity
                 val infoFragment = InfoFragment().openCardFilm(fimltime)
                 activity.supportFragmentManager.beginTransaction()
                     .replace(R.id.main_container_fragment, InfoFragment()).addToBackStack(null)
                     .commit()
             }
         })*/


       /* holder.itemView.findViewById<AppCompatImageView>(R.id.image_container)
            .setOnClickListener {
            clickHandler.forwardClick(fimltime)
        }*/



    }

    override fun getItemCount(): Int {

        return listFilms.size
    }

  inner  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(film: ResulltFilm){
            itemView.findViewById<TextView>(R.id.id_film).text = film.id.toString()
            itemView.findViewById<TextView>(R.id.title_film).text = film.title.toString()
            val pictures = film.poster_path.toString()
            itemView.findViewById<AppCompatImageView>(R.id.image_container)
                .load("https://image.tmdb.org/t/p/w200${pictures}")
           var likes =  itemView.findViewById<ImageView>(R.id.imageSaveDB)

           var imageFilm = itemView.findViewById<AppCompatImageView>(R.id.image_container)
           likes.setOnClickListener {
               clickHandler.saveFilm(film)
           }
           imageFilm.setOnClickListener {
               clickHandler.forwardClick(film)
           }
        }

    }

    interface ClickEventHandler  {
        fun forwardClick(film: ResulltFilm)
        fun saveFilm(film: ResulltFilm)
    }
}