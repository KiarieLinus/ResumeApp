package com.kiarielinus.myresume.use_cases

import android.content.Context
import android.content.Intent
import android.net.Uri

class SendMail (
    private val context: Context
){
    operator fun invoke(){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, "kiarielinus@gmail.com")
            putExtra(Intent.EXTRA_SUBJECT, "HING9 INTERNSHIP")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}