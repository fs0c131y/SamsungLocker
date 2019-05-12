package com.fs0c131y.xcover4locker

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder

class LockerService : Service() {

    companion object {
        const val REFRESH_DELAY = 1000L
        const val ACTION_COMMAND = "com.samsung.android.knox.containeragent.LocalCommandReceiver.ACTION_COMMAND"
        const val EXTRA_COMMAND_ID = "com.samsung.android.knox.containeragent.LocalCommandReceiver.EXTRA_COMMAND_ID"
        const val USER_HANDLE = "android.intent.extra.user_handle"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startLock()

        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun startLock(): Boolean {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                lockSecureFolder()
                resetLauncher()

                handler.postDelayed(this, REFRESH_DELAY)
            }
        }
        return handler.post(runnable)
    }

    private fun lockSecureFolder() {
        val intent = Intent(ACTION_COMMAND)
        intent.putExtra(EXTRA_COMMAND_ID, 1001)
        intent.putExtra(USER_HANDLE, 150)
        sendBroadcast(intent)
    }

    private fun resetLauncher() {
        val intent = Intent(ACTION_COMMAND)
        intent.putExtra(EXTRA_COMMAND_ID, 1002)
        intent.putExtra(USER_HANDLE, 0)
        sendBroadcast(intent)
    }
}
