package graphtheory

val aVar by lazy {
    var i = 0
    println("I am computed the $i value as ${++i}")
    "Good Day"
}
fun main(args: Array<String>) {
    println(aVar)
    println(aVar)
}