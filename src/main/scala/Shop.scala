package nico.hmrc.shop.checkout

case class Product(name: String, price: Double)

class Shop {
  var basket: Seq[Product] = Seq.empty

  def add(products: Seq[String]) {
    val detectedProducts = products.map(Shop.createProduct).flatten
    basket = basket ++ detectedProducts
  }

  def calcTotal: Double = {
    basket.foldLeft(0.0)( (sum, product) => sum + product.price)
  }
}

object Shop {
  val products = Seq(
    Product("Apple", 0.6),
    Product("Orange", 0.25)
  )

  def createProduct(name: String): Option[Product] = {
    products.find(_.name equalsIgnoreCase name)
  }

}
