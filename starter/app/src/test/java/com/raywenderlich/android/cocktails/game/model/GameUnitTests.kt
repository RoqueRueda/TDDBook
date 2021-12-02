package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameUnitTests {

  private lateinit var game: Game

  @Before
  fun setUp() {
    game = Game()
  }

  @Test
  fun whenIncrementingScore_shouldIncrementCurrentScore() {
    game.incrementScore()

    Assert.assertEquals("Current score should have been 1", 1, game.currentScore)
  }

  @Test
  fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {

    // Act
    game.incrementScore()

    // Assert
    Assert.assertEquals(1, game.highestScore)
  }

  @Test
  fun whenIncrementingScore_belowHighScore_shouldNotIncrementHighScore() {
    // Arrange
    val game = Game(10)

    // Act
    game.incrementScore()

    // Assert
    Assert.assertEquals(10, game.highestScore)
  }

  @Test
  fun whenCreatingAGame_shouldContainAnEmptyListOfQuestions() {

    // Assert
    Assert.assertTrue(game.questionList.isEmpty())
  }

  @Test
  fun whenAGameHasNotMoreQuestions_shouldReturnNullOnNextQuestion() {

    // Act
    val actual = game.nextQuestion()

    // Assert
    Assert.assertNull(actual)
  }

  @Test
  fun whenAGameHasQuestions_nextQuestionShouldReturnTheFollowingQuestion() {
    // Arrange
    val questionList = listOf(
      Question("CORRECT", "INCORRECT"),
      Question("CORRECT", "INCORRECT")
    )
    val game = Game(questionList = questionList)

    // Act
    val actual = game.nextQuestion()

    // Assert
    Assert.assertEquals(questionList[0], actual)
  }

  @Test
  fun whenAGameHasQuestions_nextQuestionShouldReturnTheFollowingQuestionsTillEnd() {
    // Arrange
    val questionList = listOf(
      Question("1", "INCORRECT"),
      Question("2", "INCORRECT")
    )
    val game = Game(questionList = questionList)

    // Act
    val firstQuestion = game.nextQuestion()
    val secondQuestion = game.nextQuestion()
    val noMoreQuestions = game.nextQuestion()

    // Assert
    Assert.assertEquals(questionList[0], firstQuestion)
    Assert.assertEquals(questionList[1], secondQuestion)
    Assert.assertNull(noMoreQuestions)
  }

  @Test
  fun whenAGameHasQuestions_shouldReturnTheOptionsOfTheQuestion() {
    // Arrange
    val question = Question("CORRECT", "INCORRECT")

    // Act
    val optionList = question.getOptions { it.reversed() }

    // Assert
    Assert.assertEquals(optionList[0], "INCORRECT")
  }
}
