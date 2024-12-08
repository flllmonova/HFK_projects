package org.example

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(gameChoice, userChoice)
}

fun getGameChoice(array: Array<String>): String = array.random()

fun getUserChoice(array: Array<String>): String {
    var userInput = ""

    do {
        println("Please enter one of the following: [${array.joinToString(", ")}]")
        userInput = readln().lowercase().replaceFirstChar { it.uppercase() }
        if (userInput !in array) println("Wrong!") else break
    } while (true)

    return userInput
}

fun printResult(gameChoice: String, userChoice: String) {
    val result = if (gameChoice == userChoice) "Tie!"
    else if (
        (userChoice == "Rock" && gameChoice == "Scissors")
        || (userChoice == "Paper" && gameChoice == "Rock")
        || (userChoice == "Scissors" && gameChoice == "Paper")
    ) "You win!"
    else "You lose!"
    println("You chose $userChoice. I chose $gameChoice. $result")
}