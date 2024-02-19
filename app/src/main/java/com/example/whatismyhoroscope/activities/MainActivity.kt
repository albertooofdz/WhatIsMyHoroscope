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
import com.example.whatismyhoroscope.R
import com.example.whatismyhoroscope.adapters.HoroscopeAdapter
import com.example.whatismyhoroscope.data.Horoscope

class MainActivity : AppCompatActivity() {

    var horoscopeList:List<Horoscope> = listOf(

        Horoscope(R.drawable.aquarius_sign, R.string.horoscope_name_aquarius, "Jan 20-Feb 18"),
        Horoscope(R.drawable.aries_sign, R.string.horoscope_name_aries,"March 21-April 19"),
        Horoscope(R.drawable.cancer_sign, R.string.horoscope_name_cancer,"June 21-July 22"),
        Horoscope(R.drawable.capricorn_sign, R.string.horoscope_name_capricorn,"December 22-January 19"),
        Horoscope(R.drawable.gemini_sign, R.string.horoscope_name_gemini,"May 21-June 20"),
        Horoscope(R.drawable.leo_sign, R.string.horoscope_name_leo,"July 23-August 22"),
        Horoscope(R.drawable.libra_sign, R.string.horoscope_name_libra,"September 23-October 22"),
        Horoscope(R.drawable.piscies_sign, R.string.horoscope_name_piscies,"Feb 19-March 20"),
        Horoscope(R.drawable.sagittarius_sign, R.string.horoscope_name_sagittarius,"November 22-December 21"),
        Horoscope(R.drawable.scorpio_sign, R.string.horoscope_name_scorpio,"October 23-November 21"),
        Horoscope(R.drawable.taurus_sign, R.string.horoscope_name_taurus,"April 20-May 20"),
        Horoscope(R.drawable.virgo_sign, R.string.horoscope_name_virgo,"August 23-September 22"),


    )




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

            intent.putExtra("HOROSCOPE_NAME", horoscopeList[position].name)
            intent.putExtra("HOROSCOPE_IMAGE", horoscopeList[position].image)
            intent.putExtra("HOROSCOPE_DATE", horoscopeList[position].date)

            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter=adapter
    }

}
