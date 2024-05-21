package com.deved.blogapp.di

import com.deved.blogapp.data.RepositoryImpl
import com.deved.blogapp.domain.Repository
import com.deved.blogapp.presentation.BlogVM
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val networkModule = module {
    single {
        HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }
}

val viewModelModule = module {
    viewModelOf(::BlogVM)
}

val repositoryModule = module {
    singleOf(::RepositoryImpl) { bind<Repository>() }
}