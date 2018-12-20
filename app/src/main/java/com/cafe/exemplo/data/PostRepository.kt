package com.cafe.exemplo.data


class PostRepository private constructor(private val postDao: FakePostDao){

    fun addPost(post: Post) {
        postDao.addPost(post)
    }

    fun getPosts() = postDao.getPosts()

    companion object {
        @Volatile private var instance: PostRepository? = null

        fun getInstance(postDao: FakePostDao) =
                instance ?: synchronized(this) {
                    instance ?: PostRepository(postDao).also { instance = it }
                }
    }
}