package com.example.chap5top4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chap5top4.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIndo.setOnClickListener {
            setLocale("id")
        }
        binding.btnIng.setOnClickListener {
            setLocale("en")
        }


        val checkedRadioButtonId = binding.radioGroup.checkedRadioButtonId


//
//        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            if (binding.rdBtn1.isChecked){
//                binding.rdBtn1.isChecked=true
//                setLocale("id")
//            }else if (binding.rdBtn2.isChecked){
//                binding.rdBtn2.isChecked=true
//                setLocale("en")
//            }
//            // Responds to child RadioButton checked/unchecked
//        }

        binding.radioGroup.setOnCheckedChangeListener { buttonView, isChecked->
            if (binding.rdBtn1.isChecked){
                binding.rdBtn1.isChecked=true
                setLocale("id")
            }else if (binding.rdBtn2.isChecked){
                binding.rdBtn2.isChecked=true
                setLocale("en")
            }
            // Responds to radio button being checked/unchecked
        }







    }
    fun setLocale(lang : String?){
        val myLocale = Locale(lang)
        val res = resources
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, res.displayMetrics)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}