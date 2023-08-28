package com.venicio.imgur.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.venicio.imgur.databinding.ActivityMainBinding
import com.venicio.imgur.view.adapter.ImgurAdapter
import com.venicio.imgur.viewmodel.ImgurViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val imgurViewModel: ImgurViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerAdapter: ImgurAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        imgurViewModel.imagesAPI.observe(this, Observer { response ->
                setupRecyclerView()
                recyclerAdapter.submitList(response)
        })
    }

    private fun setupRecyclerView() {
        val recycler = binding.rvImgurImages
        recyclerAdapter = ImgurAdapter()
        recycler.adapter = recyclerAdapter
    }


}