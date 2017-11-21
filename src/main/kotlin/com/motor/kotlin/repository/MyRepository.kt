package com.motor.kotlin.repository


import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.NoRepositoryBean

import java.io.Serializable


@NoRepositoryBean
interface MyRepository<T, ID : Serializable> : MongoRepository<T, ID>