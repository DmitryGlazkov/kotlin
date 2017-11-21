package com.motor.kotlin.controller


import com.motor.kotlin.component.BookComponent
import com.motor.kotlin.component.SelectComponent
import com.motor.kotlin.component.selimpl.SelBook
import com.motor.kotlin.models.Book

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    private val bookComponent: BookComponent? = null

    private var selBook: SelectComponent<Book> = SelBook()


    @PostMapping("/")
    fun postBook(@RequestBody book: Book): Book = bookComponent!!.save(book)

    @GetMapping("/{title}")
    fun bookByTitle(@PathVariable(value = "title") title: String): ResponseEntity<Book> {
        val titleBook: Book = bookComponent!!.findBookByTitle(title)

        return ResponseEntity.ok().body(titleBook)
    }

    @GetMapping("/select")
    fun getSelectBooks(): List<Book> = selBook.someSelect(bookComponent!!.findAll())

    @GetMapping("/all")
    fun getAllBooks(): List<Book> = bookComponent!!.findAll()

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