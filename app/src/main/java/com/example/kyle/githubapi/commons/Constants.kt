package com.example.kyle.githubapi.commons


class Constants {
    companion object {
        private val fileHandling: FileHandling = FileHandling()
        val CLIENT_ID: String = fileHandling.getClientId()
        val CLIENT_SECRET: String = fileHandling.getClientSecret()
    }


}