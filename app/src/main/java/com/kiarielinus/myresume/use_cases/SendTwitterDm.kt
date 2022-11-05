package com.kiarielinus.myresume.use_cases

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.kiarielinus.myresume.R

class SendTwitterDm (
    private val context: Context
){
    operator fun invoke(){
        val url = "https://twitter.com/messages/compose?recipient_id=1394917633&text=Hi%20there%20I'm%20from%20the%20HING9%20internship\n"
        val contactUri: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, contactUri).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
}