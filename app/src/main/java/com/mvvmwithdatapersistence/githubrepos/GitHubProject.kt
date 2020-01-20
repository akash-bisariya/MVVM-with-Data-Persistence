package com.mvvmwithdatapersistence.githubrepos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GitHubProject (

    @PrimaryKey
    val id: Long,
    val name: String,
    val url:String,
    val private:Boolean,
    val language:String,
    val created_at:String,
    val size:Long
    ){
    constructor():this(0,"","",false,"","",0)
}