package com.kiarielinus.myresume.use_cases

data class UseCases (
    val sendMail: SendMail,
    val makeCall: MakeCall,
    val sendTwitterDm: SendTwitterDm,
    val copySlack: CopySlack
)