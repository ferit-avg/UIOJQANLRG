package com.ferit.uiojqanlrg.ui.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ferit.uiojqanlrg.data.model.common.AlertStatusType
import com.ferit.uiojqanlrg.ext.displayDialog
import com.ferit.uiojqanlrg.ext.displayDialogWithCallback
import com.ferit.uiojqanlrg.ui.DataStateChangeListener
import com.ferit.uiojqanlrg.ui.UICommunicationListener
import com.ferit.uiojqanlrg.ui.UIMessage
import com.ferit.uiojqanlrg.ui.UIMessageType
import timber.log.Timber

abstract class BaseActivity<T: ViewBinding> : AppCompatActivity(), DataStateChangeListener, UICommunicationListener {
    lateinit var binding: T

    abstract fun getViewBinding(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    override fun showAlert(
        statusType: Int,
        message: String,
        shouldShowSuccessAlert: Boolean,
        shouldShowErrorAlert: Boolean
    ) {
        when (statusType) {
            AlertStatusType.SUCCESS.code -> if(shouldShowSuccessAlert) displayDialog(message, AlertStatusType.SUCCESS)
            AlertStatusType.INFO.code -> if (shouldShowErrorAlert) displayDialog(message, AlertStatusType.INFO)
            else -> if (shouldShowErrorAlert) displayDialog(message, AlertStatusType.ERROR)
        }
    }

    override fun onUIMessageReceived(uiMessage: UIMessage, statusType: Int, btnTitle: String?, shouldShowCancel: Boolean?) {
        when(uiMessage.uiMessageType){
            is UIMessageType.Dialog -> {
                displayDialogWithCallback(
                    uiMessage.message,
                    uiMessage.uiMessageType.callback,
                    statusType,
                    btnTitle,
                    shouldShowCancel
                )
            }
            is UIMessageType.None -> {
                Timber.d( "BaseActivity, onUIMessageReceived : ${uiMessage.message}")
            }
        }
    }

    // Progress Bar
    override fun showProgressBar(display: Boolean) {
        displayProgressBar(display)
    }

    abstract fun displayProgressBar(display: Boolean)

    // Hide Keyboard
    override fun hideSoftKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            inputMethodManager
                .hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

    override fun setBottomBarBgColor(color: Int) {}

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.clear()
    }
}