package com.mvvmwithdatapersistence.githubusers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class GitHubUserViewModel(username :String, application: Application) : AndroidViewModel(application) {
    private var gitHubUserRepository: GitHubUserRepository = GitHubUserDataRepository()
    private var githubUser: LiveData<GitHubUser>?

    init {
//        val gitHubUserDao = GitHubDatabase.getDatabase(application).gitHubUserDao()
        githubUser = gitHubUserRepository.getGithubUser(username)
    }

    fun getGitHubUserObservable(): LiveData<GitHubUser>? {
        return githubUser
    }

}