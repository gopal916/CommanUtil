package com.example.mylibrary


import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.net.Uri
import android.provider.Settings
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.commanutilslib.R


object DialogUtil {

    fun showOkDialog(context: Context, message: String, okText: String) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        mCancel.visibility = View.GONE
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_red))
        mText.text = message
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun showOkCallbackDialog(context: Context, message: String, okText: String,callBack: OkDialogInterface) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        mCancel.visibility = View.GONE
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_red))
        ResourceUtils.setBackgroundTint(context,mOk,R.color.colorGray)
        mText.text = message
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }

    }

    fun showGroupCallDialog(context: Context, message: String, okText: String) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        mCancel.visibility = View.GONE
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_red))
        mText.text = message
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
        }

    }

    fun showOkGreenDialog(
        context: Context,
        message: String,
        okText: String,
        callBack: OkDialogInterface
    ) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        mCancel.visibility = View.GONE
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_green))
        mText.text = message
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }

    }

    fun showOkCancelGreenDialog(
        context: Context, message: String, okText: String, cancelText: String,
        callBack: OkCancelDialogInterface,allowMargin:Boolean=false
    ) {

        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        if(allowMargin){
            val back = ColorDrawable(Color.TRANSPARENT)
            val inset = InsetDrawable(back, -10, 0, -10, 0)
            dialog.window?.setBackgroundDrawable(inset)
        }else {
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mCancel.text = cancelText
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_green_left))
        mCancel.background = (ContextCompat.getDrawable(context, R.drawable.bg_gray))
        mText.text = message

        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }
        mCancel.setOnClickListener {
            dialog.dismiss()
            callBack.cancel()
        }

    }






    /*@SuppressLint("UseCompatLoadingForDrawables")
    fun showOkCancelImageGreenDialog(
        context: Context, message: String, okText: String, cancelText: String,
        callBack: OkCancelDialogInterface
    ) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        val img: Drawable = context.resources.getDrawable(R.drawable.iv_message_warning, null)
        img.setBounds(0, 0, 100, 100)
        mText.setCompoundDrawables(img, null, null, null)
        mCancel.text = cancelText
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_green_left))
        mCancel.background = (ContextCompat.getDrawable(context, R.drawable.bg_gray))
        mText.text = message
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }
        mCancel.setOnClickListener {
            dialog.dismiss()
            callBack.cancel()
        }
    }*/

    fun showOkCancelTitleGreenDialog(
        context: Context, message: String, okText: String, cancelText: String, title: String,
        callBack: OkCancelDialogInterface
    ) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        val mWarning: AppCompatImageView = dialog.findViewById(R.id.ivWarning)
        val mTitle: AppCompatTextView = dialog.findViewById(R.id.lbltitle)
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        val mTitleLayout: ConstraintLayout = dialog.findViewById(R.id.clTitle)
        mTitleLayout.visibility = View.VISIBLE
        mWarning.visibility = View.VISIBLE
        mTitle.visibility = View.VISIBLE
        mTitle.text = title
        mText.text = message
        mCancel.text = cancelText
        mOk.text = okText
        mOk.background = (ContextCompat.getDrawable(context, R.drawable.bg_green_left))
        mCancel.background = (ContextCompat.getDrawable(context, R.drawable.bg_gray))
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }

        mCancel.setOnClickListener {
            dialog.dismiss()
            callBack.cancel()
        }
    }


    fun showOkCancelDialog(
        context: Context,
        message: String,
        okText: String,
        cancelText: String,
        callBack: OkCancelDialogInterface
    ) {
        val dialog = Dialog(context, R.style.custom_alert_dialog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_popup_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val mOk: AppCompatTextView = dialog.findViewById(R.id.lblYes)
        val mCancel: AppCompatTextView = dialog.findViewById(R.id.lblCancel)
        val mText: AppCompatTextView = dialog.findViewById(R.id.lblMessage)
        mOk.text = okText
        mText.text = message
        mCancel.text = cancelText
        dialog.show()
        mOk.setOnClickListener {
            dialog.dismiss()
            callBack.ok()
        }
        mCancel.setOnClickListener {
            dialog.dismiss()
            callBack.cancel()
        }

    }

    fun showImagePickerDialog(
        context: Context,
        photoURI: String,
        callBack: PhotoGalleryDialogInterface
    ) {
        val options: Array<CharSequence> = if (photoURI === "") {
            arrayOf(
                context.getString(R.string.lbl_takephoto),
                context.getString(R.string.lbl_choosephoto),
                context.getString(R.string.lbl_cancel)
            )
        } else {
            arrayOf(
                context.getString(R.string.lbl_takephoto),
                context.getString(R.string.lbl_choosephoto),
//                context.getString(R.string.lbl_removephoto),
                context.getString(R.string.lbl_cancel)
            )
        }
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle(context.getString(R.string.lbl_add_pic))
        builder.setItems(options) { dialog, item ->
            if (options[item] == context.getString(R.string.lbl_takephoto)) {
                dialog.dismiss()
                callBack.photo()
            } else if (options[item] == context.getString(R.string.lbl_choosephoto)) {
                dialog.dismiss()
                callBack.gallery()
            } else if (options[item] == context.getString(R.string.lbl_removephoto)) {
                dialog.dismiss()
                callBack.remove()
            } else if (options[item] == context.getString(R.string.lbl_cancel)) {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    fun dialogGoToSetting(context: Context){
        DialogUtil.showOkCancelGreenDialog(
            context,
            context.getString(R.string.msg_permission_required),
            context.getString(R.string.goto_settings),
            context.getString(R.string.btn_cancel),
            object : OkCancelDialogInterface {
                override fun ok() {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", context.packageName, null)
                    intent.data = uri
                    context.startActivity(intent)
                }

                override fun cancel() {
                }

            })
    }



}

interface OkCancelDialogInterface {
    fun ok()
    fun cancel()
}

interface OkDialogInterface {
    fun ok()
}

interface PhotoGalleryDialogInterface {
    fun photo()
    fun gallery()
    fun remove()
}

