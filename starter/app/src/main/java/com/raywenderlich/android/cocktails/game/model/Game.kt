package com.raywenderlich.android.cocktails.game.model

class Game(highest: Int = 0, val questionList: List<Question> = emptyList()) {
  private var questionPosition: Int = 0
  var highestScore = highest
    private set
  var currentScore = 0
    private set

  fun incrementScore() {
    currentScore++
    if (currentScore > highestScore) {
      highestScore = currentScore
    }
  }

  fun nextQuestion(): Question? {
    return if (thereIsNoMoreQuestions()) {
      null
    } else {
      val nq = getNextQuestion()
      moveToNextQuestion()
      return nq
    }
  }

  private fun getNextQuestion(): Question = questionList[questionPosition]

  private fun moveToNextQuestion() = questionPosition++

  private fun thereIsNoMoreQuestions(): Boolean = questionPosition > questionList.size -1

}
