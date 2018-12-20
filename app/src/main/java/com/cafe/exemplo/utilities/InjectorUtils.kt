package com.cafe.exemplo.utilities

import com.cafe.exemplo.data.FakeDb
import com.cafe.exemplo.data.PostRepository
import com.cafe.exemplo.ui.posts.PostsViewModelFactory



object InjectorUtils {

    fun providePostsViewModelFactory(): PostsViewModelFactory {
        val postRepository = PostRepository.getInstance(FakeDb.getInstance().postDao)
        return PostsViewModelFactory(postRepository)
    }
}