package com.ysx.hello

fun main(args: Array<String>) {
//    val a: Int = 10000
    // true，值相等，对象地址相等
//    println("(a === a): " + (a === a))

    // 经过了装箱，创建了两个不同的对象
//    val boxedA: Int? = a
//    val anotherBoxedA: Int? = a

    // 虽然经过了装箱，但是值是相等的，都是10000
//    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
//    println(boxedA == anotherBoxedA) // true，值相等

//    bit_fun()
//    arrayTest()
//    stringTest()
    stringTemplate()
}

fun test_fun(): Unit {
    val b: Byte = 1 // OK, 字面值是静态检测的
    // val i: Int = b // 错误

    val b1: Byte = 1 // OK, 字面值是静态检测的
    val i1: Int = b.toInt() // OK

    val long1 = 1L + 3 // Long + Int => Long

}

fun bit_fun(): Unit {
    println("bit_fun start.....")
    val a: Int = 2
    val b: Int = 3
    println("a: " + a + ", b: " + b)
    // 左移位 相当于java中的<<
    println("a.shl(1): " + a.shl(1))
    // 右移位 相当于java中的>>
    println("a.shr(1): " + a.shr(1))
    println("a.shr(3): " + a.shr(3))
    // 无符号右移位 相当于java中的>>>
    println("a.ushr(3): " + a.ushr(3))
    // and 与
    println("(a and b): " + (a and b))
    // or 或
    println("(a or b): " + (a or b))
    // xor 异或
    println("(a xor b): " + (a xor b))
    // inv 按位取反
    println("a.inv(): " + (a.inv()))
    println("bit_fun end.....")
}

fun arrayTest(): Unit {
    println("arrayTest start.....")
    val a = arrayOf(1, 2, 3)

    val b = Array(3, { i -> (i * 2) })

    println("a[0]: " + a[0])
    println("b[1]: " + b[1])

    val x: IntArray = intArrayOf(1, 2, 3)
    println("before x[0]: " + x[0]) // 1
    x[0] = x[1] + x[2]
    println("after x[0]: " + x[0]) // 5
    println("arrayTest end.....")
}

fun stringTest(): Unit {
    println("stringTest start.....")
    val str: String = "Hello"
    for (c in str) {
        println(c)
    }

    val text = """
        多行字符串 1
        多行字符串 2
        """
    println(text) // 输出有一些前置空格
    println(text.length) // 输出有一些前置空格
    // String 可以通过 trimMargin() 方法来删除多余的空白
    println(text.trimMargin())
    println(text.trimMargin().length)
    println("stringTest end.....")
}

fun stringTemplate(): Unit {
    println("stringTemplate start.....")
    val i = 10
    val s = "i = $i" // 求值结果为 "i = 10"
    println(s)

    val s1 = "hello"
    // hello.length is 5
    val str = "$s1.length is ${s1.length}"
    println(str)

    println('$' + "9.99")
    println("stringTemplate end.....")
}