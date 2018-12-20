package com.cafe.exemplo.data


data class Post(val title: String,
                val description: String) {
    override fun toString(): String {
        return "$title - $description"
    }
}