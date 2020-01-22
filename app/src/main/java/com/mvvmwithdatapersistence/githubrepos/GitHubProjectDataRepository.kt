package com.mvvmwithdatapersistence.githubrepos

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

class GitHubProjectDataRepository : GitHubProjectRepository {
    private val gitHubService: GitHubService

    init {
        val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        gitHubService = retrofit.create(GitHubService::class.java)
    }


    override fun getUserProjects(username: String): LiveData<List<GitHubProject>> {
        val data: MutableLiveData<List<GitHubProject>> = MutableLiveData()
        gitHubService.getRepos(username).enqueue(object : Callback<List<GitHubProject>> {
            override fun onResponse(call: Call<List<GitHubProject>>, response: Response<List<GitHubProject>>) {
                Log.d("RetroFit Response", "The Reponse from server : " + response.body())
                data.value = response.body()

                when(response.code()){

                }

            }

            override fun onFailure(call: Call<List<GitHubProject>>, t: Throwable) {
                Log.d("RetroFit Response", "The Error response from server : " + t.message)
                data.value = null
            }
        })

        return data
    }
}