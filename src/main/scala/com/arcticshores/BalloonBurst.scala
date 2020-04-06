package com.arcticshores

import com.arcticshores.models.Balloon
import com.arcticshores.utils.BalloonUtils

import scala.io.StdIn

object BalloonBurst extends App {

  def run() = {
    println("Please enter balloon values:")

    val balloonsInput = StdIn.readLine()

    val splitInput = BalloonUtils.splitInput(balloonsInput)

    val balloons = splitInput.map(x => Balloon(x))

    val completedBalloons = balloons.map(BalloonUtils.processBalloon)

    val score = BalloonUtils.sumBalloons(completedBalloons)

    println(s"SCORE: $score")
  }

  this.run()

}
