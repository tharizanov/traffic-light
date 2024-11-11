package com.example.trafficlight.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun carModel_isDisplayed() {
        val carModel = "Tesla"
        composeTestRule.setContent {
            SecondScreen(carModel = carModel)
        }

        // Check if the car model text is displayed correctly
        composeTestRule
            .onNodeWithText("Car Model: $carModel")
            .assertIsDisplayed()
    }

    @Test
    fun trafficLight_sequenceWorksCorrectly() = runBlocking {
        val carModel = "Tesla"
        composeTestRule.setContent {
            SecondScreen(carModel = carModel)
        }

        // Define test tags for the lights
        val redLightTag = "RedLight"
        val orangeLightTag = "OrangeLight"
        val greenLightTag = "GreenLight"

        // Check each traffic light stage in sequence

        // Step 1: Check that only the red light is bright for 4 seconds
        composeTestRule
            .onNodeWithTag(redLightTag)
            .assertExists()
            .assertHasClickAction()
        composeTestRule
            .onNodeWithTag(orangeLightTag)
            .assertExists()
            .assertHasClickAction()
            .assertIsNotFocused() // checks it is inactive
        composeTestRule
            .onNodeWithTag(greenLightTag)
            .assertExists()
            .assertHasClickAction()
            .assertIsNotFocused() // checks it is inactive
        delay(4000) // wait for red light duration

        // Step 2: Red & Orange lights bright for 1 second
        composeTestRule
            .onNodeWithTag(redLightTag)
            .assertExists()
            .assertIsFocused()
        composeTestRule
            .onNodeWithTag(orangeLightTag)
            .assertExists()
            .assertIsFocused()
        delay(1000) // wait for combined duration

        // Step 3: Green light on for 4 seconds
        composeTestRule
            .onNodeWithTag(greenLightTag)
            .assertExists()
            .assertIsFocused()
        delay(4000)

        // Step 4: Orange light on for 1 second
        composeTestRule
            .onNodeWithTag(orangeLightTag)
            .assertExists()
            .assertIsFocused()
        delay(1000)
    }
}
