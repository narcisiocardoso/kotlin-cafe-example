package com.cafe.exemplo.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cafe.exemplo.data.PostRepository

class PostsViewModelFactory(private val postRepository: PostRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(postRepository) as T
    }
}