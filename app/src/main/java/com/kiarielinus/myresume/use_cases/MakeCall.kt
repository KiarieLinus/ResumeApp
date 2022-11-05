package com.kiarielinus.myresume.use_cases

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.kiarielinus.myresume.BuildConfig

class MakeCall(
    private val context: Context
) {
    operator fun invoke() {
        val phoneNumber = BuildConfig.PHONE_NUMBER
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}