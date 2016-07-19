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
    val ret = pack(source.getLines().toList)
      .filter(x => x(2).startsWith("           X to play"))
      .map(prombel)
    ret.foreach(println)
    List()
  }

  def pack(lines: List[String]): List[List[String]] = {
    if (lines.isEmpty) List(List())
    //val (packed, next) = lines span { p => !p.startsWith("           X to play") }
    val (packed, next) = lines span { p => !p.startsWith("ポジション") }
    if (next == Nil || next.size == 1) {
      List(packed)
    } else {
      packed :: pack(next.head.replaceAll("ポジション", "") :: next.tail)
    }
  }

  def prombel(line: List[String]) = {
    val pattern = ".*MAIL(.*)$".r
    val id = line.head match {
      case pattern(num) => Some(num)
      case _ => None
    }
    println(id)
    line
  }
}
