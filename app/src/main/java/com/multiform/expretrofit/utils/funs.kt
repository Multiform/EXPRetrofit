package com.multiform.expretrofit.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun showToast(str: String, isLong: Boolean = false) {
    if (isLong) Toast.makeText(APP_ACTIVITY, str, Toast.LENGTH_LONG).show()
        else Toast.makeText(APP_ACTIVITY, str, Toast.LENGTH_SHORT).show()
}
fun showToast(idResStr: Int, isLong: Boolean = false) {
    if (isLong) Toast.makeText(APP_ACTIVITY, idResStr, Toast.LENGTH_LONG).show()
    else Toast.makeText(APP_ACTIVITY, idResStr, Toast.LENGTH_SHORT).show()
}

//fun replaceFragment(fragment: Fragment, isAddStack: Boolean = true) {
//    if (isAddStack) {
//        APP_ACTIVITY.supportFragmentManager.beginTransaction()
//            .addToBackStack(null)
//            .replace(
//                R.id.containerPagers,
//                fragment
//            ).commit()
//    } else {
//        APP_ACTIVITY.supportFragmentManager.beginTransaction()
//            .replace(
//                R.id.containerPagers,
//                fragment
//            ).commit()
//    }
//}

fun hideKeyboard() {
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken, 0)
}