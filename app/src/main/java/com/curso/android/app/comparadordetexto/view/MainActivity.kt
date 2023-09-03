package com.curso.android.app.comparadordetexto.view

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.curso.android.app.comparadordetexto.R
import com.curso.android.app.comparadordetexto.databinding.ActivityMainBinding
import com.curso.android.app.comparadordetexto.viewmodel.ComparacionTextoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ComparacionTextoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val texto1 = binding.editText1.text.toString()
            val texto2 = binding.editText2.text.toString()

            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

            if (texto1.isEmpty() || texto2.isEmpty()) {
                binding.resultado.text = getString(R.string.faltaRellenar)
            } else {
                viewModel.compararTexto(texto1, texto2)
            }
        }

        viewModel.comparacionResultadoLiveData.observe(this, Observer { resultado ->
            val resultText = if (resultado.esIgual) {
                getString(R.string.iguales)
            } else {
                getString(R.string.diferentes)
            }
            binding.resultado.text = resultText
        })
    }
}
