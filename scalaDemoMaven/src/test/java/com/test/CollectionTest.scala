package com.test

object CollectionTest {


  def main(args: Array[String]): Unit = {
    var list = List(1,2,3,4)

    println(list)

    var set = Set(2,2,3,4)

    println(set)

    var map = Map("a"->1, "b"->2)
    println(map)

  }



}
