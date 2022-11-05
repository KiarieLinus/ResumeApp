package com.kiarielinus.myresume.ui.presentation.profile

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.kiarielinus.myresume.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun onContactClicked(contactType: ContactType) {
        when(contactType){
            ContactType.EMAIL ->{
                useCases.sendMail()
            }
            ContactType.TWITTER -> {
                useCases.sendTwitterDm()
            }
            ContactType.PHONE -> {
                useCases.makeCall()
            }
            ContactType.SLACK -> {
                useCases.copySlack()
            }
        }
    }
}

enum class ContactType{
    EMAIL, TWITTER, PHONE, SLACK
}

enum class Screens{
    OFFER
}