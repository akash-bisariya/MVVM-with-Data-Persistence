package com.mvvmwithdatapersistence.githubusers

import androidx.lifecycle.LiveData

interface GitHubUserRepository {

    fun getGithubUser(userName: String): LiveData<GitHubUser>?

}