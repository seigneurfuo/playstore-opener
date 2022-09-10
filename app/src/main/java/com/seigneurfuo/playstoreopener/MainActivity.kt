package com.seigneurfuo.playstoreopener

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById(R.id.button) as Button
        btn_click_me.setOnClickListener()
        {
            val textE_entry = findViewById(R.id.editTextTextPersonName) as EditText
            val packageName = textE_entry.text

            if(!packageName.contains(':') || !packageName.contains('/'))
            {
                try
                {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
                }
                catch (e: ActivityNotFoundException)
                {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
                }
            }
        }
    }
}