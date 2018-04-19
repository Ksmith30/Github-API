package com.example.kyle.githubapi

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kyle.githubapi.api.GithubService
import com.example.kyle.githubapi.commons.Constants


class MainActivity : AppCompatActivity() {

    private val githubService = GithubService()
    private val redirectUri: String = "example://callback"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        dealWithOauthResponse(intent)
    }

    fun oauthOnClick(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize" + "?client_id=" + Constants.CLIENT_ID + "&scope=repo&redirect_uri=" + redirectUri))
        startActivity(intent)
    }

    private fun dealWithOauthResponse(intent: Intent?) {
        val uri: Uri = intent!!.data
        print(uri)
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            print(uri.getQueryParameter("oauth_verifier"))
            val code: String = uri.getQueryParameter("oauth_verifier")
            val accessTokenCall = githubService.getAccessToken(Constants.CLIENT_ID, Constants.CLIENT_SECRET, code)
        }
    }


}