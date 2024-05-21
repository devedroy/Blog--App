package com.deved.blogapp.data

import com.deved.blogapp.domain.DataError
import com.deved.blogapp.domain.Repository
import com.deved.blogapp.domain.Result
import com.deved.blogapp.domain.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RepositoryImpl(private val client: HttpClient) : Repository {
    override suspend fun getPosts(): Result<List<Post>, DataError.Network> {
        return try {
            Result.Success(client.get("https://jsonplaceholder.typicode.com/posts"))
        } catch (e: Exception) {
            Result.Error(DataError.Network.SERIALIZATION_ERROR)
        }
    }
}