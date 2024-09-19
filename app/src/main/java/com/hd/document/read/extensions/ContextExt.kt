package com.hd.document.read.extensions

import android.content.Context
import es.dmoral.toasty.Toasty

fun Context.toastNormal(text: String, duration: Int = Toasty.LENGTH_SHORT) {
    Toasty.normal(this, text, duration).show()
}
