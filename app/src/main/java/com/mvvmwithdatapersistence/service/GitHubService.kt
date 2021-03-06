package com.mvvmwithdatapersistence.service

import com.mvvmwithdatapersistence.githubrepos.GitHubProject
import com.mvvmwithdatapersistence.githubusers.GitHubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{username}")
    fun getUser(@Path("username") username: String): Call<GitHubUser>

    @GET("/users/{username}/repos")
    fun getRepos(@Path("username") username: String): Call<List<GitHubProject>>


}