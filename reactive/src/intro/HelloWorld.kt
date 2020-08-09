package intro


fun main(args: Array<String>) {

    val fibonacciSeries = sequence {
        var a = 0
        var b = 1
        yield(a)
        yield(b)

        while (true) {
            val c = a + b
            yield(c)
            a = b
            b = c
        }
    }

    val item = fibonacciSeries.take(10)
    for (i in item) {
        println(i)
    }
}


