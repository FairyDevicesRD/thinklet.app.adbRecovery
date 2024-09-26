package com.example.fd.module.adb.impl

import ai.fd.thinklet.sdk.maintenance.adb.AdbClient
import android.content.Context
import com.example.fd.module.adb.AdbRepository
import java.util.concurrent.CompletableFuture
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class AdbRepositoryImpl @Inject constructor(context: Context) : AdbRepository {
    private val adbClient = AdbClient(context)
    override suspend fun enable(): Boolean = adbClient.enableAsync().await()
    override suspend fun disable(): Boolean = adbClient.disableAsync().await()

    private suspend fun CompletableFuture<Boolean>.await(): Boolean {
        return suspendCoroutine { continuation ->
            this.whenComplete { result, exception ->
                if (exception != null) {
                    continuation.resumeWithException(exception)
                } else {
                    continuation.resume(result)
                }
            }
        }
    }
}
