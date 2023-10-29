package com.example.di

import com.example.core.CollectionBuilder
import com.example.core.MongoBuilder
import com.example.data.MongoUserDataSource
import com.example.data.UserDataSource
import com.example.data.UserRepositoryImpl
import com.example.domain.UserRepository
import com.example.domain.UserService
import com.example.model.User
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineCollection
import org.litote.kmongo.coroutine.CoroutineDatabase

val userModule = module {
    single<CoroutineDatabase> { MongoBuilder().build() }
    single<CoroutineCollection<User>> { CollectionBuilder(get()).buildUser() }
    singleOf(::MongoUserDataSource) { bind<UserDataSource>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::UserService)
}