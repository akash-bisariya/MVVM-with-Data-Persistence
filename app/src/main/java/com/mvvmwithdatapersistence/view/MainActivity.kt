package com.mvvmwithdatapersistence.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mvvmwithdatapersistence.R
import com.mvvmwithdatapersistence.githubrepos.GitHubProject
import com.mvvmwithdatapersistence.githubrepos.GitHubProjectViewModel
import com.mvvmwithdatapersistence.githubuser.GitHubUser
import com.mvvmwithdatapersistence.githubuser.GitHubUserViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_submit_github_user.setOnClickListener(this)
//
//        val viewModel = ViewModelProviders.of(this).get(GitHubUserViewModel::class.java)
//
//        observeViewModel(viewModel)
    }

    private fun observeUserViewModel(viewModel: GitHubUserViewModel) {
        viewModel.getGitHubUserObservable()?.observe(this, Observer<GitHubUser> {
                it?.apply {
                    Log.d("Observe Change", "Observe change in data")
                    tv_github_user_name.text = it.login
                    tv_github_user_company.text = it.company
                    tv_github_user_profile.text = it.bio
                    tv_github_user_follower.text = """${it.followers}"""
                }
            }
        )
    }

    private fun observeProjectViewModel(viewModel: GitHubProjectViewModel) {
        viewModel.getGitHubUserObservable()?.observe(this, Observer<List<GitHubProject>> {
            it?.apply {
                Log.d("Observe Change", "Observe change in data")
                tv_project_name.text = it[0].name
                tv_project_url.text = it[0].url
                tv_project_language.text = it[0].language
                tv_project_created_at.text = it[0].created_at
                tv_project_size.text = ""+it[0].size
            }
        }
        )
    }

    override fun onClick(v: View?) {
        if (v != null) when(v.id){
            (R.id.btn_submit_github_user)->{
                val userViewModel = ViewModelProviders.of(this).get(GitHubUserViewModel::class.java)
                val projectViewModel = ViewModelProviders.of(this).get(GitHubProjectViewModel::class.java)
                observeUserViewModel(userViewModel)
                observeProjectViewModel(projectViewModel)
            }
        }
    }
}
