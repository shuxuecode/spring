package com.zsx

import org.apache.flink.api.java.ExecutionEnvironment

/**
 * @Author zsx
 * @Date 2021/2/4
 */
object Test {


  def main(args: Array[String]): Unit = {


    val env = ExecutionEnvironment.getExecutionEnvironment

    val filePath = ""

    val dataSet = env.readTextFile(filePath)


  }

}
