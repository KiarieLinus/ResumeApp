package com.kiarielinus.myresume.use_cases

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.kiarielinus.myresume.R

class CopySlack (
    private val context: Context
) {
    operator fun invoke() {
        val clipboardMgr = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text",context.getString(R.string.slackId))
        clipboardMgr.setPrimaryClip(clipData)
    }
}