package easy

import java.util.*


fun main() {
    Test()
}


class Test{
    val value1 = "1".also { print(it) }  // "1"
    init{ print("2") }  // "2"
    val value2 = "3".also{print(it)}  // "3"
    init{ print("4") }   // "4"
    constructor(){ print("5")} // 5
    companion object {
        val value3 = "7".also{print(it)}   // 7
        val value4 = "9".also{print(it)} //9
    }
}