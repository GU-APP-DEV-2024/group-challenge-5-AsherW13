package com.zybooks.workingwithdata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zybooks.workingwithdata.NasaAPI.ImageData

class MarsPics : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var marsImageDataSet: ArrayList<ImageData>
    lateinit var imageCustomAdapter: ImageCustomAdapterMars

    data class ImageData(val url: String, val description: String = "", val date: String = "") {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mars_pics)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        marsImageDataSet = arrayListOf(ImageData("https://mars.nasa.gov/mars2020-raw-images/pub/ods/surface/sol/00988/ids/edr/browse/zcam/ZL0_0988_0754649489_081EBY_N0470000ZCAM08997_1100LMJ01_1200.jpg", ""),
            ImageData("https://mars.nasa.gov/mars2020-raw-images/pub/ods/surface/sol/00871/ids/edr/browse/rcam/RRF_0871_0744271096_012ECM_N0422700RHAZ02420_01_295J01_1200.jpg", ""))
        imageCustomAdapter = ImageCustomAdapterMars(marsImageDataSet)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = imageCustomAdapter
    }
}