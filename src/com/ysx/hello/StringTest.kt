package com.ysx.hello

fun main(args: Array<String>) {

    // 字符串模板 start
    var a = 1
    val s1 = "a is $a"
    // 输出为 s1: a is 1
    println("s1: " + s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    // 输出为 s2: a was 1, but now is 2
    println("s2: " + s2)

    // 字符串模板 end

    // 空值检测 start
    var age: String? = "23"
    // 可以赋予空值
    age = null
    println("age: " + age)
    var age1: String = "20"
    // 不声明可以为空，则不能赋予空值
    // age1 = null
    println("age1: " + age1)

    // 变量后添加`!!`表示如果为null，则抛出异常。 kotlin.KotlinNullPointerException
    // var ageInt = age!!.toInt()
    // 变量后加`?`表示如果值为null，则不做处理，返回null
    var ageInt2 = age?.toInt()
    println("ageInt: " + ageInt2)
    // 变量后边加`?:`表示如果变量值为null，则执行后边的语句。
    var x: String? = null
    println(x ?: -1)


    val x1 = parseInt("1")
    val y1 = parseInt("2")
    if (x1 != null && y1 != null) {
        println(x1 * y1)
    }


    // 空值检测 end


}

fun parseInt(str: String): Int? {
    return str.toInt()
}