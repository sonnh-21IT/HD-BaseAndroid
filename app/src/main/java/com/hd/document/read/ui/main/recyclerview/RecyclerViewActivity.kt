package com.hd.document.read.ui.main.recyclerview

import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.hd.document.read.R
import com.hd.document.read.databinding.RecyclerViewActBinding
import com.hd.document.read.di.data.model.Film
import com.hd.document.read.ui.base.BaseActivity

class RecyclerViewActivity : BaseActivity<RecyclerViewActBinding>() {
    private val filmAdapter: FilmAdapter by lazy {
        FilmAdapter { film ->
            Toast.makeText(this, "Clicked: ${film.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun initView() = binding.run {
        rvMain.adapter = filmAdapter
        rvMain.layoutManager =
            LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
    }

    override fun initData() {
        val listFilm: List<Film> = listOf(
            Film(R.drawable.ic_launcher_background, "Gia toc rong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Than lang chi mong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Hoan hon", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Bang hoa ma tru", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Than lang chi mong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Hoan hon", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Gia toc rong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Bang hoa ma tru", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Than lang chi mong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Hoan hon", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Gia toc rong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Bang hoa ma tru", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Than lang chi mong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Hoan hon", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Gia toc rong", "phim trung quoc"),
            Film(R.drawable.ic_launcher_background, "Bang hoa ma tru", "phim trung quoc"),
        )
        filmAdapter.dataSubmit(listFilm)
    }

    override fun initListener() {
        ItemTouchHelper(
            SwipeToDeleteCallback(
                filmAdapter,
                this
            )
        ).attachToRecyclerView(binding.rvMain)
    }

    override fun viewBinding(): RecyclerViewActBinding =
        RecyclerViewActBinding.inflate(LayoutInflater.from(this))
}