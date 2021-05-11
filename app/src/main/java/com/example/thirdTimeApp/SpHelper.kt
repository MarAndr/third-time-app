package com.example.thirdTimeApp

import android.content.Context
import android.content.SharedPreferences

object SpHelper {

    lateinit var sp: SharedPreferences
    private const val SP_NAME = "shared_pref_counter"
    private const val sp_key = "key"

    fun init(context: Context, clb: (String) -> Unit){
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        if (sp.getInt(sp_key, 0) == 0) {
            saveInSP(1)
        } else {
            var counter = sp.getInt(sp_key, 0)
            counter++
            saveInSP(counter)
            if (counter == 3) {
                clb("You logged in to the app for the third time")
            }
        }
    }

    private fun saveInSP(counter: Int) {
        sp.edit()
            .putInt(sp_key, counter)
            .apply()
    }
}