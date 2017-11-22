package com.motor.kotlin.models


import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.index.Indexed

import javax.persistence.*

import java.util.Date


@Document
data class Book(@Id var id: String? = null,
                var author: String? = "",
                @Temporal(TemporalType.DATE)
                var dateOfPublication: Date? = null,
                @Indexed
                var title: String? = "")
