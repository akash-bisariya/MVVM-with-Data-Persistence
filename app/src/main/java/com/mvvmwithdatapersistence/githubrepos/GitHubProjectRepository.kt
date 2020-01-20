package com.mvvmwithdatapersistence.githubrepos

import androidx.lifecycle.LiveData

interface GitHubProjectRepository {

    fun getUserProjects(username: String):LiveData<List<GitHubProject>>
}