package com.motor.kotlin.component


interface SelectComponent<T> {

    fun someSelect(allElements: List<T>): List<T>
}