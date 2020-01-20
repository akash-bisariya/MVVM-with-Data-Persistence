package com.mvvmwithdatapersistence.githubuser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mvvmwithdatapersistence.GitHubDatabase
import com.mvvmwithdatapersistence.githubuser.GitHubUser
import com.mvvmwithdatapersistence.githubuser.GitHubUserDataRepository
import com.mvvmwithdatapersistence.githubuser.GitHubUserRepository


class GitHubUserViewModel(application: Application) : AndroidViewModel(application) {
    private var gitHubUserRepository: GitHubUserRepository = GitHubUserDataRepository()
    private var githubUser: LiveData<GitHubUser>?

    init {
//        val gitHubUserDao = GitHubDatabase.getDatabase(application).gitHubUserDao()
        githubUser = gitHubUserRepository.getGithubUser("akash-bisariya")
    }

    fun getGitHubUserObservable(): LiveData<GitHubUser>? {
        return githubUser
    }

}