package com.example.pokedex

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WelcomeActivityUnitTest {
    private lateinit var activity : WelcomeActivity

    @Test
    fun shouldShowWelcomeTextToUser(){
        assertEquals("Welcome, Pedro", activity.showWelcomeText("Pedro"))
    }

    @Before
    fun catchActivity(){
        activity = WelcomeActivity()
    }
}