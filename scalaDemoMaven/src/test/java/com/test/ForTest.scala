package com.test

object ForTest {

  def main(args: Array[String]): Unit = {

    for (i <- 0 until 10) {
      println(i)
    }

    for (i <- 0 to 5) {
      println(i)
    }
    // 跟上面等价
    for (i <- 0.to(5)) {
      println(i)
    }
  }

}
