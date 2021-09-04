package com.hfad.aplicforless8.model

import com.hfad.aplicforless8.room.HistoryDao
import com.hfad.aplicforless8.room.HistoryEctity

class RepositoryLocalIml(private val localDataSource:HistoryDao): LocalRepository {
    override fun getAllHistory(): List<ResulltFilm> {
       return convertHistoryToFilms(localDataSource.all())
    }

    override fun saveEntity(film: ResulltFilm) {

           localDataSource.insert(converFilmToEntity(film))

    }

    fun convertHistoryToFilms(entityList: List<HistoryEctity>): List<ResulltFilm>{
        return entityList.map {
            var abult = it.abult
            ResulltFilm(it.id.toInt(),it.title,it.urlImage,it.description,abult)
        }
      }

    fun converFilmToEntity(resulmFilm: ResulltFilm): HistoryEctity{
        var abult: Boolean? = resulmFilm.adult
        return HistoryEctity(resulmFilm.id!!.toLong(),resulmFilm.title.toString(),
            resulmFilm.overview.toString(),resulmFilm.poster_path.toString(),abult)
    }
}

