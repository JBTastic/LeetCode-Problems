class MyCalendarTwo() {

    // create a mutable list of bookings
    var bookings: MutableList<Triple<Int, Int, Int>> = mutableListOf()
    var counter: Int = 0

    fun book(startTime: Int, endTime: Int): Boolean {

        var counter = 0
        var tempBookings: MutableList<Triple<Int, Int, Int>> = mutableListOf()

        // go through every existing booking
        for ((start2, end2, doubleBooking) in bookings) {

            // check for every new booking if it overlaps with a double booking
            if (startTime < end2 && endTime > start2 && doubleBooking > 0) {
                return false
            }
        }

        // if it doesn't, check if it overlaps with a single booking
        for ((start2, end2, doubleBooking) in bookings) {
            if (startTime < end2 && endTime > start2) {
                tempBookings.add(Triple(startTime, endTime, 0))
                var realStart = maxOf(startTime, start2)
                var realEnd = minOf(endTime, end2)
                tempBookings.add(Triple(realStart, realEnd, 1))
                counter++
            }
        }

        // if it isn't overlapping at all, add the new booking to the list
        if (counter == 0) {
            bookings.add(Triple(startTime, endTime, 0))
        } else {
            bookings.addAll(tempBookings)
        }

        // either it only overlapped with a single booking or with no booking so return true
        return true
    }
}

fun main () {
    val obj = MyCalendarTwo()

    val testCase1 = listOf(
        listOf(47,50), listOf(1,10), listOf(27,36), listOf(40,47),
        listOf(20,27), listOf(15,23), listOf(10,18), listOf(27,36),
        listOf(17,25), listOf(8,17), listOf(24,33), listOf(23,28),
        listOf(21,27), listOf(47,50), listOf(14,21), listOf(26,32),
        listOf(16,21), listOf(2,7), listOf(24,33), listOf(6,13),
        listOf(44,50), listOf(33,39), listOf(30,36), listOf(6,15),
        listOf(21,27), listOf(49,50), listOf(38,45), listOf(4,12),
        listOf(46,50), listOf(13,21)
    )

    val expected1 = listOf(
        true,true,true,true,true,true,true,true,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false
    )
    
    for (i in testCase1.indices) {
        val result1 = obj.book(testCase1[i][0], testCase1[i][1])
        require(result1 == expected1[i]) { "Expected ${expected1[i]}, but got $result1 for test case ${testCase1[i]}, also bookings is ${obj.bookings}" }
        println("Test ${testCase1[i]} passed")
    }

    val obj2 = MyCalendarTwo()

    val testCase2 = listOf(
        listOf(10,20), listOf(50,60), listOf(10,40), listOf(5,15), listOf(5,10), listOf(25,55)
    )

    val expected2 = listOf(
        true,true,true,false,true,true
    )

    for (i in testCase2.indices) {
        val result2 = obj2.book(testCase2[i][0], testCase2[i][1])
        require(result2 == expected2[i]) { "Expected ${expected2[i]}, but got $result2 for test case ${testCase2[i]}, also bookings is ${obj2.bookings}" }
        println("Test ${testCase2[i]} passed")
    }

    val obj3 = MyCalendarTwo()

    val testCase3 = listOf(
        listOf(5, 12), listOf(42, 50), listOf(4, 9), listOf(33, 41), listOf(2, 7), listOf(16, 25), listOf(7, 16), listOf(6, 11), listOf(13, 18), listOf(38, 43), listOf(49, 50), listOf(6, 15), listOf(5, 13), listOf(35, 42), listOf(19, 24), listOf(46, 50), listOf(39, 44), listOf(28, 36), listOf(28, 37), listOf(20, 29), listOf(41, 49), listOf(11, 19), listOf(41, 46), listOf(28, 37), listOf(17, 23), listOf(22, 31), listOf(4, 10), listOf(31, 40), listOf(4, 12), listOf(19, 26)
    )

    val expected3 = listOf(
        true,true,true,true,false,true,false,false,true,true,true,false,false,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false
    )

    for (i in testCase3.indices) {
        val result3 = obj3.book(testCase3[i][0], testCase3[i][1])
        require(result3 == expected3[i]) { "Expected ${expected3[i]}, but got $result3 for test case ${testCase3[i]}, also bookings is ${obj3.bookings}" }
        println("Test ${testCase3[i]} passed")
    }
}