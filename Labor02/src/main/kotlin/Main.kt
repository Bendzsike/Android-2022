import kotlin.random.Random

fun main() {
//    println("Exercise 01")
//    exercise01()
//    println("\n")
    println("Exercise 02")
    exercise02()
    println("\n")
    println("Exercise 03")
    exercise03()
    println("\n")

}

fun exercise01() {
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}

fun String.monogram() = this.split(" ", "-").map { it.first() }.joinToString("")

fun List<String>.join(separator: Char) = this.joinToString("$separator")

fun List<String>.longest() = this.maxBy { it.length }

fun exercise02() {
    val name = "Kovacs Csaba-Levente Lehel-Levente"
    println("My monogram is ${name.monogram()}")
    val list = mutableListOf("apple", "pear", "watermelon", "cherry")
    println("Joined list: ${list.join('#')}")
    println("Longest string in list: ${list.longest()}")
}

fun exercise03() {
    val currentDate = Date()
    println("Current date: $currentDate")

    val randomDates = mutableListOf<Date>()
    println("Invalid dates generated:")
    while(randomDates.size <= 10) {
        val newDate = Date(Random.nextInt(4000), Random.nextInt(50), Random.nextInt(50))
        if(newDate.isValid()) {
            randomDates.add(newDate)
        } else {
            println(newDate)
        }
    }
    println("\nValid dates stored:")
    randomDates.forEach { println(it) }

    randomDates.sort()
    println("\nSorted dates:")
    randomDates.forEach { println(it) }

    randomDates.reverse()
    println("\nReversed dates:")
    randomDates.forEach { println(it) }

    randomDates.sortWith(myCustomComparator())
    println("\nCustom sorted dates:")
    randomDates.forEach { println(it) }
}

fun myCustomComparator() = Comparator<Date> { first, second ->
    (first.year * 10000 + second.month * 100 + first.day) - (second.year * 10000 + first.month * 100 + second.day)
}