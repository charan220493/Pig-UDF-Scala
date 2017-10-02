package com.comscore.madmonk.scaledmle
import org.apache.pig.data.TupleFactory
import org.scalatest._

/**
  * Created by cpuladas on 7/12/2017.
  */
class ScaledMleTest extends FlatSpec {

  val scaledMleInstance = new ScaledMle
  val testTuple = TupleFactory.getInstance().newTuple(5)
  //testTuple.set(0,0.3)
  //testTuple.set(1,2.3)
  //testTuple.set(2,2.3)
  testTuple.set(3,2.3)

  "ScaledMle" should "return some value when no nulls are present" in {
    assertResult(0){
      scaledMleInstance.exec(testTuple)
    }
  }

  "it" should "throw java.lang.ClassCastException if input is null" in {
    testTuple.set(3,"")
    assertThrows[java.lang.ClassCastException]{
      scaledMleInstance.exec(testTuple)
    }

  }

  "it" should "throw java.lang.ClassCastException if input is not Double" in {
    testTuple.set(4,0)
    assertThrows[java.lang.ClassCastException]{
      scaledMleInstance.exec(testTuple)
    }

  }

  "it" should "throw java.lang.ClassCastException if input is String" in {
    testTuple.set(4,"$%lol")
    assertThrows[java.lang.ClassCastException]{
      scaledMleInstance.exec(testTuple)
    }
  }

  "it" should "throw java.lang.IllegalArgumentException if input size is greater than 5" in {
    testTuple.append(3.5)
    assertThrows[java.lang.IllegalArgumentException]{
      scaledMleInstance.exec(testTuple)
    }
  }

}
