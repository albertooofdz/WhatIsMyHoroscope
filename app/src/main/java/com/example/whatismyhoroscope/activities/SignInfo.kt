package com.example.whatismyhoroscope.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.example.horoscope.data.HoroscopeProvider
import com.example.whatismyhoroscope.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInfo : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var signImageView: ImageView
    lateinit var horoscopeInfo: TextView
    lateinit var dateTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_info)

        //var horoscopeName:String? = null

        var horoscopeNameId = intent.getIntExtra("HOROSCOPE_NAME", -1)
        val horoscopeImageId = intent.getIntExtra("HOROSCOPE_IMAGE", -1)
        val horoscopeDateId = intent.getStringExtra("HOROSCOPE_DATE")

        dateTextView = findViewById(R.id.signDateTextView)
        nameTextView = findViewById(R.id.nameTextView)
        signImageView = findViewById(R.id.signImageView)
        horoscopeInfo= findViewById(R.id.horoscopeInfoTextView)


        nameTextView.text = getString(horoscopeNameId)
        signImageView.setImageResource(horoscopeImageId)
        dateTextView.text=horoscopeDateId

        //nameTextView.text= horoscopeName

        getHoroscopeInfo(getString(horoscopeNameId))
    }


    fun getHoroscopeInfo(horoscopeName:String) {

        CoroutineScope(Dispatchers.IO).launch {


            val result= HoroscopeProvider().getHoroscopeLuck(horoscopeName)
            runOnUiThread{

            horoscopeInfo.text = result

            }



        }




    }

}