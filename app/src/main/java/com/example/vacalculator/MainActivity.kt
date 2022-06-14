package com.example.vacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.vacalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(CalculatorFragment())

        binding.buttonNavigation.setOnItemSelectedListener{

            when (it.itemId) {
                R.id.calculator -> {
                changeFragment(CalculatorFragment())
                }

                R.id.history -> {
                changeFragment(FragmentHistory())
                }
            }
            true
        }


    }

    fun changeFragment(fmt:Fragment){
        supportFragmentManager.beginTransaction().replace(binding.fragmentHolder.id, fmt).commit()
    }

}