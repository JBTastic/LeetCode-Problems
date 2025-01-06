class MyCalendarTwo() {

    // create a mutable list of bookings
    var bookings: MutableList<Triple<Int, Int, Int>> = mutableListOf()

    fun book(startTime: Int, endTime: Int): Boolean {

        // check for every new booking if it overlaps with an existing booking
        for ((start2, end2, doubleBooking) in bookings) {
            if (startTime < end2 && endTime > start2 && doubleBooking > 1) {
                return false
            } else if (startTime < end2 && endTime > start2 && doubleBooking == 0) {
                bookings.add(Triple(startTime, endTime, 1))
                bookings.remove(Triple(start2, end2, 0))
                bookings.add(Triple(start2, end2, 1))
                bookings.add(Triple(start2, endTime, 2))
                return true
            } else if (startTime < end2 && endTime > start2 && doubleBooking == 1) {
                
            }
        }
        
        // if not, add the new booking to the list and return true
        bookings.add(Triple(startTime, endTime, 0))
        return true
    }
}

fun main () {
    val obj = MyCalendarTwo()

    val testCase: List<List<Int>> = listOf(
        listOf(47,50), listOf(1,10), listOf(27,36), listOf(40,47),
        listOf(20,27), listOf(15,23), listOf(10,18), listOf(27,36),
        listOf(17,25), listOf(8,17), listOf(24,33), listOf(23,28),
        listOf(21,27), listOf(47,50), listOf(14,21), listOf(26,32),
        listOf(16,21), listOf(2,7), listOf(24,33), listOf(6,13),
        listOf(44,50), listOf(33,39), listOf(30,36), listOf(6,15),
        listOf(21,27), listOf(49,50), listOf(38,45), listOf(4,12),
        listOf(46,50), listOf(13,21)
    )

    val expected: List<Boolean> = listOf(
        true,true,true,true,true,true,true,true,false,false,false,false,
        false,true,false,false,false,true,false,false,false,false,false,
        false,false,true,false,false,false
    )
    
    for (i in testCase.indices) {
        val result = obj.book(testCase[i][0], testCase[i][1])
        require(result == expected[i]) { "Expected ${expected[i]}, but got $result for test case ${testCase[i]}, also bookings is ${obj.bookings}" }
        println("Test ${testCase[i]} passed")
    }
}

/*
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */