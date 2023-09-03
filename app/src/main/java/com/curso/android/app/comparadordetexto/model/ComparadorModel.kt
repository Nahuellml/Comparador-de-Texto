package com.curso.android.app.comparadordetexto.model

class ComparacionTextoResultado(val esIgual: Boolean)

class ComparadorTexto {
    fun compararTexto(texto1: String, texto2: String): ComparacionTextoResultado{
        return ComparacionTextoResultado(texto1 == texto2)
    }
}