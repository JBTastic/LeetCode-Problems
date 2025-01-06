class MyCalendar() {

    // create a mutable list of bookings
    private val bookings: MutableList<Triple<Int, Int, Int>> = mutableListOf()

    fun book(startTime: Int, endTime: Int): Boolean {

        // check for every new booking if it overlaps with an existing booking
        for ((start2, end2, doubleBooking) in bookings) {
            if (startTime < end2 && endTime > start2 && doubleBooking > 0) {
                return false
            } else if (startTime < end2 && endTime > start2 && doubleBooking == 0) {
                bookings.add(Triple(start2, end2, 1))
            }
        }
        
        // if not, add the new booking to the list and return true
        bookings.add(Triple(startTime, endTime, 0))
        return true
    }

}

fun main () {
    val obj = MyCalendar()
    println(obj.book(10, 20)) // true
    println(obj.book(50,60)) // true
    println(obj.book(10,40)) // true
    println(obj.book(5,15)) // false
    println(obj.book(5,10)) // true
    println(obj.book(25,55)) // true
}

/*
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */