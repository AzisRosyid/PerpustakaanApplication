package com.example.perpustakaanapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.perpustakaanapplication.databinding.ActivityBookViewBinding

class BookViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = intent.getStringExtra("title")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        binding.bookView.fromAsset(intent.getStringExtra("file")).load()
    }

}