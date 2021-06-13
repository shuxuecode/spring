package com.scala

object Test {

  //定义方法声明格式  def functionName ([参数列表]) : [return type]
  def m(x: Int) = x + 5

  // 定义函数
  val f = (x: Int) => x + 5


  def main(args: Array[String]): Unit = {
    val i = m(5)
    println(i)

    val i1 = f(i)
    println(i1)


    Demo

  }

}
