package com.hfad.aplicforless8.view

import android.Manifest
import android.app.AlertDialog
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.hfad.aplicforless8.databinding.FragmentContBinding

class ContFragment : Fragment() {

    private var _binding: FragmentContBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermissionnew()
    }

    private fun checkPermissionnew() {
        context?.let {
            when {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.READ_CONTACTS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    getContacs()
                }

                shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS) -> {
                    AlertDialog.Builder(it)
                        .setTitle("Доступ к списку контактов")
                        .setMessage("Объяснение")
                        .setPositiveButton("Предоставить доступ") { _, _ ->
                            requestPermission()
                        }
                        .setNegativeButton("Не надо") { dialog, _ ->
                        }
                }
                else -> requestPermission()
            }
        }

    }



    private fun requestPermission() {
        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 42)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            947191986 -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    getContacs()
                } else {
                    context?.let {
                        AlertDialog.Builder(it)
                            .setTitle("Доступ к списку контактов")
                            .setMessage("Объяснение")
                            .setNegativeButton("Закрыть") { _, _ ->
                                Unit
                            }
                            .create()
                            .show()

                    }

                }
                return
            }

        }
    }

    private fun getContacs() {
        context?.let {
            val contentResolver: ContentResolver = it.contentResolver
            val cursorWithContacts: Cursor? = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME
            )
            cursorWithContacts?.let {
                    cursor ->
                for (i in 0..cursor.count){
                    if (cursor.moveToPosition(i)) {
                        val name =
                            cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        addView(it,name)}
                }
            }
            cursorWithContacts?.close()

        }
    }

    private fun addView(context: Context, name: String?) {
        binding?.textContactName?.addView(AppCompatTextView(context).apply {
            text = name

        })
    }


    companion object {

        @JvmStatic
        fun newInstance() = ContFragment()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
