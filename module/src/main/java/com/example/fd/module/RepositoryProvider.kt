package com.example.fd.module

import com.example.fd.module.adb.AdbRepository
import com.example.fd.module.adb.impl.AdbRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryProvider {
    @Provides
    @Singleton
    fun provideAdbRepository(): AdbRepository = AdbRepositoryImpl()
}
