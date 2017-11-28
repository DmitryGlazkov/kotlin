package com.motor.kotlin.models


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

import javax.persistence.*

import java.util.Date


@Document
@CompoundIndex(name = "author_date", def = "{'author' : 1, 'dateOfPublication': 1}")
data class Book(@Id var id: String? = null,
                var author: String? = "",
                @Temporal(TemporalType.DATE)
                var dateOfPublication: Date? = null,
                @Indexed
                var title: String? = "") {

}