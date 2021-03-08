package com.example.mylibrary

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.media.AudioManager
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat

object ResourceUtils {

        fun getColor(context: Context, color: Int): Int {
                return ResourcesCompat.getColor(context.getResources(), color, null)
        }

        fun getDrawable(context: Context, drawable: Int): Drawable? {
                return ResourcesCompat.getDrawable(context.getResources(), drawable, null)
        }

        fun getString(context: Context, stringID: Int): String {
                return context.getString(stringID)
        }

        fun setBackgroundTint(context: Context,view:View,color: Int){
                ViewCompat.setBackgroundTintList(
                        view, ColorStateList.valueOf(getColor(context, color))
                )
        }

        fun isCallGoingOn(context: Context): Boolean {
                val am = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                val mode = am.mode
                when (mode) {
                        AudioManager.MODE_IN_CALL -> {
                                // device is in a telephony call
                                return true
                        }
                        AudioManager.MODE_IN_COMMUNICATION -> {
                                // device is in communication mode, i.e. in a VoIP or video call
                                return true
                        }
                        AudioManager.MODE_RINGTONE -> {
                                // device is in ringing mode, some incoming is being signalled
                                return true
                        }
                        else -> {
                                // device is in normal mode, no incoming and no audio being played
                                return false
                        }
                }
        }
}