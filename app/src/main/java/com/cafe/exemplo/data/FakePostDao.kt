package com.cafe.exemplo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class FakePostDao {
    private val postList = mutableListOf<Post>()
    private val posts = MutableLiveData<List<Post>>()

    init {
        posts.value = postList
    }

    fun addPost(post: Post) {
        postList.add(post)
        posts.value = postList
    }

    fun getPosts() = posts as LiveData<List<Post>>
}