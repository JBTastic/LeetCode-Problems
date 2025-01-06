class MyCalendar() {

    // create a mutable list of bookings
    private val bookings: MutableList<Pair<Int, Int>> = mutableListOf()

    fun book(startTime: Int, endTime: Int): Boolean {

        // check for every new booking if it overlaps with an existing booking
        for ((start2, end2) in bookings) {
            if (startTime < end2 && endTime > start2) {return false}
        }
        
        // if not, add the new booking to the list and return true
        bookings.add(Pair(startTime, endTime))
        return true
    }

}

fun main () {
    val obj = MyCalendar()
    println(obj.book(10, 20)) // true
    println(obj.book(15, 25)) // false
    println(obj.book(20, 30)) // true
}

/*
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */