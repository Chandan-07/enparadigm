package com.enparadigm.app.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.enparadigm.app.R
import com.enparadigm.model.ResponseRecord
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  lateinit var weatherViewModel: WeatherViewModel
  lateinit var observer: Observer<ResponseRecord>
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    AndroidInjection.inject(this)
    setContentView(R.layout.activity_main)
    weatherViewModel =
      ViewModelProvider(this,viewModelFactory).get(WeatherViewModel::class.java)
    subscribeImageList()
    initViews()
  }



  private fun initViews() {
    get.setOnClickListener{
      if (etEdit.editableText!=null && etEdit.editableText.toString().isNotEmpty()){
        weatherViewModel.getWeatherList(etEdit.editableText.toString())
      }else{
        Toast.makeText(this,"Please type city name to see result",Toast.LENGTH_SHORT).show()
      }
    }
  }

  private fun subscribeImageList() {
    observer= Observer {
      if(it!=null ){
        temp.text= "Temperature :-"+it.main.main.toString()+" 'C"
        humidity.text= "Humidity :- "+it.main.humidity.toString()
        wind.text= "Wind :- "+it.wind.speed.toString()+" km/hr"
        pressure.text= "Pressure :- "+it.main.pressure.toString()
    }else{
        Log.d("ONERRORR", "sdasd")

      }
    }
    weatherViewModel.subScribeWeather().observe(this,observer)
  }
}
