package kotlinexamples

import java.util.*

class Example {



}

fun main() {
    var a = 10
    val var1 = a.apply {
        30
        "Shubham"
    }
    println("Var1: $var1")

    val var2 = a.let {
        30
        "Value is Shubham"
        40
    }

    val var3 = a.also {
        100
    }
    println("Var3: $var3")

    val var4 = with(a) {
        150
    }

    val var5 = a.run {
        200
    }
    println("Var5: $var5")

}