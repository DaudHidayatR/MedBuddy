package com.google.watermelonmigrasi.di

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.watermelonmigrasi.data.repository.AuthRepositoryImpl
import com.google.watermelonmigrasi.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )
}