package com.mvvmwithdatapersistence.githubrepos

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class GitHubProjectViewModel(username:String, application: Application) : AndroidViewModel(application) {
    private var gitHubUserProjectRepository: GitHubProjectRepository = GitHubProjectDataRepository()
    private var githubProjectList: LiveData<List<GitHubProject>>?


    init {
        githubProjectList = gitHubUserProjectRepository.getUserProjects(username)
    }


    fun getGitHubUserObservable(): LiveData<List<GitHubProject>>? {
        return githubProjectList
    }

}