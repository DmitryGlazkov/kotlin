package com.motor.kotlin.component


import com.motor.kotlin.models.Book
import com.motor.kotlin.repository.MyRepository

import org.springframework.stereotype.Component

import java.util.Date


@Component
interface BookComponent : MyRepository<Book, String> {

    fun findBookByTitle(title: String): Book

    fun findBooksByDateOfPublicationBeforeAndAuthorRegexAndTitleRegex(date: Date, regexAuthor: String, regexTitle: String): List<Book>
}