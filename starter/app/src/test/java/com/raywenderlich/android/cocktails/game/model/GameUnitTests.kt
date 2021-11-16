package com.raywenderlich.android.cocktails.game.model

import org.junit.Assert
import org.junit.Test

class GameUnitTests {

  // 1
  @Test
  fun whenIncrementingScore_shouldIncrementCurrentScore() {
    // 2
    val game = Game()

    // 3
    game.incrementScore()

    // 4
    Assert.assertEquals("Current score should have been 1", 1, game.currentScore)
  }

  @Test
  fun whenIncrementingScore_aboveHighScore_shouldAlsoIncrementHighScore() {
    // Arrange
    val game = Game()

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
}
