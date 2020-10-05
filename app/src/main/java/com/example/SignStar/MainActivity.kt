package com.example.SignStar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.SignStar.Retrofit.ApiClient
import com.example.SignStar.Retrofit.ApiInterface
import com.example.SignStar.Retrofit.Example
import com.example.weatherapp.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editTextDay: EditText
    lateinit var editTextMonth: EditText
    lateinit var editTextYear: EditText
    lateinit var editTextLat: EditText
    lateinit var editTextLon: EditText
    lateinit var editTextTzone: EditText
    lateinit var editTextMin: EditText
    lateinit var zodiacNameText: TextView
    lateinit var signLordText: TextView
    lateinit var signText: TextView
    lateinit var editTextHour: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextDay = findViewById(R.id.editTextDay)
        editTextMonth = findViewById(R.id.editTextMonth)
        editTextYear = findViewById(R.id.editTextYear)
        editTextLat = findViewById(R.id.editTextLat)
        editTextLon = findViewById(R.id.editTextLon)
        editTextTzone = findViewById(R.id.editTextTzone)
        editTextMin = findViewById(R.id.editTextMin)
        editTextHour = findViewById(R.id.editTextHour)

        button.setOnClickListener(View.OnClickListener { getData(textField.toString().trim { it <= ' ' }) })


    }

    private fun getData(name: String) {

        val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiInterface.getData(name)
        call.enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                try {
                    zodiacNameText.setText("Zodiac " + " " + response.body()!!.main.getName() + " C")
                    signLordText.setText("SignLord" + " " + response.body()!!.main.getSignLord() + " C")
                    signText.setText("Sign" + " " + response.body()!!.main.getSign() + " C")

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {}
        })
    }

}