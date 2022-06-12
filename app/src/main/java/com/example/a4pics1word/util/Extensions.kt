package com.example.a4pics1word.util

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a4pics1word.app.App
import com.google.android.material.snackbar.Snackbar


fun showToast(message: String) {
    Toast.makeText(App.instance, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showSnackBar(message: String) {
    Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
}

fun makeVisibleOrGone(view: View, isVisible: Boolean) {
    if (isVisible) view.visibility = VISIBLE
    else view.visibility = GONE
}

fun String.isEmptyOrBlank(): Boolean {
    return this.isEmpty() || this.isBlank()
}