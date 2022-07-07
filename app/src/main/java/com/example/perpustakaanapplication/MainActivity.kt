package com.example.perpustakaanapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.perpustakaanapplication.databinding.ActivityMainBinding
import java.io.File
import java.lang.reflect.Method

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "List Book Perpustakaan"
        loading()
        setupList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(applicationContext, AboutActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loading() {
        supportActionBar?.hide()
        binding.loading.visibility = View.VISIBLE
        Handler().postDelayed({
            binding.loading.visibility = View.GONE
            supportActionBar?.show()
        }, 1500)
    }

    private fun setupList(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = BookAdapter(BookData.listBook, object: BookAdapter.OnItemClickCallback{
                override fun onItemClicked(data: Book) {
                    startActivity(Intent(applicationContext, BookDetailActivity::class.java).putExtra("book", data))
                }
            })
        }
    }
}