package nico.hmrc.shop

import checkout.Shop

object Application {

  def main(args: Array[String]) {
    val shop = new Shop()
    val input = "Apple" :: "Apple" :: "Orange" :: "Apple" :: Nil

    shop.add(input)
    println("Products are " + input.mkString(", "))
    println(s"Total is ${shop.calcTotal}")
  }
}
