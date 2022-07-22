package com.example.dadoscalculadoraeimc

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.dadoscalculadoraeimc.databinding.FragmentDadosBinding
import com.example.dadoscalculadoraeimc.databinding.FragmentImcBinding
import com.google.android.material.snackbar.Snackbar


class imcFragment : Fragment() {
    private var _b: FragmentImcBinding? = null
    private val b get () = _b!!
    private var height = 150
    private var weight = 75
    private var doubleHeight = 2.25
    private var IMC = 33.33





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b=FragmentImcBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b.skbHeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvHeightValue.text = progress.toString().plus("/200")
                height = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) { calcIMC() }
        })

        b.skbWeight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                b.tvWeightValue.text = progress.toString().plus("/150")
                weight = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?)  { calcIMC() }
        })

        b.imageView.setOnClickListener { seleccion() }
    }



    fun calcIMC () {
        doubleHeight = height.times(height)/10000.0
        IMC = Math.round((weight/doubleHeight)
            .times(100))
            .div(100.0)
        b.tvIMC.text = IMC.toString()
        calcObesidad()
    }

    fun calcObesidad () {
        val colorSnackbar = when (IMC){
            in 0.0..15.99 -> ContextCompat.getColor(requireContext(), R.color.delgadez_severa)
            in 16.0..16.99 -> ContextCompat.getColor(requireContext(), R.color.delgadez_moderada)
            in 17.0..18.49 -> ContextCompat.getColor(requireContext(), R.color.delgadez_leve)
            in 18.5..24.99 -> ContextCompat.getColor(requireContext(), R.color.normal)
            in 25.0..29.99 -> ContextCompat.getColor(requireContext(), R.color.preobesidad)
            in 30.0..34.99 -> ContextCompat.getColor(requireContext(), R.color.obesidad_leve)
            in 35.0..39.99 -> ContextCompat.getColor(requireContext(), R.color.obesidad_media)
            else -> ContextCompat.getColor(requireContext(), R.color.obesidad_morbida)
        }
        val obesidad = when (IMC){
            in 0.0..15.99 -> "DELGADEZ SEVERA"
            in 16.0..16.99 -> "DELGADEZ MODERADA"
            in 17.0..18.49 -> "DELGADEZ LEVE"
            in 18.5..24.99 -> "NORMAL"
            in 25.0..29.99 -> "PREOBESIDAD"
            in 30.0..34.99 -> "OBESIDAD LEVE"
            in 35.0..39.99 -> "OBESIDAD MEDIA"
            else -> "OBESIDAD MÓRBIDA"
        }
        val sb = Snackbar.make(b.root, obesidad, Snackbar.LENGTH_LONG)
        sb.setTextColor(Color.WHITE)
        sb.setBackgroundTint(colorSnackbar)
        sb.setActionTextColor(Color.DKGRAY)
        sb.setAction("Ver Tabla"){
            showTable()
        }
        sb.show()
    }
    fun showTable(){
        val dialog = TableFragment()
        dialog.show(requireActivity().supportFragmentManager, "TablaPeso")
//        dialog.show(getParentFragmentManager(), "TablaPeso")
    }

    fun seleccion () {
        val inflater = this.layoutInflater
        val custom_layout = inflater.inflate(R.layout.tabla_imc, null)


        AlertDialog.Builder((requireContext()), R.style.MyThemeOverlay)
            .setView(custom_layout)


            .setPositiveButton(R.string.aceptar, null)


            .show()
    }
}