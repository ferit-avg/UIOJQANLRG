package com.ferit.uiojqanlrg.ui

import com.ferit.uiojqanlrg.ext.AlertCallback
import com.ferit.uiojqanlrg.ext.AlertCallbackWithParamethers


interface UICommunicationListener {
    fun onUIMessageReceived(
        uiMessage: UIMessage,
        statusType: Int,
        btnTitle: String? = null,
        shouldShowCancel: Boolean? = null
    )
}

data class UIMessage(
    val message: String,
    val uiMessageType: UIMessageType
)

sealed class UIMessageType {
    class Toast: UIMessageType()

    class Dialog(
        val callback: AlertCallback
    ): UIMessageType()

    class None: UIMessageType()
}