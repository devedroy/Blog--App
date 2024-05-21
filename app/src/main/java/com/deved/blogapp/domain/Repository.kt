package com.deved.blogapp.domain

import com.deved.blogapp.domain.model.Post


interface Repository {
    suspend fun getPosts(): Result<List<Post>, DataError.Network>
}