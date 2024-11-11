package com.example.trafficlight.ui.screens

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class FirstScreenTest {

    private val mockNavController = mock<NavController>()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun carModelInput_showsError_whenLessThanThreeCharacters() {
        composeTestRule.setContent {
            FirstScreen(mockNavController)
        }

        // Find and enter text in the input field with less than 3 characters
        composeTestRule
            .onNodeWithTag("CarModelInput")
            .performTextInput("Te")

        // Verify error message is displayed
        composeTestRule
            .onNodeWithTag("CarModelError")
            .assertIsDisplayed()
            .assertTextContains("must be at least 3 characters")
    }

    @Test
    fun startDrivingButton_isDisabled_whenCarModelIsInvalid() {
        composeTestRule.setContent {
            FirstScreen(mockNavController)
        }

        // Find the button and verify it is disabled initially
        composeTestRule
            .onNodeWithTag("StartDrivingButton")
            .assertIsNotEnabled()

        // Enter an invalid car model
        composeTestRule
            .onNodeWithTag("CarModelInput")
            .performTextInput("Te")

        // Verify the button remains disabled with invalid input
        composeTestRule
            .onNodeWithTag("StartDrivingButton")
            .assertIsNotEnabled()
    }

    @Test
    fun startDrivingButton_isEnabled_whenCarModelIsValid() {
        composeTestRule.setContent {
            FirstScreen(mockNavController)
        }

        // Enter a valid car model
        composeTestRule
            .onNodeWithTag("CarModelInput")
            .performTextInput("Tesla")

        // Verify the button is enabled with valid input
        composeTestRule
            .onNodeWithTag("StartDrivingButton")
            .assertIsEnabled()
    }

    @Test
    fun startDrivingButton_navigatesToSecondScreen_whenCarModelIsValid() {
        composeTestRule.setContent {
            FirstScreen(mockNavController)
        }

        // Enter a valid car model
        composeTestRule
            .onNodeWithTag("CarModelInput")
            .performTextInput("Tesla")

        // Click the "Start Driving" button
        composeTestRule
            .onNodeWithTag("StartDrivingButton")
            .performClick()

        verify(mockNavController).navigate("second_screen_route")
    }
}
