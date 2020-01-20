package com.mvvmwithdatapersistence.githubuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mvvmwithdatapersistence.BuildConfig
import com.mvvmwithdatapersistence.service.GitHubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GitHubUserDataRepository :
    GitHubUserRepository {
    private var gitHubUserService: GitHubService

    init {
        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gitHubUserService = retrofit.create(GitHubService::class.java)
    }


    override fun getGithubUser(userName:String):LiveData<GitHubUser>?{
        val data: MutableLiveData<GitHubUser>? = MutableLiveData()
        gitHubUserService.getUser(userName).enqueue(object : Callback<GitHubUser>{

            override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {


                Log.d("RetroFit Response","The Reponse from server : "+response.body())
                data!!.value = response.body()

            }

            override fun onFailure(call: Call<GitHubUser>, t: Throwable) {

                Log.d("RetroFit Response","The Error response from server : "+t.message)
                data!!.value = null
            }
        })
        return data

    }



}