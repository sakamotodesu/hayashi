package com.github.sakamotodesu.cortroller

import java.io.File
import java.nio.charset.StandardCharsets

import com.github.sakamotodesu.model.Problem

import scala.io.Source

/**
  * Created by sakamotominoru on 2016/06/28.
  */
object hayashi2zuknow {

  def main(args: Array[String]) {
    println("hello world")
    val KOU001 = read(new File("/Users/sakamotominoru/Dropbox/backgamon/hayashi/KOU_001K.TXT"))
  }

  def read(kouNNN: File): List[Problem] = {
    println(kouNNN)
    val source = Source.fromFile(kouNNN, "MS932")
    val ret = source.getLines().takeWhile(p => !p.startsWith("ポジション"))
    ret.foreach(println)
    List()
  }
}
