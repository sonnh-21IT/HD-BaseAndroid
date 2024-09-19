package com.hd.document.read.ui.main.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hd.document.read.R
import com.hd.document.read.di.data.model.Film

class SwipeToDeleteCallback(
    private val adapter: FilmAdapter,
    private val context: Context
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    private val paint = Paint()

    override fun getMovementFlags(
        recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
    ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT)

    private val mBackGround: ColorDrawable = ColorDrawable()
    private val backGroundColor: Int = Color.parseColor("#b80f0a")
    private val deleteDrawable =
        ContextCompat.getDrawable(context, R.drawable.ic_delete)
    private val intrinsicHeight: Int = deleteDrawable?.intrinsicHeight ?: 0
    private val intrinsicWidth: Int = deleteDrawable?.intrinsicWidth ?: 0

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    @SuppressLint("ShowToast")
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position: Int = viewHolder.adapterPosition
        val film: Film = adapter.getData()[position]

        adapter.removeItem(position)

        Snackbar.make(
            viewHolder.itemView, "Item was removed from the list.", Snackbar.LENGTH_SHORT
        ).setAction("UNDO") {
            adapter.restoreItem(film, position)
        }.setActionTextColor(Color.YELLOW).show()
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

        val itemView: View = viewHolder.itemView
        val itemHeight: Int = itemView.height

        val isCancelled: Boolean = dX == 0f && !isCurrentlyActive

        if (isCancelled) {
            clearCanvas(
                c,
                itemView.right + dX,
                itemView.top.toFloat(),
                itemView.right.toFloat(),
                itemView.bottom.toFloat()
            )
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, false);
            return
        }

        mBackGround.apply {
            color = backGroundColor
            bounds.left = itemView.right + dX.toInt()
            bounds.top = itemView.top
            bounds.right = itemView.right
            bounds.bottom = itemView.bottom
            draw(c)
        }

        val deleteIconTop: Int = itemView.top + (itemHeight - intrinsicHeight) / 2
        val deleteIconMargin: Int = (itemHeight - intrinsicHeight) / 2
        val deleteIconLeft: Int = itemView.right - deleteIconMargin - intrinsicWidth
        val deleteIconRight: Int = itemView.right - deleteIconMargin
        val deleteIconBottom: Int = deleteIconTop + intrinsicHeight

        deleteDrawable?.apply {
            bounds.left = deleteIconLeft
            bounds.top = deleteIconTop
            bounds.right = deleteIconRight
            bounds.bottom = deleteIconBottom
            draw(c)
        }
    }

    private fun clearCanvas(
        canvas: Canvas, left: Float, top: Float, right: Float, bottom: Float
    ) {
        canvas.drawRect(left, top, right, bottom, paint)
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 0.7f
    }
}