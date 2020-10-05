package com.max.maxcmoney.util


object Util {

    fun splitUrl(url: String, delimiters: String): List<String> {
        return url.split(delimiters)
    }

}