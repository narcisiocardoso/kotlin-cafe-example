package com.cafe.exemplo.ui.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cafe.exemplo.R
import com.cafe.exemplo.data.Post
import com.cafe.exemplo.utilities.InjectorUtils

import kotlinx.android.synthetic.main.activity_posts.*

class PostsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.providePostsViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
                .get(PostsViewModel::class.java)

        viewModel.getPosts().observe(this, Observer { posts ->
            val stringBuilder = StringBuilder()
            posts.forEach { post ->
                stringBuilder.append("$post\n\n")
            }
            textView_posts.text = stringBuilder.toString()
        })

        button_add_post.setOnClickListener {
            val post = Post(editText_title.text.toString(), editText_desc.text.toString())
            viewModel.addPost(post)
            editText_title.setText("")
            editText_desc.setText("")
        }
    }
}
