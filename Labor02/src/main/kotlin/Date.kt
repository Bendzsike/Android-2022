import java.util.Calendar

fun Date.isLeapYear() = (this.year % 400 == 0) ||
                                ((this.year % 4 == 0) && (this.year % 100 != 0))

fun Date.isValid() =
    (this.month in 1..12) &&
    (
        (this.month == 2 && this.isLeapYear() && this.day in 1..29) ||
        (this.month == 2 && this.day in 1..28) ||
        (this.month in listOf(1, 3, 5, 7, 8, 10, 12) && this.day in 1..31) ||
        (this.month in listOf(4, 6, 9, 11) && this.day in 1..30)
    )

data class Date(
    val year: Int = Calendar.getInstance().get(Calendar.YEAR),
    val month: Int = (Calendar.getInstance().get(Calendar.MONTH) + 1),
    val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        return (this.year * 10000 + this.month * 100 + this.day) - (other.year * 10000 + other.month * 100 + other.day)
    }
}
