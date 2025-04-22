class Product(
    val title: String = "codetree",
    val code: Int = 50,
) {
    override fun toString(): String {
        return "product $code is $title"
    }
}

fun main() {
    val input = readLine()!!.split(" ")
    val productName = input[0]
    val productCode = input[1].toInt()

    println(Product())
    println(Product(productName, productCode))
}