package designpatterns

import java.lang.Exception


fun main() {
    val res = divider(100, 0)
    print(res)
}

fun divider(numerator: Int, denominator: Int): Int {
    println("Divison started")
    try {
        val res = numerator / denominator
        return res
    } catch (ex: Exception) {
        println("Divided by Zero Exception")
        return -1
    } finally {
        println("Divison complete")
    }
}

class Example {
    enum class Type {A, B} var x = 0
    val type = Type.A

}



class TestScore  {

    var score: Int? = null
    get() {
        return if (isNotNull() && score!! < 0) {
            0
        } else {
            score
        }
    }

    private fun isNotNull(): Boolean {
        return score != null
    }
}