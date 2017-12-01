# Kotlin 学习笔记

[菜鸟教程-Kotlin](http://www.runoob.com/kotlin/kotlin-tutorial.html)

## 基础

### 可变变量定义

使用var关键字来定义常量：

`var <标识符> : <类型> = <初始化值>`

eg.

`var a: Int = 1`

### 不可变变量定义

val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)

`val <标识符> : <类型> = <初始化值>`

eg.

`val c: Int = 1`

常量与变量都可以没有初始化值,但是在引用前必须初始化
编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断。

```
val a: Int = 1
val b = 1       // 系统自动推断变量类型为Int
val c: Int      // 如果不在声明时初始化则必须提供变量类型
c = 1           // 明确赋值


var x = 5        // 系统自动推断变量类型为Int
x += 1           // 变量可修改
```