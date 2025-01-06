class MyCalendarTwo() {

    // create a mutable list of bookings
    private val bookings: MutableList<Triple<Int, Int, Int>> = mutableListOf()

    fun book(startTime: Int, endTime: Int): Boolean {

        // check for every new booking if it overlaps with an existing booking
        for ((start2, end2, doubleBooking) in bookings) {
            if (startTime < end2 && endTime > start2 && doubleBooking > 0) {
                return false
            } else if (startTime < end2 && endTime > start2 && doubleBooking == 0) {
                bookings.add(Triple(startTime, endTime, 1))
                bookings.remove(Triple(start2, end2, 0))
                bookings.add(Triple(start2, end2, 1))
                return true
            }
        }
        
        // if not, add the new booking to the list and return true
        bookings.add(Triple(startTime, endTime, 0))
        return true
    }
}

fun main () {
    val obj = MyCalendarTwo()
    val testCase = [[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]

    val expected = [true,true,true,true,true,true,true,true,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false]
    
    for (i in testCase) {
        println(obj.book(i[0], i[1]))
    }

/*
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(startTime,endTime)
 */