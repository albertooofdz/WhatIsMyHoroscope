package com.example.whatismyhoroscope.utils

import android.content.Context


class SessionManager {


   private var context : Context? = null

    val sharedPref = context?.getSharedPreferences(
        "session_data", Context.MODE_PRIVATE)


    var editor =sharedPref?.edit()









}