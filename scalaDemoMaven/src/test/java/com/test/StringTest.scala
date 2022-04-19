package com.test

/**
 */
object StringTest {

  var str: String = "test"

  def main(args: Array[String]): Unit = {

// 字符串长度  todo
    val length = str.length
    val len = str.length()

    println(str)

    println(length)
    println(len)


    println("字符串".concat("拼接"))
    println("a"+"b")


  }



}
