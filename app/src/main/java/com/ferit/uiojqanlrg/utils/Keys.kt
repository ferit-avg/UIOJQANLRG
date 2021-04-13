package com.ferit.uiojqanlrg.utils

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}