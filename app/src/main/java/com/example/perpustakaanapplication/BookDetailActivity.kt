package com.example.perpustakaanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.perpustakaanapplication.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookDetailBinding
    private val book by lazy { intent.getSerializableExtra("book") as Book }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        setupActivity()
    }

    private fun setupActivity() {
        supportActionBar?.title = book.title
        binding.title.text = book.title
        binding.author.text = book.author
        binding.category.text = book.category
        binding.language.text = book.language
        binding.pages.text = book.pages.toString()
        binding.description.text = book.description

        Glide.with(this)
            .load(book.photo)
            .into(binding.image)

        binding.btnOpen.setOnClickListener {
            startActivity(Intent(applicationContext, BookViewActivity::class.java).putExtra("file", book.file).putExtra("title", book.title))
        }
        
        binding.btnFavorite.setOnClickListener {
            Toast.makeText(this, "Buku ${book.title} ditambahkan ke Favorite!", Toast.LENGTH_SHORT).show()
        }

        binding.btnShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Saya baru saja membaca buku yang berjudul ${book.title}")
            startActivity(Intent.createChooser(intent, "send to"))
        }
    }
}