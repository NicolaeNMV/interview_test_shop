package nico.hmrc.shop

import junit.framework.TestCase
import org.junit.Assert._
import checkout.Shop

class ShopTests extends TestCase {

  def testEmpty {
    val shop = new Shop()
    val input = "Apple" :: "Apple" :: "Orange" :: "Apple" :: Nil

    assertEquals(0.0, shop.calcTotal, Double.MinValue)
  }

  def testNominal {
    val shop = new Shop()
    val input = "Apple" :: "Apple" :: "Orange" :: "Apple" :: Nil

    shop.add(input)

    assertEquals(2.05, shop.calcTotal, Double.MinValue)
  }

}