package com.full.dialer.top.secure.encrypted.dialogs

import androidx.appcompat.app.AlertDialog
import com.simplemobiletools.commons.activities.BaseSimpleActivity
import com.simplemobiletools.commons.extensions.getAlertDialogBuilder
import com.simplemobiletools.commons.extensions.setupDialogStuff
import com.full.dialer.top.secure.encrypted.R
import com.full.dialer.top.secure.encrypted.activities.SimpleActivity
import com.full.dialer.top.secure.encrypted.adapters.RecentCallsAdapter
import com.full.dialer.top.secure.encrypted.helpers.RecentsHelper
import com.full.dialer.top.secure.encrypted.models.RecentCall
import kotlinx.android.synthetic.main.dialog_show_grouped_calls.view.*

class ShowGroupedCallsDialog(val activity: BaseSimpleActivity, callIds: ArrayList<Int>) {
    private var dialog: AlertDialog? = null
    private var view = activity.layoutInflater.inflate(R.layout.dialog_show_grouped_calls, null)

    init {
        view.apply {
            RecentsHelper(activity).getRecentCalls(false) { allRecents ->
                val recents = allRecents.filter { callIds.contains(it.id) }.toMutableList() as ArrayList<RecentCall>
                activity.runOnUiThread {
                    RecentCallsAdapter(activity as SimpleActivity, recents, select_grouped_calls_list, null, false) {
                    }.apply {
                        select_grouped_calls_list.adapter = this
                    }
                }
            }
        }

        activity.getAlertDialogBuilder()
            .apply {
                activity.setupDialogStuff(view, this) { alertDialog ->
                    dialog = alertDialog
                }
            }
    }
}
