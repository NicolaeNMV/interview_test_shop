package nico.hmrc.shop

import junit.framework.TestCase
import org.junit.Assert._
import checkout.Shop

class ShopTests extends TestCase {

  val apple = Shop.apple
  val orange = Shop.orange

  val DoubleMinVal = 0.00001

  def testEmpty {
    val shop = new Shop()

    assertEquals(0.0, shop.calcTotal, DoubleMinVal)
  }

  def testNominalWithoutDiscount {
    val shop = Shop("Apple" :: "Apple" :: "Orange" :: "Apple" :: Nil)
    val expectedTotal = 3 * apple.price + orange.price

    assertEquals(expectedTotal, shop.calcTotalWithoutDiscount, DoubleMinVal)
  }

  def testAppleDiscount {

    assertEquals(
      "One apple",
      apple.price,
      Shop("Apple" :: Nil).calcTotal,
      DoubleMinVal
    )

    assertEquals(
      "Two apples",
      apple.price,
      Shop("Apple" :: "Apple" :: Nil).calcTotal,
      DoubleMinVal
    )

    assertEquals(
      "Three apples",
      apple.price * 2,
      Shop("Apple" :: "Apple" :: "Apple" :: Nil).calcTotal,
      DoubleMinVal
    )
  }

  def testOrangeDiscount {
    assertEquals(
      "One oranges",
      orange.price,
      Shop(orange.name :: Nil).calcTotal,
      DoubleMinVal
    )

    assertEquals(
      "Two oranges",
      orange.price * 2,
      Shop(orange.name :: orange.name :: Nil).calcTotal,
      DoubleMinVal
    )

    assertEquals(
      "Three oranges",
      orange.price * 2,
      Shop(orange.name :: orange.name :: orange.name :: Nil).calcTotal,
      DoubleMinVal
    )

    assertEquals(
      "Four oranges",
      orange.price * 3,
      Shop(orange.name :: orange.name :: orange.name :: orange.name :: Nil).calcTotal,
      DoubleMinVal
    )
  }
}