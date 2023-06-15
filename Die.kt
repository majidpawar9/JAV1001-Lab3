import kotlin.random.Random
import java.util.Scanner

enum class Color{
    RED, WHITE, BLACK
}

enum class Sides(val value:Int){
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), ELEVEN(11), TWELVE(12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(15), 
    SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINETEEN(19), TWENTY(20)
}

// Primary constructor is in the class signature
class Die(private val color: Color, private val numSides: Sides) {
    var sideUp: Int = 1
        private set

    // Called each time we initialize a new Die object.
    init {
        roll()
    }

    // Secondary constructors that call the primary constructor
    constructor(): this(Color.WHITE, Sides.SIX)
    constructor(numSides: Sides): this(Color.WHITE, numSides)

    fun roll() {
        sideUp = Random.nextInt(1, numSides.value + 1) 
    }

    override fun toString(): String {
        return "A ${color.name.lowercase()} die with ${numSides.value} faces and currently showing a $sideUp."
    }
}

fun game(){
    val sc = Scanner(System.`in`)
    print("""
        *****Menu*****
        Please select the game you would like to play:
        1. Check your lucky number between 1-20
        2. In how many rolls can you get 5 of a kind
        3. Look at the highest side on a die
        **************
        Enter the value: 
    """.trimIndent())

    val userSelection: Int = sc.nextInt()
    
    fun luckyNum(){
        val die = Die(Color.RED, Sides.TWENTY)
        println("Your lucky number is ${die.sideUp}")
    }

    when (userSelection) {
        1 -> {
            luckyNum()
        }
        2 -> {
            fiveAlike()
        }
    }
}