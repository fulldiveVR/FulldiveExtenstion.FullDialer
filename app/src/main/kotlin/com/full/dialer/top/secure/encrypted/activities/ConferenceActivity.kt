package com.full.dialer.top.secure.encrypted.activities

import android.os.Bundle
import com.simplemobiletools.commons.helpers.NavigationIcon
import com.full.dialer.top.secure.encrypted.R
import com.full.dialer.top.secure.encrypted.adapters.ConferenceCallsAdapter
import com.full.dialer.top.secure.encrypted.helpers.CallManager
import kotlinx.android.synthetic.main.activity_conference.*

class ConferenceActivity : SimpleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference)

        conference_calls_list.adapter = ConferenceCallsAdapter(this, conference_calls_list, ArrayList(CallManager.getConferenceCalls())) {}
    }

    override fun onResume() {
        super.onResume()
        setupToolbar(conference_toolbar, NavigationIcon.Arrow)
    }
}
