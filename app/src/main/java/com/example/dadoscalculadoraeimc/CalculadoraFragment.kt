package com.example.dadoscalculadoraeimc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dadoscalculadoraeimc.databinding.FragmentCalculadoraBinding


class CalculadoraFragment : Fragment() {
   private var _b: FragmentCalculadoraBinding? = null
   private val b get () = _b!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _b=FragmentCalculadoraBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}