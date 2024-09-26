package com.example.fd.adbrecovery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.fd.module.adb.AdbRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AdbRecoveryReceiver : BroadcastReceiver() {
    @Inject lateinit var adbRepository: AdbRepository

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                Log.d("AdbRecoveryReceiver", "onReceived ACTION_BOOT_COMPLETED")
                adbRepository.enable()
                // adbRepository.disable()
            }
        }
    }
}
