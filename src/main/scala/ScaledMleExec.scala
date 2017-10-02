

/**
  * Created by cpuladas on 7/11/2017.
  */
class ScaledMleExec {

  def logicExecutor(schemaInput: ScaledMleSchema) : Double = {
    val a: Double = schemaInput.projA - schemaInput.projB
    val b: Double = schemaInput.projB - schemaInput.projX

    //val xx: Double = proj_x
    if ((schemaInput.bigA + schemaInput.bigB) < (a + b + schemaInput.projX))
      -1.0
    else if (schemaInput.projX == 0) {
      -2.0
    }
    else {
      val C1 = schemaInput.projX * (schemaInput.bigA + schemaInput.bigB + 1 - (a + b + schemaInput.projX))
      val C2 = schemaInput.bigA * b * (schemaInput.bigA - a) + schemaInput.bigB * a * (schemaInput.bigB - b)
      val C3 = (schemaInput.bigA * b) + (schemaInput.bigB * a) - (a * b)

      val a0 = (schemaInput.bigA * schemaInput.bigB * C1) - C2
      val a1 = C3 - C2 - (schemaInput.bigA + schemaInput.bigB) * C1
      val a2 = C1 + C3

      val inter = ((-a1 - Math.sqrt((a1*a1) - (4*a0* a2))) / (2 * a2)) + 0.5
      inter
    }

  }

}
