package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            trocarFragment(PublicarFragment())
        }

        binding.btnPublicar.setOnClickListener {
            trocarFragment(PublicarFragment())
        }

        binding.btnMural.setOnClickListener {
            trocarFragment(MuralFragment())
        }
    }

    private fun trocarFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}