package com.ysx.hello

class Runoob {
    var name: String = "cainiao"
    var url: String = "www.yangshaoxiong.tech"
    var city: String = "Xi'an"
}

//fun main(args: Array<String>) {
//    val site = Runoob()
//    println(site.name)
//    println(site.url)
//    println(site.city)
//}

class Person {
    var lastName: String = "zhang"
        get() = field.toUpperCase()
        set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    var height: Float = 145.4F
        private set

}

fun main(args: Array<String>) {
    var person: Person = Person()

    person.lastName = "wang"

    println("lastName: ${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

}