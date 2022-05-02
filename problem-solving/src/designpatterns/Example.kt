package designpatterns

import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val date = Date()
    val string = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault()).format(date)
    println(string)
}