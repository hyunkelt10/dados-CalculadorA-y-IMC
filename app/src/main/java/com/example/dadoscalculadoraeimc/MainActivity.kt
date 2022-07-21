package com.example.dadoscalculadoraeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.dadoscalculadoraeimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.dados -> {
                    Navigation.findNavController(b.fragmentContainerView).navigate(R.id.dadosFragment)
                    true
                }
                R.id.calculadora -> {
                    findNavController(R.id.fragmentContainerView).navigate(R.id.calculadoraFragment)
                    true }
                R.id.imc -> {
                    b.fragmentContainerView.findNavController().navigate(R.id.imcFragment)
                    true}
                else -> false
            }

        }



    }


}
