package com.cafe.exemplo.data


class FakeDb private constructor() {

    var postDao = FakePostDao()
        private set

    companion object {
        @Volatile
        private var instance: FakeDb? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: FakeDb().also { instance = it }
                }
    }
}