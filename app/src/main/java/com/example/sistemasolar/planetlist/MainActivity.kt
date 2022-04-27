package com.example.sistemasolar.planetlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistemasolar.R
import com.example.sistemasolar.vista2.detail

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PlanetListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel= ViewModelProvider(this).get(PlanetListViewModel::class.java)

        initUI()
    }

    private fun initUI() {
        val planetlistRecyclerView=findViewById(R.id.planetlistRecyclerView) as RecyclerView
        planetlistRecyclerView.layoutManager = LinearLayoutManager(this)
        planetlistRecyclerView.adapter=PlanetListAdapter{
            val intent= Intent(this,detail::class.java)
            intent.putExtra("id",it)
            startActivity(intent)
        }

        viewModel.getPlanetList()

        viewModel.planetList.observe(this, Observer { list ->
            val ekis=(planetlistRecyclerView.adapter as PlanetListAdapter)
            ekis.setData(list)
        })
    }
}