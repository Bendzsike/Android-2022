import java.util.*

fun main(args: Array<String>) {
    exercise1()
    exercise2()
    exercise3()
    exercise4()
    exercise5()
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
}

fun filterEvens(list: List<Int>) = list.filter {
    it % 2 == 0
}