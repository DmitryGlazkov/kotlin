package com.motor.kotlin.controller


import com.motor.kotlin.component.BookComponent

import com.motor.kotlin.models.Book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

import java.text.SimpleDateFormat


@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private val bookComponent: BookComponent? = null


    @PostMapping("/")
    fun postBook(@RequestBody book: Book): Book = bookComponent!!.save(book)

    @GetMapping("/all")
    fun getAllBooks(): Iterable<Book> = bookComponent!!.findAll()

    @GetMapping("/select")
    fun getSelectBooks(): List<Book> = bookComponent!!
            .findBooksByDateOfPublicationBeforeAndAuthorRegexAndTitleRegex(SimpleDateFormat("yyyy-MM-dd").parse("2002-01-01"),
                """^[A-ZА-Я]{1}[a-zа-я]+\s[A-ZА-Я]{1}[a-zа-я]+\s[A-ZА-Я]{1}[a-zа-я]+$""",
                "^.{1,50}$")

    @GetMapping("/{title}")
    fun bookByTitle(@PathVariable(value = "title") title: String): ResponseEntity<Book> {
        val titleBook: Book = bookComponent!!.findBookByTitle(title)

        return ResponseEntity.ok().body(titleBook)
    }

    @PutMapping("/{title}")
    fun putBook(@PathVariable(value = "title") title: String, @Valid @RequestBody bookDetails: Book): ResponseEntity<Book> {
        val book: Book = bookComponent!!.findBookByTitle(title)

        book.author = bookDetails.author
        book.dateOfPublication = bookDetails.dateOfPublication
        book.title = bookDetails.title

        val updatedBook: Book = bookComponent!!.save(book)

        return ResponseEntity.ok(updatedBook)
    }

    @DeleteMapping("/{title}")
    fun deleteBook(@PathVariable(value = "title") title: String): ResponseEntity<Book> {
        bookComponent!!.delete(bookComponent!!.findBookByTitle(title))

        return ResponseEntity.ok().build()
    }
}