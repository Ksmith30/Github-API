package com.example.kyle.githubapi.commons

import java.io.InputStream
import java.util.*

class FileHandling {

    private val properties: Properties = Properties()
    private val clientId: String
    private val clientSecret: String

    init {
        loadPropertyFile()
        clientId = removeQuotations(setClientId(properties))
        clientSecret = removeQuotations(setClientSecret(properties))
    }

    private fun loadPropertyFile() {
        val stream: InputStream = this.javaClass.classLoader.getResourceAsStream("local.properties")
        try {
            properties.load(stream)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            stream.close()
        }
    }

    private fun setClientId(properties: Properties): String {
        return properties.getProperty("GH_BASIC_CLIENT_ID")
    }

    private fun setClientSecret(properties: Properties): String {
        return properties.getProperty("GH_BASIC_SECRET_ID")
    }

    fun getClientId(): String {
        return clientId
    }

    fun getClientSecret(): String {
        return clientSecret
    }

    private fun removeQuotations(text: String): String {
        return text.replace("\"", "")
    }
}