package com.example.thirdTimeApp

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

object SpHelper {

    lateinit var sp: SharedPreferences
    private const val SP_NAME = "shared_pref_counter"
    private const val sp_key = "key"

    suspend fun init(context: Context, clb: (String) -> Unit){
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        if (sp.getInt(sp_key, 0) == 0) {
            saveInSP(1)
        } else {
            var counter = sp.getInt(sp_key, 0)
            counter++
            saveInSP(counter)
            if (counter == 3) {
                clb("This is the third time You've launched this app.")
            }
        }
    }

    private suspend fun saveInSP(counter: Int) = withContext(IO) {
        sp.edit()
            .putInt(sp_key, counter)
            .apply()
    }
}