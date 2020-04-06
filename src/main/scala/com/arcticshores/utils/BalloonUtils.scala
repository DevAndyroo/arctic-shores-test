package com.arcticshores.utils

import com.arcticshores.models.Balloon

import scala.io.StdIn

object BalloonUtils {

  def splitInput(input: String): List[Int] =
    input.split(" ").toList.map(_.toInt)

  def processBalloon(balloon: Balloon): Balloon = {
    StdIn.readLine().trim.toLowerCase match {
      case "inflate" =>
        val newBalloon = balloon.copy(fill = balloon.fill + 1)
        if (newBalloon.fill > newBalloon.size) {
          println("BURST")
          newBalloon
        } else {
          processBalloon(newBalloon)
        }
      case "bank" =>
        balloon
      case _ =>
        processBalloon(balloon)
    }
  }

  def sumBalloons(balloons: List[Balloon]): Int = {
    balloons match {
      case Nil            => 0
      case balloon :: Nil => scoreSingleBalloon(balloon)
      case balloon :: remainingBalloons =>
        scoreSingleBalloon(balloon) + sumBalloons(remainingBalloons)
    }
  }

  def scoreSingleBalloon(balloon: Balloon): Int = {
    if (balloon.fill > balloon.size) 0
    else balloon.fill
  }

}
