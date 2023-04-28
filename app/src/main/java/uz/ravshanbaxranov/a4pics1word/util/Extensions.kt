package uz.ravshanbaxranov.a4pics1word.util

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import uz.ravshanbaxranov.a4pics1word.app.App


fun showToast(message: String) {
    Toast.makeText(App.instance, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showSnackBar(message: String) {
    Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
}

fun showLog(msg: String) {
    Log.d("TAGDF", msg)
}