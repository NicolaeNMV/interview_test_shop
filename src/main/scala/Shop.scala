package nico.hmrc.shop.checkout

case class Product(name: String, price: Double)

class Shop {
  var basket: Seq[Product] = Seq.empty

  def add(products: Seq[String]) {
    val detectedProducts = products.map(Shop.createProduct).flatten
    basket = basket ++ detectedProducts
  }

  // buy one, get one free on Apples
  def calcDiscountApples: Double = {
    val apple = Shop.apple
    val apples = basket.count(_.name == apple.name)
    if (apples > 0) {
      (apples / 2.0).floor * apple.price
    } else {
      0
    }
  }

  def calcDiscount: Double = {
    calcDiscountApples
  }

  def calcTotalWithoutDiscount: Double = {
    basket.foldLeft(0.0)( (sum, product) => sum + product.price)
  }

  def calcTotal: Double = {
    calcTotalWithoutDiscount - calcDiscount
  }
}

object Shop {
  val apple = Product("Apple", 0.6)
  val orange = Product("Orange", 0.25)

  val products = Seq(apple, orange)

  def createProduct(name: String): Option[Product] = {
    products.find(_.name equalsIgnoreCase name)
  }

  def apply(products: Seq[String]): Shop = {
    val shop = new Shop
    shop.add(products)
    shop
  }

}
