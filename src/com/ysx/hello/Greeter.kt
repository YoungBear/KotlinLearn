package com.ysx.hello

class Greeter(val name : String) {
    fun greet() {
        println("Hello Greeter: " + name)
    }
}

fun main(args: Array<String>) {
    Greeter(args[0]).greet()
}