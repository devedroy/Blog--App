package com.deved.blogapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deved.blogapp.domain.Repository
import com.deved.blogapp.domain.Result
import kotlinx.coroutines.launch

class BlogVM(private val repository: Repository) : ViewModel() {
    fun getPosts() {
        viewModelScope.launch {
            when (val result = repository.getPosts()) {
                is Result.Error -> {
                    Log.d("BlogVM", "getPosts: ${result.error}")
                }

                is Result.Success -> {
                    Log.d("BlogVM", "getPosts: ${result.data}")
                }
            }
        }
    }
}