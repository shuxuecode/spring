package com.test

/**
 */
object UnitTest {

  def main(args: Array[String]): Unit = {

    val array = MethodTest.test("a,b,c,d")

    println(array.mkString("Array(", ", ", ")"))

    val num = FunctionTest.fun(10)

    println(num)
  }

}
