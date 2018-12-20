package com.cafe.exemplo.ui.posts

import androidx.lifecycle.ViewModel
import com.cafe.exemplo.data.Post
import com.cafe.exemplo.data.PostRepository


class PostsViewModel(private val postRepository: PostRepository)
    : ViewModel() {

    fun getPosts() = postRepository.getPosts()

    fun addPost(post: Post) = postRepository.addPost(post)
}