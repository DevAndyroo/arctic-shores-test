package com.arcticshores

import java.io.{ByteArrayOutputStream, StringReader}

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class BalloonBurstTest extends AnyWordSpecLike with Matchers {
  "BalloonBurst" should {
    "complete with a score of 5" in {
      val input =
        """2 1 5
          |INFLATE
          |INFLATE
          |BANK
          |INFLATE
          |INFLATE
          |INFLATE
          |INFLATE
          |INFLATE
          |BANK
          |""".stripMargin
      val in = new StringReader(input)
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        Console.withIn(in) {
          BalloonBurst.run()
        }
      }
      out.toString should include("SCORE: 5")
    }

    "complete with a score of 0" in {
      val input =
        """1
          |INFLATE
          |INFLATE""".stripMargin
      val in = new StringReader(input)
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        Console.withIn(in) {
          BalloonBurst.run()
        }
      }
      out.toString should include("BURST")
    }
  }
}
