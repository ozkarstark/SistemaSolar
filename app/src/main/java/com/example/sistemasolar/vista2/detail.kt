package com.example.sistemasolar.vista2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.sistemasolar.R
import com.example.sistemasolar.planetlist.PlanetListAdapter
import com.example.sistemasolar.planetlist.PlanetListViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class detail : AppCompatActivity() {

    private lateinit var viewModel: PlanetListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel= ViewModelProvider(this).get(PlanetListViewModel::class.java)

        initUI()
    }

    private fun initUI() {
        var id=intent.extras?.get("id") as Int
        id-=1
        println("enterprise: "+id)
        viewModel.getPlanetList()

        viewModel.planetList.observe(this, Observer { list ->
            Glide.with(this).load(list.get(id).image).into(ImageView)
            nameTextView.text=list.get(id).name
            if(id==7){
                summaryText.text = list.get(id).summary
            }else {
                summaryText.text = list.get(id).text
            }
        })

    }
}