package com.example.pra_asesmen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.persegi_panjang.*

class PersegiPanjang : Fragment(){
    private lateinit var binding: PersegiPanjang
    private var nilaiPanjang: Double=0.00
    private var nilaiLebar: Double=0.00
    private var nilaiLuas: Double=0.00
    private var nilaiKeliling: Double=0.00

    companion object{
        const val KEY_NILAILUAS = "key_nilaiLuas"
        const val KEY_NILAIKELILING = "key_nilaiKeliling"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
            DataBindingUtil.inflate(inflater, R.layout.persegi_panjang, container, false)
        if (savedInstanceState != null){
            nilaiLuas = savedInstanceState.getDouble(KEY_NILAILUAS)
            nilaiKeliling = savedInstanceState.getDouble(KEY_NILAIKELILING)
//            updateNilai(nilaiLuas, nilaiKeliling)
        }
        binding.buttonHitungPersegi.setOnClickListener {
            if(binding.panjangPersegi.text.toString().isEmpty() || binding.lebarPersegi.text.toString().isEmpty()) {
                Toast.makeText(this.activity, "Field Tidak Boleh Kosong!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                    nilaiPanjang = binding.panjangPersegi.text.toString().toDouble()
                    nilaiLebar = binding.lebarPersegi.text.toString().toDouble()
                    nilaiLuas = nilaiPanjang * nilaiLebar
                    nilaiKeliling = 2 * (nilaiPanjang + nilaiLebar)
                    binding.luasPersegi.text = "Luas = $nilaiLuas"
                    binding.kelilingPersegi.text = "Keliling = $nilaiKeliling"
                }
            }

        binding.buttonShare.setOnClickListener {
        }
        }
    }