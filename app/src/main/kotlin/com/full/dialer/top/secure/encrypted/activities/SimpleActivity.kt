package com.full.dialer.top.secure.encrypted.activities

import com.simplemobiletools.commons.activities.BaseSimpleActivity
import com.full.dialer.top.secure.encrypted.R

open class SimpleActivity : BaseSimpleActivity() {
    override fun getAppIconIDs() = arrayListOf(
        R.mipmap.ic_launcher,
        R.mipmap.ic_launcher_round,
    )

    override fun getAppLauncherName() = getString(R.string.app_launcher_name)
}
