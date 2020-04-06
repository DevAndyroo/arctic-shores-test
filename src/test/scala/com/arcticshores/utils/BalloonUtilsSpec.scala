package com.arcticshores.utils

import com.arcticshores.models.Balloon
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class BalloonUtilsSpec extends AnyWordSpecLike with Matchers {

  "Balloon Burst #splitInput" should {
    "Parse 1 number" in {
      BalloonUtils.splitInput("1") shouldBe List(1)
    }

    "Parse a list of numbers" in {
      BalloonUtils.splitInput("1 5 10 100") shouldBe List(1, 5, 10, 100)
    }
  }

  "Balloon Burst #score" should {
    "score a single balloon" in {
      val balloons = List(Balloon(5, 4))
      BalloonUtils.sumBalloons(balloons) shouldBe 4
    }

    "score a list of balloons" in {
      val balloons = List(Balloon(5, 4), Balloon(1, 2), Balloon(2, 2))
      BalloonUtils.sumBalloons(balloons) shouldBe 6
    }
  }

  "Balloon Burst #scoreSingleBalloon" should {
    "score a correctly filled balloon" in {
      val balloon = Balloon(4, 4)
      BalloonUtils.scoreSingleBalloon(balloon) shouldBe 4
    }

    "Score a burst balloon with 0" in {
      val balloon = Balloon(4, 5)
      BalloonUtils.scoreSingleBalloon(balloon) shouldBe 0
    }
  }
}
