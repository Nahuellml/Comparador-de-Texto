package com.curso.android.app.comparadordetexto

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.myapplicationcomparador.view.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareTexts_equal() {
        val texto1 = "Hola"
        val texto2 = "Hola"

        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            ViewActions.typeText(texto1)
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            ViewActions.typeText(texto2)
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.iguales)
            )
        )
    }

    @Test
    fun mainActivity_compareTexts_different() {
        val texto1 = "Hola"
        val texto2 = "Mundo"

        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).perform(
            ViewActions.typeText(texto1)
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).perform(
            ViewActions.typeText(texto2)
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.diferentes)
            )
        )
    }
}