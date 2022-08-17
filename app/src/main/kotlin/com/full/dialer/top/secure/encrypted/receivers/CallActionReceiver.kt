package com.full.dialer.top.secure.encrypted.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.full.dialer.top.secure.encrypted.activities.CallActivity
import com.full.dialer.top.secure.encrypted.helpers.ACCEPT_CALL
import com.full.dialer.top.secure.encrypted.helpers.CallManager
import com.full.dialer.top.secure.encrypted.helpers.DECLINE_CALL

class CallActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            ACCEPT_CALL -> {
                context.startActivity(CallActivity.getStartIntent(context))
                CallManager.accept()
            }
            DECLINE_CALL -> CallManager.reject()
        }
    }
}
