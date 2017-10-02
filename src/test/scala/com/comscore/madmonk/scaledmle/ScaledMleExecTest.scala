package com.comscore.madmonk.scaledmle

import org.scalatest._

/**
  * Created by cpuladas on 7/14/2017.
  */
class ScaledMleExecTest extends FlatSpec with Matchers{

  val executorInstance = new ScaledMleExec

  val testInput = ScaledMleSchema(2.3,4.5,1.3,0.5,1.4)

  "ScaledMleExec" should "return only java.lang.Double" in {
    executorInstance.logicExecutor(testInput) shouldBe a [java.lang.Double]
  }

  "it" should "not return Scala.Double" in {
    executorInstance.logicExecutor(testInput) should not be a [Double]
  }

}
