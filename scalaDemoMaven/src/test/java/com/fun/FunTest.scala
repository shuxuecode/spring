package com.fun

object FunTest {

  // 参数设置默认值
  def fun1(name: String, age: Int, telephone: String = "无"): Unit = {
    println(s"姓名：${name}, 年龄：${age}, 电话：${telephone}")
  }

  def main(args: Array[String]): Unit = {
    fun1("测试", 22, "123")

    fun1(age = 25, name = "带名参数，可以打乱参数顺序")
  }
}
