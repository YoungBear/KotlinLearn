package com.ysx.hello

fun sum(a: Int, b: Int): Int {
    return a + b
}

// 表达式作为函数体，返回类型自动推断：
fun sum2(a: Int, b: Int) = a + b

// public 方法则必须明确写出返回类型
public fun sum3(a: Int, b: Int) : Int = a + b

// 无返回值的函数(类似Java中的void):
fun printSum(a: Int, b: Int) : Unit {
    print(a + b)
}

// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun printSum2(a : Int, b: Int) {
    print(a + b)
}

// 函数的变长参数可以用 vararg 关键字进行标识：
fun vars(vararg v: Int) {
    for(vt in v) {
        print(vt)
    }
}

// 测试
fun main(args: Array<String>) {
    val sumLambda : (Int, Int) -> Int = {x,y -> x + y}
    println(sumLambda(1,2))
}

fun test() {
    var a: Int = 1
    val c: Int = 1
}



