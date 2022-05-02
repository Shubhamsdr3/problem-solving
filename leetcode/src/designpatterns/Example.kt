package designpatterns


fun main() {
    val params = mutableListOf<User>()
    params.add(User("Shubham", 1))
    params.add(User("Shubham", 2))
    params.add(User("Shubham", 3))
    params.add(User("Shubham", 4))
    params.add(User("Shubham", 5))
    var index = 20
    params.map {
        it.age = ++index
    }
    println(params.toString())

}

data class User(val name: String, var age: Int)