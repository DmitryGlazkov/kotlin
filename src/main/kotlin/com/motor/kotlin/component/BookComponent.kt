package com.motor.kotlin.component


import com.motor.kotlin.models.Book
import com.motor.kotlin.repository.MyRepository

import org.springframework.stereotype.Component


@Component
interface BookComponent : MyRepository<Book, String> {

    fun findBookByTitle(title: String): Book
}