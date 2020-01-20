package com.mvvmwithdatapersistence.githubuser

import androidx.lifecycle.LiveData
import com.mvvmwithdatapersistence.githubuser.GitHubUser

interface GitHubUserRepository {

    fun getGithubUser(userName:String):LiveData<GitHubUser>?

}