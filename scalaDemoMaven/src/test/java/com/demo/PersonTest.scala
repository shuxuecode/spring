package com.demo

object PersonTest {

  def main(args: Array[String]): Unit = {
    val person = new Person()
    person.name = "demo"
    person.age = 12

    println(person)
    println(person.getInfo)
  }
}
