package game

import java.util.Scanner

fun main() {
    userTest() // Test function
    // game() // A die game
}

// Test function
fun userTest() {
    // init
    val dieDefault = Die() // Default Constructor die
    val dieSides = Die(Sides.TWENTY) // Die with one paremeter constructor
    val dieColorSides = Die(Color.BLACK, Sides.TWELVE) // Die with two paremeter constructor
    println(dieDefault.toString())
    println(dieSides.toString())
    println(dieColorSides.toString())
    
    //Testing the roll method
    println("\nTesting the roll method")
    println(dieDefault.roll()) // Roll method
    println("The new value is: ${dieDefault.sideUp}")
    println(dieSides.roll())
    println("The new value is: ${dieSides.sideUp}")
    println(dieColorSides.roll())
    println("The new value is: ${dieColorSides.sideUp}\n")

    // Testing Setter function
    val dieSet = Die(Sides.TWENTY)
    dieSet.setSide(15) // Using setter to set the side to 15
    println("The side up now is ${dieSet.sideUp}\n")
    println("Creating 5 d6...")
    println("Yayy!! It took ${fiveAlike()} rolls to get five of a kind.")

}

// Function that returns the side which is currently up
fun luckyNum(): Int {
    val die = Die(Sides.TWENTY)
    return die.sideUp
}

// Functions that counts how much time it took to get five of a kind on five dices
fun fiveAlike(): Int {
    val die1 = Die()
    val die2 = Die()
    val die3 = Die()
    val die4 = Die()
    val die5 = Die()
    var count: Int = 1

    // To check if sideUp on all dice are same
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

// Function that returns what is the highest side on a die
fun highSide(): Int{
    val die = Die(Sides.TWENTY)
    return die.getHighestSide()
}

// A die game
fun game() {

    val sc = Scanner(System.`in`)

    // To display the user
    print(
            """
        *****Menu*****
        Please select the game you would like to play:
        1. Check your lucky number between 1-20
        2. In how many rolls can you get 5 of a kind. Can you even get it? :)
        3. Look at the highest side on a die
        **************
        Enter the value: 
    """.trimIndent()
    )

    val userSelection: Int = sc.nextInt() // User input
    
    // User input selection
    when (userSelection) {
        1 -> {
            println("Your lucky num is ${luckyNum()}")
        }
        2 -> {
            println("Yayy!! It took ${fiveAlike()} rolls to get five of a kind.")
        }
        3 -> {
            println("The highest side is ${highSide()}")
        }
        else -> {
            println("Please select a Valid Option!!")
        }
    }
}

