package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class QuestionUnitTests {

  private lateinit var question: Question

  @Before
  fun setup() {
    question = Question("CORRECT", "INCORRECT")
  }

  @Test
  fun whenCreatingQuestion_shouldNotHaveAnsweredOption() {
    Assert.assertNull(question.answeredOption)
  }

  @Test
  fun whenAnswering_shouldHaveAnsweredOption() {
    // Act
    question.answer("INCORRECT")

    // Assert
    Assert.assertEquals("INCORRECT", question.answeredOption)
  }

  @Test
  fun whenAnswering_whitCorrectOption_shouldReturnTrue() {
    // Act
    val actual = question.answer("CORRECT")

    // Assert
    Assert.assertTrue(actual)
  }

  @Test
  fun whenAnswering_withIncorrectOption_shouldReturnFalse() {
    // Act
    val actual = question.answer("INCORRECT")

    // Assert
    Assert.assertFalse(actual)
  }

  @Test(expected = IllegalArgumentException::class)
  fun whenAnswering_withInvalidOption_shouldThrowException() {
    // Act
    question.answer("INVALID")
  }

  @Test
  fun whenCreatingANewQuestion_isAnsweredCorrectlyShouldBeFalse() {
    // Assert
    Assert.assertFalse(question.isAnsweredCorrectly)
  }

  @Test
  fun whenAnsweredCorrectly_isAnsweredCorrectlyShouldBeTrue() {
    // Act
    question.answer("CORRECT")

    // Assert
    Assert.assertTrue(question.isAnsweredCorrectly)
  }
}