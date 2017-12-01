# Kotlin 学习笔记

[菜鸟教程-Kotlin](http://www.runoob.com/kotlin/kotlin-tutorial.html)

## 1. 基础语法

### 1.1 常量与变量
**可变变量定义**

使用var关键字来定义常量：

`var <标识符> : <类型> = <初始化值>`

eg.

`var a: Int = 1`

**不可变变量定义**

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

## 1.2 字符串模板

<font color=red>**`$`**</font> 表示一个变量名或者变量值
<font color=red>**`$varName`**</font> 表示变量值
<font color=red>**`${varName.fun()}`**</font> 表示变量的方法返回值:

```
fun main(args: Array<String>) {
    var a = 1
    val s1 = "a is $a"
    // 输出为 s1: a is 1
    println("s1: " + s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    // 输出为 s2: a was 1, but now is 2
    println("s2: " + s2)
}
```

## 1.3 null检查机制

Kotlin 中的变量，默认不可以为null，**类型**后面加<font color=red>**`?`**</font>表示可以为空:

```
    var age: String? = "23"
    // 可以赋予空值
    age = null
    println("age: " + age)
    var age1: String = "20"
    // 不声明可以为空，则不能赋予空值
    // age1 = null
```

对于可以为空的变量，对于空值，可以有三种操作：

1. 变量后添加`!!`表示如果为null，则抛出异常。
2. 变量后加`?`表示如果值为null，则不做处理，返回null。
3. 变量后边加`?:`表示如果变量值为null，则执行后边的语句。

```
    // 变量后添加`!!`表示如果为null，则抛出异常。 kotlin.KotlinNullPointerException
    // var ageInt = age!!.toInt()
    // 变量后加`?`表示如果值为null，则不做处理，返回null
    var ageInt2 = age?.toInt()
    println("ageInt: " + ageInt2)
    // 变量后边加`?:`表示如果变量值为null，则执行后边的语句。
    var x: String? = null
    println(x ?: -1)
    // 空值检测 end
```

## 1.4 类型检测及自动类型转换

判断一个对象是否为一个类的实例，可以使用is关键字
与 Java 中的instanceof关键字类似，但在 Kotlin 中如果已经确定了一个对象的类型，可以在接下来的代码块中直接作为这个确定类型使用，而不用向java那样需要强制类型转换。

```
fun getStringLength(obj: Any): Int? {
  if (obj is String) {
    // 做过类型判断以后，obj会被系统自动转换为String类型
    return obj.length 
  }

  //同时还可以使用!is，来取反
  if (obj !is String){
  }

  // 代码块外部的obj仍然是Any类型的引用
  return null
}
```

## 1.5 区间

区间表达式由具有操作符形式 **`..`** 的 **`rangeTo`** 函数辅以 **`in`** 和 **`!in`** 形成。
区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。

## 1.6 函数定义

函数定义使用关键字 **`fun`**，参数格式为：`参数 : 类型`

```
fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
```

**表达式**作为函数体，返回类型自动推断：

```
fun sum(a: Int, b: Int) = a + b

public fun sum(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型
```

无返回值的函数(类似Java中的void)：

```
fun printSum(a: Int, b: Int): Unit { 
    print(a + b)
}


// 如果是返回 Unit类型，则可以省略(对于public方法也是这样)：
public fun printSum(a: Int, b: Int) { 
    print(a + b)
}
```

### 可变长参数函数

函数的变长参数可以用 **`vararg`** 关键字进行标识：

```
fun vars(vararg v:Int){
    for(vt in v){
        print(vt)
    }
}

// 测试
fun main(args: Array<String>) {
    vars(1,2,3,4,5)  // 输出12345
}
```

### lambda(匿名函数)

```
fun main(args: Array<String>) {
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))  // 输出 3
}
```

## 2. Kotlin 基本数据类型

Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。

|类型   |位宽度|
|:-----:|:-----:|
| Double|64|
| Float |32|
| Long  |64|
| Int   |32|
| Short |16|
| Byte  |8|

**字面常量**

下面是所有类型的字面常量：

- 十进制：123
- 长整型以大写的 L 结尾：123L
- 16 进制以 0x 开头：0x0F
- 2 进制以 0b 开头：0b00001011
- 注意：8进制不支持

### 2.1 比较两个数字

Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。数字类型也一样，所有在比较两个数字的时候，就有比较**数据大小**和比较**两个对象是否相同**的区别了。
在 Kotlin 中，三个等号 <font color=red>**`===`**</font> 表示比较对象地址，两个 <font color=red>**`==`**</font> 表示比较两个值大小。

```
fun main(args: Array<String>) {
    val a: Int = 10000
    // true，值相等，对象地址相等
    println("(a === a): " + (a === a))

    // 经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    // 虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
    println(boxedA == anotherBoxedA) // true，值相等
}
```

### 2.2 类型转换

由于不同的表达方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。这以为着在不进行显示转换的情况下我们不能把Byte型值赋给一个Int变量。

```
    val b: Byte = 1 // OK, 字面值是静态检测的
    val i: Int = b // 错误
```

我们可以代用其toInt()方法:

```
    val b1: Byte = 1 // OK, 字面值是静态检测的
    val i1: Int = b.toInt() // OK
```

**每种**数据类型都有下面的这些方法，可以转化为其它的类型：

```
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
```

有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：

```
val l = 1L + 3 // Long + Int => Long
```

### 2.3 位操作符
对于Int和Long类型，可以使用位操作符，分别是：

```
shl(bits) – 左移位 (Java’s <<)
shr(bits) – 右移位 (Java’s >>)
ushr(bits) – 无符号右移位 (Java’s >>>)
and(bits) – 与
or(bits) – 或
xor(bits) – 异或
inv() – 反向
```

### 2.4 字符

和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，Char 必需是<font color=red>**单引号`''`**</font>包含起来的。比如普通字符 '0'，'a'。

### 2.5 布尔类型

true和false。常用运算有：

```
||  逻辑或(会短路)
&&  逻辑与(会短路)
!  逻辑非
```

### 2.6 数组

数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便的获取或者设置数组对应位置的值。

数组的创建两种方式：

- 使用函数arrayOf()
- 使用工厂函数

如下所示，我们分别是两种方式创建了两个数组：

```
val a = arrayOf(1,2,3)

val b = Array(3, {i -> (i * 2)})

//读取数组内容
println(a[0])    // 输出结果：1
println(b[1])    // 输出结果：2
```

如上所述，[] 运算符代表调用成员函数 get() 和 set()。
注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。

除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：

```
    val x: IntArray = intArrayOf(1, 2, 3)
    println("before x[0]: " + x[0]) // 1
    x[0] = x[1] + x[2]
    println("after x[0]: " + x[0]) // 5
```

### 2.7 字符串

和 Java 一样，String 是**可不变**的。方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：

```
    val str: String = "Hello"
    for (c in str) {
        println(c)
    }
```

多行字符串，使用**三个引号**表示，类似于python中的多行字符串：

```
    val text = """
        多行字符串 1
        多行字符串 2
        """
    println(text)
```

### 2.8 字符串模板

字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。 模板表达式以**美元符**（$）开头，由一个简单的名字构成:

```
    val i = 10
    val s = "i = $i" // 求值结果为 "i = 10"
    println(s)
```

或者用**花括号**扩起来的任意**表达式**:

```
    val s1 = "hello"
    // hello.length is 5
    val str = "$s1.length is ${s1.length}"
    println(str)
```

## 参考

[Kotlin 资源大全 - 学 Kotlin 看这一篇教程就够了](http://blog.csdn.net/cenzr/article/details/72674849)

[Kotlin 中文文档](http://www.kotlincn.net/docs/reference/)