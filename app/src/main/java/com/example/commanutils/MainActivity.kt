package com.example.commanutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mylibrary.DialogUtil
import com.example.mylibrary.OkDialogInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSettingDialog.setOnClickListener {
            DialogUtil.dialogGoToSetting(this)
        }

        btnGreenOkDialog.setOnClickListener {
            DialogUtil.showOkGreenDialog(this,"this is for testing","Okay",object :OkDialogInterface{
                override fun ok() {

                }

            })
        }


    }
}