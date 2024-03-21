package com.selcukileri.getirpractices

import android.annotation.SuppressLint
import android.app.Person
import android.health.connect.datatypes.units.Length
import android.icu.text.MessagePattern.ArgType
import android.os.Build
import android.support.v4.os.IResultReceiver.Default
import androidx.annotation.RequiresApi
import org.jetbrains.annotations.NotNull
import java.io.File
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Comparator
import java.util.Objects

var a = 0

fun main(){

    println("Page 9 : Hello World")
    sum(3,5) // Page 10
    sum2(4,5) // Page 10
    sum3(2,7) // Page 10
    incrementX()
    println("the perimeter is ${rectangle.perimeter}") //Page12
    println("the perimeter is ${rectangle2.perimeter}") //Page12
    println("proper way: ${qwe}") // Page 15

    var a2 = 1 // page 14
    val s1 = "a2 is $a2" // page 14
    a2 = 2 // page 14
    val s2 = "${s1.replace("is", "was")} but now is $a" // page 14
    println("s2: $s2") // Page 14
    fruits() // Page 16

    val dog = Dog()
    dog.makeSound()         // Page 48
}
fun sum(a: Int, b: Int) : Unit{
    println("$a + $b = ${a+b}") // Page 10
}
fun sum2(a:Int, b:Int) = a+b // Page 10

fun sum3(a: Int, b: Int) : Int{
    return a+b // Page 10
}

fun incrementX(){
     a += 1 // Page 11
}
class Shape
class Rectangle(val height: Double, val length: Double) {
    val perimeter = (height + length) * 2 // Page 12
}
val rectangle = Rectangle(16.0, 3.5) // Page 12

open class Shape2
class Rectangle2(val height: Double, val length: Double): Shape2(){
    val perimeter = (height + length) * 2 // Page 12
}
val rectangle2 = Rectangle2(5.0,7.2) // Page 12

open class Color {
    // Page 13
}
class Rectangle3: Color() {
    // Page 13
}

fun maxOf(a: Int, b:Int) : Int {
    if (a>b) {
        return a
    } else {     // Page 15
        return b
    }
}
fun maxOfProperWay(a:Int, b: Int) : Int = if(a>b) a else b // Page 15
val qwe = maxOfProperWay(5,6) // PAge 15
fun fruits(){
    val items = listOf("Apple","Banana","Kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")        // PAge 17
    }
}
fun fruits2(){
    val items = listOf("apple","banana","kiwi")
    var index = 0
    while (index < items.size){
        println("item at $index is = ${items[index]}")      // PAge 17
        index++
    }
}

fun usageOfWhen(){
    fun describe(obj:Any): String =
        when(obj){
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"                   //PAGE 18
            !is String -> "Not a String"
            else -> "Unknown"
        }
}

//Page 19

fun usageOfRange(){
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }
    var list = listOf("a","b","c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices){
        println("list size is out of valid list indices range, too")
    }
    for (x in 1..5){
        println(x)
    }
    for (x in 1..10 step 2) {
        println(x)
    }
    for (x in 9 downTo 0 step 3){
        println(x)
    }
}

// Page 20

fun usageOfCollections(){
    val fruits = listOf("banana","kiwi","apple", "avocado")
    fruits.filter {
        it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

// Page 21

fun nullableUsage(){
    var b: String? = "abc"
    if (b == null){
        println("b is null")
    }
}

//Page 22

fun typeCheckAndAutoCasts(obj: String): Int? {
    if (obj is String) {
        return obj.length
    }
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    if (obj !is String) return null

    return null
}

// Page 26

const val MAX_COUNT = 8
val USER_NAME_FIELD = "UserName"
fun definitionOfCollection(){
    val mutableCollection: MutableSet<String> = HashSet()
    val personComparator:Comparator<Person>
}

// Page 30

/*fun longMethodName(
    argument: ArgType = "DefaultValue",
    argument2: AnotherArgType,
): Return Type {
    //Body
}
 */

// Page 31
fun foo(): Int{
    return 1 // bad
}
fun foo1() = 1 // Good

// Page 37

data class User (
    val id: Long,
    val username: String,
    val email: String
)

// Page 38

fun greet(
    name:String = "Guest",
    greeting:String = "Hello"
) {
    println("$greeting, $name!")
}

// Page 40
//Lazy çağrıldığında init edilir

// Extension functions: Mevcut olan bir sınıfın veya türün işlevselliğini genişletmek için kullanılır
//Page 46
fun String.toUpperCaseExtension():String{
    return this.uppercase()
}

// Singleton Usage Page 47

    object mySingleton{
        init {
            println("singleton class executed")
        }
        fun doSomething(){
            println("singleton processing")
        }
    }

// Page 48

abstract class Animal {
    abstract fun makeSound()
}
class Dog : Animal() {
    override fun makeSound() {
        println("Woof Woof")
    }
}

fun ifNotNullElseCheck(){
    val files = File("Test").listFiles()
    println(files?.size ?: "empty")

    val filesSize = files?.size ?: run {
        val someSize = getSomeSize()        // Page50
        someSize * 2
    }
    println(filesSize)
}
fun getSomeSize() : Int{
    return 0   // Page50
}
/*
fun exceptionShowing(){
    val values = ...
    val email = values["email"] ?: throw IllegalStateException("Email is missing")  // Page 51,52
    val mainValues = values.firstOrNull() ?: ""
}
 */

fun ifLet(){
    val defaultValue = "selcukileri"
    val value = ""
    val mapped = value.let { println(it) }      // Null check Page 54
}

fun transform(color: String): Int {
    return when(color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("invalid color param value")     // Page 55
    }
}

fun test(){
    val result = try {
        //count()
    } catch (e:ArithmeticException){
        throw IllegalStateException(e)      // Page 56
    }
}

fun ifVariable(){
    var x = 1
    val y = if (x == 1) {
        "One"
    } else if (x == 2){     // Page 58
        "two"
    } else {
        "other"
    }
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply {  fill(-1)}        // Page 59
}

class Turtle {
    fun penDown(){}
    fun penUp(){}
    fun turn(degrees: Double){}         // Page 61
    fun forward(pixels: Double){}
}
fun turtle(){
    val myTurtle = Turtle()
    with(myTurtle){
        penDown()
        for (i in 1..4){
            forward(100.0)      // Page 61
            turn(90.0)
        }
        penUp()
    }
}

fun properties(){
    val myRectangle4 = Rectangle(5.0,4.0).apply {
        //color = 0XFAFA        Page 62
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun kaynaklariDerleme(){
    val stream = Files.newInputStream(Paths.get("/some/file.txt"))
    stream.buffered().reader().use { reader ->
        println(reader.readText())          // Page 63
    }
}

inline fun <reified T>genericFunction(value: T){
    val typeName = T::class.simpleName
    println("The type of value is $typeName")       // Page 64
}

fun changingVariable(){
    var myVariable = "My Variable"
    myVariable = myVariable.also {
        println("The value of myVariable: $it")     // Page 65
        it.uppercase()
    }
}

class DefaultParameter {
    fun printMessageWithPrefix(message: String, prefix: String = "Info"){   // Page 67
        println("[$prefix] $message")

    }
    fun main2(){
        printMessageWithPrefix(message = "Hello")
        printMessageWithPrefix(prefix = "Log", message = "Hello")       // Page 67
    }
}

fun InfixFuns(){
    infix fun Int.shl(x: Int) : Int {
        return 0
    }
    1 shl 2
    1.shl(2)

    @SuppressLint("SuspiciousIndentation")
    infix fun Int.times(str: String) = str.repeat(this)     //Page68
        println(2 times "Bye")

}

fun operatorFuncs(){
    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much"
    println(str[0..14])
}

fun varArgParameters(){
    fun printAll(vararg messages: String){
        for (m in messages) println(m)                  // PAge 70
    }
    printAll("Hello","Hallo","Salut","Hola")
}

fun variables(){
    var a: String = "Initial"
    println(a)
    val b: Int = 1
    val c = 3
}

fun nullSafety(){
    var neverNull: String = "This cant be null"
    var nullable: String? = "You can keep a null here"

    var inferredNonNull = "The compiler assumes Non Null"
    fun strLength(notNull: String) : Int {              // Page 72
        return notNull.length
    }
    strLength(neverNull)
    strLength(nullable.toString())
}

fun nullSafety2(){
    fun describeString(maybeString: String?): String {
        if (maybeString != null && maybeString.isNotEmpty()) {
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null String"       //PAge 73
        }
    }
}

class Customer
class Contact(val id: Int, var email: String)
fun main3(){
    val customer = Customer()
    val contact = Contact(id = 1, email = "mary@gmail.com")     // PAge 74
    println(contact.id)
    contact.email = "jane@gmail.com"

}

class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()
    fun push(element: E) = elements.add(element)
    fun peek(): E = elements.last()
    fun pop() : E = elements.removeAt(elements.size - 1)            // Page 75
    fun isEmpty() = elements.isEmpty()
    fun size() = elements.size
    override fun toString() = "MutableStack(${elements.joinToString() }"
}

/*fun MutableStackOf<E>(vararg items: E) = MutableStack(*elemenet)
fun main4(){
    val stack = MutableStackOf(0.62,3.14,2.7)           Page 76
    println(stack)
}
 */
// PAge 77

open class Dog2 {
    open fun sayHello(){
        println("woof woof")
    }
    class Yorkshire: Dog2() {
        override fun sayHello() {           // PAge 77
            println("wif wif")

        }
    }
    fun main4(){
        val dog: Dog2 = Yorkshire()
        dog.sayHello()
    }
}

// Page 78

open class Lion(val name: String, val origin: String) {
    fun sayHello(){
        println("$name, the lion from $origin says: graoh!")
    }
}
class Asiatic(name:String): Lion(name = name, origin ="india")
fun main5(){
    val lion: Lion = Asiatic("rufo")
    lion.sayHello()
}

// Page 79

open class Hayvan(val isim: String, val yas: Int){
    open fun bilgileriGoster(){
        println("$isim isimli hayvan, $yas yaşında")
    }
}
class Kedi(isim:String,yas: Int,val tur: String) : Hayvan(isim,yas){
    override fun bilgileriGoster(){
        println("$isim isimli kedi, $yas yaşında ve türü $tur.")
    }
    fun miyavla(){
        println("$isim miyavladı!")
    }
}
fun main6(){
    val kedi = Kedi("whiskers",3, "Siyam")
    kedi.bilgileriGoster()
    kedi.miyavla()
}

//Page 80

fun main7(){
    cases("Hello")
}
fun cases(obj:Any){
    when(obj){
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}

// Page 81

fun whenAssign(obj: Any) : Any{
    val result = when(obj){
        1 -> "one"
        "Hello" -> 1
        is Long -> false
        else -> 42
    }
    return result
}

// Page 82

fun page82(){
    val cakes = listOf("carrot","cheese","chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
}

// Page 83

fun page83(){
    var cakesEaten = 0
    while (cakesEaten < 5){
        //eatACake()
        cakesEaten++
    }
}

// Page 84

fun doWhileLoop(){
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 5){
        //eatACake()
        cakesEaten++
    }
    do {
        //bakeACake
        cakesBaked++
    } while (cakesBaked < cakesEaten)
}

// Page 85

fun ranges(){
    for (i in 0..3){
        println(i)
    }
    println("")
    for (i in 0 until  3){
        println(i)
    }
    println("")

    for (i in 2..8 step 2){
        println(i)
    }
    println("")

    for (i in 3 downTo 0){
        println(i)
    }
    println("")
}

// Page 86
fun ranges2(){
    for (c in 'a'..'d'){
        println(c)
    }
    println("")
    for (c in 'z' downTo 's' step 2){
        println(c)
    }
    println("")
}

// Page 87
fun ranges3(){
    val x = 2
    if (x in 1..5){
        println("x is in range from 1 to 5")
    }
    println()
    if (x !in 6..10) {
        println("x is not in range from 6 to 10")
    }
}

// Page 88
fun equalityChecks() {
    val a: Int = 5
    val b: Int = 5
    val c: Int = 10
    println(a == b)
    println(a == c)

    val x: Int = 5
    val y: Int = 5
    val z: Int? = x

    println(x == y)
    println(x == z)
}

// Page 89

fun conditionalExpr(){
    fun max(a: Int, b: Int) = if (a>b) a else b
    println(max(99,-42))
}

// Page 91

data class Kitap(val ad: String, val yazar: String, val yayinYili: Int)
fun main8(){
    val kitap1 = Kitap("Kotlin Programming","Ahmet Yılmaz",2022)
    val kitap2 = Kitap("Kotlin Programming","Ahmet Yılmaz",2022)
    println("equals(): ${kitap1.equals(kitap2)}")
    println("hashCode() - Kitap1: ${kitap1.hashCode()}")
    println("hashCode() - Kitap2: ${kitap2.hashCode()}")

    val kopyaKitap = kitap1.copy(yayinYili = 2023)
    println("copy() - Kopya Kitap: $kopyaKitap")
}

// Page 92

data class Ogrenci2(val ad: String, val numara: Int, val sinif: Int){
    operator fun component4(): String{
        return ad
    }
    operator fun component5(): Int{
        return numara
    }
    operator fun component6(): Int{
        return sinif
    }
}

























