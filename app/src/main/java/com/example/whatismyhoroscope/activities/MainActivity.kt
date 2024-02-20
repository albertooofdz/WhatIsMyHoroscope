package com.example.whatismyhoroscope.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.horoscope.data.HoroscopeProvider
import com.example.whatismyhoroscope.R
import com.example.whatismyhoroscope.adapters.HoroscopeAdapter
import com.example.whatismyhoroscope.data.Horoscope

class MainActivity : AppCompatActivity() {

   val horoscopeList : List<Horoscope> = HoroscopeProvider().getHoroscopes()



    lateinit var adapter: HoroscopeAdapter
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()
    }


    fun initView(){
        recyclerView=findViewById(R.id.recyclerView)




        adapter= HoroscopeAdapter(horoscopeList){position ->
            Toast.makeText(this, getString(horoscopeList[position].name), Toast.LENGTH_LONG).show()


            val intent = Intent(this@MainActivity, SignInfo::class.java)

            intent.putExtra("HOROSCOPE_ID", horoscopeList[position].id)

            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter=adapter
    }

}
