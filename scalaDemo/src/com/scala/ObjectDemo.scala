package com.scala

import java.util.ArrayList;


object ObjectDemo {

  def main(args: Array[String]): Unit = {

    val str: String = "123";


    println("Hello world!!!" + str)

    var list: List[String] = List.empty

    // ::在前面添加元素
    list = list.::(str)

    println(list.length)
    println(list)

    var arrayList: ArrayList[String] = new ArrayList();

    arrayList.add(str)

    println(arrayList)


  }


}
