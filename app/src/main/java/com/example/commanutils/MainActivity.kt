package com.example.commanutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylibrary.DialogUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DialogUtil.dialogGoToSetting(this)
    }
}