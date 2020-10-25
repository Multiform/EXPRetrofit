package com.multiform.expretrofit.utils

import android.widget.Toast

fun showToast(str: String) = Toast.makeText(APP_ACTIVITY, str, Toast.LENGTH_SHORT).show()
fun showToast(idResStr: Int) = Toast.makeText(APP_ACTIVITY, idResStr, Toast.LENGTH_SHORT).show()