package com.tranduc.demokotlin.base

open class BasePresenter<T> {
    inline fun <reified R : T> getView(): R {
        return R::class.java.newInstance()
    }
}
