package com.example.fd.module.adb

interface AdbRepository {
    suspend fun enable(): Boolean
    suspend fun disable(): Boolean
}
