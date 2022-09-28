import java.util.*

fun main() {
    exercise1()
    exercise2()
    exercise3()
    exercise4()
    exercise5()
    exercise6()
    exercise7()
    exercise8()
}

fun exercise1() {
    val number1 = 2
    val number2 = 3
    println("$number1 + $number2 = ${number1 + number2}\n")
}

fun exercise2() {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    daysOfWeek.forEach {
        print("$it ")
    }
    println("\n")
    println("Days of week starting with 'T':")
    daysOfWeek.filter {
        it[0] == 'T'
    }.forEach {
        print("$it ")
    }
    println("\n")
    println("Days of week containing 'e':")
    daysOfWeek.filter {
        it.contains('e')
    }.forEach {
        print("$it ")
    }
    println("\n")
    println("Days of week with length of 6:")
    daysOfWeek.filter {
        it.length == 6
    }.forEach {
        print("$it ")
    }
    println("\n")
}

fun exercise3() {
    println((2..100).filter {
        isPrime(it)
    })
    println()
}

fun isPrime(value: Int): Boolean {
    if(value == 2) {
        return true
    }
    if(value % 2 == 0) {
        return false
    }
    for(i in 3..value / 2 step 2) {
        if(value % i == 0) {
            return false
        }
    }
    return true
}

fun exercise4() {
    val msg =
        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣶⣶⣾⣾⣾⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣾⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣽⣻⣷\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⠁⢀⢀⠀⠀⠀⠀⠀⢹⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠈\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣄⣸⠏⢀⠭⠯⡽⠀⢷⣶⣄⣸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠸\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⢻⡹⠀⠀⠀⠀⣃⣀⡀⠉⠙⣟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢠\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢷⠀⠀⣀⣧⣈⡁⠀⢘⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⠀⠀⠉⠉⠉⡱⢰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⢲⢰⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⢠⣳⣟⣒⣐⠀⠀⠀⢼⡌⣿⣷⡤⢤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣼⣷⠋⠙⣿⠀⡄⡇⢀⣴⠏⢀⣿⣿⣿⣦⣀⣌⣩⣷⣶⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣴⣾⣿⣿⣿⡆⠀⡇⠀⠁⡷⠟⠁⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣧⣤⢯⢭⣭⣦⣤⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡍⠀⣿⣛⣒⣿⣿⣿⣿⣿⣿⣿⡏⡉⢿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡂⠀⣖⡲⠾⠿⣿⣿⣿⣿⣿⣿⣿⣇⢸⡿⠋⢙⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠼⣾⠭⣭⣭⣿⣿⣿⣿⣿⣿⣿⣿⣿⢡⠀⢀⢿⣿⣅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣻⣛⣓⣒⣺⣿⣿⣿⣿⣿⣿⣿⣿⣎⢀⠀⣾⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⣿⠷⢿⡿⣽⣽⣿⣿⣿⣿⣿⣷⣄⠁⡈⠁⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣷⣶⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀\n" +
                "⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣇⣠"
    val encodedMessage = messageCoding(msg, ::encode)
    println("Decoded message:")
    println(messageCoding(encodedMessage, ::decode))
    println()
}

fun messageCoding(msg: String, func: (String) -> String): String {
    return func(msg)
}

fun encode(msg: String): String {
    return Base64.getEncoder().encodeToString(msg.toByteArray())
}

fun decode(msg: String): String {
    return String(Base64.getDecoder().decode(msg))
}

fun exercise5() {
    println(filterEvens((1..10).toList()))
    println()
}

fun filterEvens(list: List<Int>) = list.filter {
    it % 2 == 0
}

fun exercise6() {
    val intArray = (1..10).toList()
    println("The original array: $intArray")
    println("Doubled with map(): ${intArray.map { it * 2 }}")
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println("Days of week uppercase: ${daysOfWeek.map { it.uppercase() }}")
    println("First letter of the week days: ${daysOfWeek.map { it[0].lowercase() }}")
    println("Length of each day of the week: ${daysOfWeek.map { it.length }}")
    println("Average day length: ${daysOfWeek.map { it.length }.average()}\n")
}

fun exercise7() {
    val daysOfWeek = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    daysOfWeek.removeIf { it.contains('n') }
    println("Days of week without letter 'n': $daysOfWeek")
    daysOfWeek.withIndex().forEach{
        println("Item at ${it.index} is ${it.value}")
    }
    daysOfWeek.sort()
    println("Days of week sorted: $daysOfWeek\n")
}

fun exercise8() {
    val randomInts = IntArray(10) {
        Random().nextInt(101 - 0) + 0
    }.asList()
    println("Random array:")
    randomInts.forEach{
        println(it)
    }
    println("Sorted array: ${randomInts.sorted()}")
    println("Does the array contain an even number? ${randomInts.any { it % 2 == 0 }}")
    println("Does the array contain only even numbers? ${randomInts.all { it % 2 == 0 }}")
    var sum = 0.0
    randomInts.forEach { sum += it }
    println("Average of the numbers: ${sum / randomInts.size }")
    //I don't know if this is the way how it should've been solved, but I couldn't quite understand the requirement.

}