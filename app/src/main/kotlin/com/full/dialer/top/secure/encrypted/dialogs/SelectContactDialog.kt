package com.full.dialer.top.secure.encrypted.dialogs

import androidx.appcompat.app.AlertDialog
import com.reddit.indicatorfastscroll.FastScrollItemIndicator
import com.simplemobiletools.commons.extensions.*
import com.simplemobiletools.commons.models.SimpleContact
import com.full.dialer.top.secure.encrypted.R
import com.full.dialer.top.secure.encrypted.activities.SimpleActivity
import com.full.dialer.top.secure.encrypted.adapters.ContactsAdapter
import kotlinx.android.synthetic.main.dialog_select_contact.view.*
import java.util.*

class SelectContactDialog(val activity: SimpleActivity, contacts: ArrayList<SimpleContact>, val callback: (selectedContact: SimpleContact) -> Unit) {
    private var dialog: AlertDialog? = null
    private var view = activity.layoutInflater.inflate(R.layout.dialog_select_contact, null)

    init {
        view.apply {
            letter_fastscroller.textColor = context.getProperTextColor().getColorStateList()
            letter_fastscroller_thumb.setupWithFastScroller(letter_fastscroller)
            letter_fastscroller_thumb.textColor = context.getProperPrimaryColor().getContrastColor()
            letter_fastscroller_thumb.thumbColor = context.getProperPrimaryColor().getColorStateList()

            letter_fastscroller.setupWithRecyclerView(select_contact_list, { position ->
                try {
                    val name = contacts[position].name
                    val character = if (name.isNotEmpty()) name.substring(0, 1) else ""
                    FastScrollItemIndicator.Text(character.toUpperCase(Locale.getDefault()))
                } catch (e: Exception) {
                    FastScrollItemIndicator.Text("")
                }
            })

            select_contact_list.adapter = ContactsAdapter(activity, contacts, select_contact_list) {
                callback(it as SimpleContact)
                dialog?.dismiss()
            }
        }

        activity.getAlertDialogBuilder()
            .setNegativeButton(R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(view, this) { alertDialog ->
                    dialog = alertDialog
                }
            }
    }
}
