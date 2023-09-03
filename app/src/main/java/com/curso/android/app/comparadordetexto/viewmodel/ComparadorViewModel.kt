package com.curso.android.app.comparadordetexto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.comparadordetexto.model.ComparacionTextoResultado
import com.curso.android.app.comparadordetexto.model.ComparadorTexto

class ComparacionTextoViewModel: ViewModel() {
    private val comparadorTexto = ComparadorTexto()
    private val _comparacionResultadoLiveData = MutableLiveData<ComparacionTextoResultado>()
    val comparacionResultadoLiveData: LiveData<ComparacionTextoResultado>
        get() = _comparacionResultadoLiveData

    fun compararTexto(texto1: String, texto2: String){
        val resultado = comparadorTexto.compararTexto(texto1, texto2)
        _comparacionResultadoLiveData.value = resultado
    }
}