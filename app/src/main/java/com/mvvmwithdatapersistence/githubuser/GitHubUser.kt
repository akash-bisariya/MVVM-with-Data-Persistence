package com.mvvmwithdatapersistence.githubuser

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitHubUser(
    @PrimaryKey
    val id: Int,
    val login: String,
    val name: String,
    val company: String,
    val url: String,
    val avatar_url: String,
    val bio: String,
    val public_repos: String,
    val followers: Int,
    val following: Int
) {
    constructor() : this(0, "", "", "", "", "", "", "", 0, 0)
}