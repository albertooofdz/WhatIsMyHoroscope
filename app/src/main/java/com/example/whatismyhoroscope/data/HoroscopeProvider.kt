package com.example.horoscope.data

import android.util.Log
import com.example.whatismyhoroscope.R
import com.example.whatismyhoroscope.data.Horoscope
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import javax.net.ssl.HttpsURLConnection

class HoroscopeProvider {


    private var horoscopeList:List<Horoscope> = listOf(

        Horoscope("Aquarius", R.drawable.aquarius_sign, R.string.horoscope_name_aquarius, "Jan 20-Feb 18"),
        Horoscope("Aries" , R.drawable.aries_sign, R.string.horoscope_name_aries,"March 21-April 19"),
        Horoscope("Cancer", R.drawable.cancer_sign, R.string.horoscope_name_cancer,"June 21-July 22"),
        Horoscope("Capricorn" , R.drawable.capricorn_sign, R.string.horoscope_name_capricorn,"December 22-January 19"),
        Horoscope("Gemini" , R.drawable.gemini_sign, R.string.horoscope_name_gemini,"May 21-June 20"),
        Horoscope("Leo", R.drawable.leo_sign, R.string.horoscope_name_leo,"July 23-August 22"),
        Horoscope("Libra", R.drawable.libra_sign, R.string.horoscope_name_libra,"September 23-October 22"),
        Horoscope("Piscies", R.drawable.piscies_sign, R.string.horoscope_name_piscies,"Feb 19-March 20"),
        Horoscope("Saggitarius", R.drawable.sagittarius_sign, R.string.horoscope_name_sagittarius,"November 22-December 21"),
        Horoscope("Scorpio" , R.drawable.scorpio_sign, R.string.horoscope_name_scorpio,"October 23-November 21"),
        Horoscope("Taurus" , R.drawable.taurus_sign, R.string.horoscope_name_taurus,"April 20-May 20"),
        Horoscope("Virgo", R.drawable.virgo_sign, R.string.horoscope_name_virgo,"August 23-September 22"),

    )

    fun getHoroscopes() :List<Horoscope> {
        return horoscopeList
    }

    fun getHoroscope(id:String):Horoscope {
        return horoscopeList.filter {it.id==id}.first()

    }





    suspend fun getHoroscopeLuck(horoscopeId: String): String? {
        val url = URL("https://horoscope-app-api.vercel.app/api/v1/get-horoscope/daily?sign=$horoscopeId&day=TODAY") // URL de la API o endpoint
        var connection: HttpsURLConnection? = null
        var result: String? = null

        Log.i("HTTP", "Llamando al API con url: ${url.toString()}")
        try {
            // Crear la conexión HTTP
            connection = url.openConnection() as HttpsURLConnection
            connection.requestMethod = "GET" // Establecer el método GET
            connection.setRequestProperty("Accept", "application/json") // Establecer el tipo de contenido
            connection.connectTimeout = 10000

            // Leer la respuesta de la solicitud
            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = readStream (connection.inputStream)
                Log.i("HTTP", "Respuesta: ${response.toString()}")

                val responseObject: JSONObject = JSONObject(response.toString())
                result = responseObject.getJSONObject("data").getString("horoscope_data")
            } else {
                Log.i("HTTP", "Error en la solicitud. Código de respuesta: $responseCode")
            }

        } catch (e: IOException) {
            Log.e("HTTP", "Error en la solicitud. ", e)
            Log.e("HTTP", e.stackTraceToString())
        } catch (e: Exception) {
            Log.e("HTTP", "Error en la solicitud. ", e)
            Log.e("HTTP", e.stackTraceToString())
        } finally {
            // Cerrar la conexión
            connection?.disconnect()
        }
        return result
    }

    private fun readStream (inputStream: InputStream) : StringBuilder {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }
        reader.close()
        return response
    }
}