package com.example.kyle.githubapi.commons

import com.squareup.moshi.Json
import java.io.File
import java.io.FileInputStream
import java.util.*

class Constants {

    fun loadPropertyFile() {
        val propertyFile = File("./local.properties")

    }

    fun doesFileExist(file: File): Properties {
        if (file.exists()) {
            val properties = Properties()
            properties.load(FileInputStream(file))
            return properties
        } else {
            throw IllegalStateException("local.properties could not be located")
        }
    }

    fun getClientId() {

    }

    fun getClientSecret() {

    }
}