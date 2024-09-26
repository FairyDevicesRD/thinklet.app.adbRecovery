package com.example.fd.adbrecovery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.fd.module.adb.AdbRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AdbRecoveryReceiver : BroadcastReceiver() {
    @Inject
    lateinit var adbRepository: AdbRepository
    private val scope = CoroutineScope(Dispatchers.Default)

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_BOOT_COMPLETED -> {
                Log.d("AdbRecoveryReceiver", "onReceived ACTION_BOOT_COMPLETED")
                scope.launch {
                    val ret = adbRepository.enable()
                    Log.d("AdbRecoveryReceiver", "adbRepository.enable() ret=$ret")
                }
            }
        }
    }
}
