package uz.ravshanbaxranov.a4pics1word.repository

import android.content.Context

class SharedPref(context: Context) {

    companion object {

        private var instance: SharedPref? = null

        fun init(context: Context) {
            instance = SharedPref(context)
        }

        fun getInstance(): SharedPref = instance!!

    }

    private val pref = context.getSharedPreferences("USER_DATA", Context.MODE_PRIVATE)


    var level2: Boolean
        set(value) = pref.edit().putBoolean("LEVEL2", value).apply()
        get() = pref.getBoolean("LEVEL2", false)

    var level3: Boolean
        set(value) = pref.edit().putBoolean("LEVEL3", value).apply()
        get() = pref.getBoolean("LEVEL3", false)

    var beginner: Int
        set(value) = pref.edit().putInt("BEGINNER", value).apply()
        get() = pref.getInt("BEGINNER", 0)

    var medium: Int
        set(value) = pref.edit().putInt("MEDIUM", value).apply()
        get() = pref.getInt("MEDIUM", 0)

    var expert: Int
        set(value) = pref.edit().putInt("EXPERT", value).apply()
        get() = pref.getInt("EXPERT", 0)

}