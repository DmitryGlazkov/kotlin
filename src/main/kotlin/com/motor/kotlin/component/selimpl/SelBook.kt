package com.motor.kotlin.component.selimpl


import com.motor.kotlin.component.SelectComponent
import com.motor.kotlin.models.Book

import java.util.*


class SelBook : SelectComponent<Book> {

    override fun someSelect(allElements: List<Book>): List<Book> = allElements
            .filter{ it.dateOfPublication!!.compareTo(Date()) < 0
                    && it.title!!.length < 51
                    && it.author!!.matches(Regex("""[A-ZА-Я]{1}[a-zа-я]+\s[A-ZА-Я]{1}[a-zа-я]+\s[A-ZА-Я]{1}[a-zа-я]+""")) }
}
