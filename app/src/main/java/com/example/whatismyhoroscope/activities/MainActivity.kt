package com.example.whatismyhoroscope.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.whatismyhoroscope.R
import com.example.whatismyhoroscope.adapters.HoroscopeAdapter
import com.example.whatismyhoroscope.data.Horoscope

class MainActivity : AppCompatActivity() {

    var horoscopeList:List<Horoscope> = listOf(

        Horoscope(R.drawable.aquarius_sign, R.string.horoscope_name_aquarius),
        Horoscope(R.drawable.aries_sign, R.string.horoscope_name_aries),
        Horoscope(R.drawable.cancer_sign, R.string.horoscope_name_cancer),
        Horoscope(R.drawable.capricorn_sign, R.string.horoscope_name_capricorn),
        Horoscope(R.drawable.gemini_sign, R.string.horoscope_name_gemini),
        Horoscope(R.drawable.leo_sign, R.string.horoscope_name_leo),
        Horoscope(R.drawable.libra_sign, R.string.horoscope_name_libra),
        Horoscope(R.drawable.piscies_sign, R.string.horoscope_name_piscies),
        Horoscope(R.drawable.sagittarius_sign, R.string.horoscope_name_sagittarius),
        Horoscope(R.drawable.scorpio_sign, R.string.horoscope_name_scorpio),
        Horoscope(R.drawable.taurus_sign, R.string.horoscope_name_taurus),
        Horoscope(R.drawable.virgo_sign, R.string.horoscope_name_virgo),


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

        adapter= HoroscopeAdapter(horoscopeList)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter=adapter


    }

}
