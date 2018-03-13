package com.ipinyou.experiment

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.typesafe.config._
import java.io.File

class SparkDriver {

}

object SparkDriver {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.parseFile(new File("conf/application.conf"))
    val conf = new SparkConf().setAppName("SparkDriverApp")
    val sc = new SparkContext(conf)

    val inputPath = config.getString("spark.inputPath")
    println("inputPath = " + inputPath)
    sc.textFile(inputPath).map(line => ("line", 1)).reduceByKey(_ + _).collect().foreach(println)

    sc.stop()
  }
}

