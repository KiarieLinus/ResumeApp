package com.kiarielinus.myresume.di

import android.content.Context
import com.kiarielinus.myresume.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUseCases(@ApplicationContext context: Context): UseCases{
        return UseCases(
            sendMail = SendMail(context),
            makeCall = MakeCall(context),
            sendTwitterDm = SendTwitterDm(context),
            copySlack = CopySlack(context)
        )
    }
}