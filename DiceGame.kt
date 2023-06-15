package game

import java.util.Scanner

fun main() {
    val dieDefault = Die() // Default Constructor die
    val dieSides = Die(Sides.TWENTY) // Die with one paremeter constructor
    val dieColorSides = Die(Color.BLACK, Sides.TWELVE) // Die with two paremeter constructor
    println(dieDefault.toString())
    println(dieSides.toString())
    println(dieColorSides.toString())

    println("Testing the roll method")
    dieDefault.roll()
    println("The new value is: ${dieDefault.sideUp}")
    dieSides.roll()
    println("The new value is: ${dieDefault.sideUp}")
    dieColorSides.roll()
    println("The new value is: ${dieDefault.sideUp}")
}

fun game() {
    val sc = Scanner(System.`in`)
    print(
            """
        *****Menu*****
        Please select the game you would like to play:
        1. Check your lucky number between 1-20
        2. In how many rolls can you get 5 of a kind
        3. Look at the highest side on a die
        **************
        Enter the value: 
    """.trimIndent()
    )

    val userSelection: Int = sc.nextInt()

    fun luckyNum(): Int {
        val die = Die(Sides.TWENTY)
        return die.sideUp
    }
    fun highestSide(): Int {
        val die = Die(Sides.TWENTY)
        return die.
    }

    fun fiveAlike(): Int {
        val die1 = Die()
        val die2 = Die()
        val die3 = Die()
        val die4 = Die()
        val die5 = Die()
        var count: Int = 1

        while (((die1.sideUp == die2.sideUp) &&
                (die1.sideUp == die3.sideUp) &&
                (die1.sideUp == die4.sideUp) &&
                (die1.sideUp == die5.sideUp) &&
                (die2.sideUp == die3.sideUp) &&
                (die2.sideUp == die4.sideUp) &&
                (die2.sideUp == die5.sideUp) &&
                (die3.sideUp == die4.sideUp) &&
                (die3.sideUp == die5.sideUp) &&
                (die4.sideUp == die5.sideUp)) == false) {
            count += 1
            die1.roll()
            die2.roll()
            die3.roll()
            die4.roll()
            die5.roll()
        }
        return count
    }
}
