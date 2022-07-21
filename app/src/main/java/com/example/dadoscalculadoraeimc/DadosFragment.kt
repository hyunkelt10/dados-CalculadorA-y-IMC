package com.example.dadoscalculadoraeimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dadoscalculadoraeimc.databinding.FragmentCalculadoraBinding
import com.example.dadoscalculadoraeimc.databinding.FragmentDadosBinding
import kotlin.random.Random


class DadosFragment : Fragment() {
    private var _b: FragmentDadosBinding? = null
    private val b get () = _b!!
    private val dados = arrayOf(R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6 )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b=FragmentDadosBinding.inflate(inflater, container, false)
        return b.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b.dado1.setOnClickListener {
            clickOnDado2()
        }
        b.dado2.setOnClickListener {
            clickOnDado2()
        }


        }


    fun clickOnDado2 () {
        val d1 = Random.nextInt(1, 7)
        val d2 = Random.nextInt(1, 7)
        b.dado1.setImageResource(dados[d1 - 1])
        b.dado2.setImageResource(dados[d2 - 1])
        b.textView.text = (d1 + d2).toString()
    }
}