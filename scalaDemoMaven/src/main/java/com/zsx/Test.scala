package com.zsx

import org.apache.flink.api.common.functions.FlatMapFunction
import org.apache.flink.api.java.ExecutionEnvironment
import org.apache.flink.util.Collector

/**
 * @Author zsx
 * @Date 2021/2/4
 */
object Test {

  // TODO

  def main(args: Array[String]): Unit = {


    // 初始化环境
    val env = ExecutionEnvironment.getExecutionEnvironment

    val text = env.fromElements("abc", "bb", "ab")

//    val counts = text.flatMap {
//      _.toLowerCase.split("\\W+") filter {
//        _.nonEmpty
//      }
//    }
//      .map {
//        (_, 1)
//      }
//      .groupBy(0)
//      .sum(1)
//
//    counts.print()



  }

}
