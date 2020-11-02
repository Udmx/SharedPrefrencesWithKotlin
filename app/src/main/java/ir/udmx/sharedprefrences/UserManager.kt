package ir.udmx.sharedprefrences

import android.content.Context
import android.content.SharedPreferences
class UserManager(context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences("shared_app", Context.MODE_PRIVATE)
    }

    fun saveUserInformation(
        fullName: String?,
        email: String?,
        sex: String?
    ) {
        val editor: SharedPreferences.Editor? = sharedPreferences?.edit()
        editor?.let {
            editor.putString("full_name", fullName)
            editor.putString("email", email)
            editor.putString("sex", sex)
            editor.apply()
        }

    }

    fun getFullName(): String? {
        return sharedPreferences!!.getString("full_name","")
    }

    fun getEmail(): String? {
        return sharedPreferences!!.getString("email","")
    }

    fun getSex(): String? {
        return sharedPreferences!!.getString("sex","")
    }
}
