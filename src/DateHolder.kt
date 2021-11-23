import java.util.*

object DateHolder {
    @JvmStatic
    fun printDifference(date: Date) {
       println("difference - " + (date.time - startDate.time))
    }

    lateinit var startDate: Date
    lateinit var endDate: Date
}