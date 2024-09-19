package com.hd.document.read.ui.main.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hd.document.read.databinding.ItemFilmBinding
import com.hd.document.read.di.data.model.Film

class FilmAdapter(
    private val onItemClick: (Film) -> Unit
) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {
    private val listFilm: MutableList<Film> = mutableListOf()

    inner class FilmViewHolder(private val binding: ItemFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBinding(film: Film) {
            binding.apply {
                imgLogo.setImageResource(film.img)
                tvName.text = film.name
                tvDesc.text = film.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder =
        FilmViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).apply {

            }
        )

    override fun getItemCount(): Int = listFilm.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.onBinding(listFilm[position])
    }

    fun dataSubmit(films: List<Film>) {
        listFilm.clear()
        listFilm.addAll(films)
        notifyItemRangeInserted(0, listFilm.size)
    }

    fun getData(): MutableList<Film> = listFilm

    fun removeItem(position: Int) {
        listFilm.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(film: Film, position: Int) {
        listFilm.add(position, film)
        notifyItemInserted(position)
    }
}