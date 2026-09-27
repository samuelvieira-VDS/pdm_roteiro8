package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MuralViewModel : ViewModel() {

    private val _post = MutableLiveData<Post>()

    val post: LiveData<Post>
        get() = _post

    fun publicar(titulo: String, mensagem: String) {
        _post.value = Post(titulo, mensagem)
    }
}