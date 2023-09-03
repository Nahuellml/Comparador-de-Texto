package com.curso.android.app.comparadordetexto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.comparadordetexto.viewmodel.ComparacionTextoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ComparacionTextoViewModelUnitTest {

    private lateinit var viewModel: ComparacionTextoViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = ComparacionTextoViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun comparacionTextoViewModel_CheckInitialResult() = runTest {
        viewModel.compararTexto("Hola", "Hola")
        val result = viewModel.comparacionResultadoLiveData.value
        assertEquals(true, result?.esIgual)
    }

    @Test
    fun comparacionTextoViewModel_TestDifferentTexts() = runTest {
        viewModel.compararTexto("Hola", "Mundo")
        val result = viewModel.comparacionResultadoLiveData.value
        assertEquals(false, result?.esIgual)
    }

}