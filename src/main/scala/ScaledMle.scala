package com.comscore.madmonk.scaledmle

import org.apache.pig.EvalFunc
import org.apache.pig.data.{Tuple, TupleFactory}

import scala.util.{Failure, Success, Try}


/**
  * Created by cpuladas on 7/11/2017.
  */
class ScaledMle extends EvalFunc[Double] {

  val constant = new Constants
  val executor = new ScaledMleExec

  override def exec(input: Tuple): Double =  {

    if (input.size() != 5) {
      throw new IllegalArgumentException
    }

      val inputTuple = Try (ScaledMleSchema(input.get(constant.Zero).asInstanceOf[Double],
        input.get(constant.One).asInstanceOf[Double],
        input.get(constant.Two).asInstanceOf[Double],
        input.get(constant.Three).asInstanceOf[Double],
        input.get(constant.Four).asInstanceOf[Double]))



    inputTuple match {
      case Success(v) => println(inputTuple)
        executor.logicExecutor(v)
      case Failure(e) => println(input)
        throw e
    }

  }

}
