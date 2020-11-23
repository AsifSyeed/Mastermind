package mastermind


data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val temp = temp.toCharArray()
    val test = test.toCharArray()
    val rightPosition = 'R'
    val wrongPosition = 'W'

    temp.forEachIndexed { i, c ->
        if (test[i] == c) {
            temp[i] = rightPosition
            test[i] = rightPosition
        }
    }

    temp.forEachIndexed { i, c ->
        if (c != 'R' && test.contains(c)) {
            temp[i] = wrongPosition
            test[test.indexOf(c)] = wrongPosition
        }
    }

    return Evaluation(temp.count { it == rightPosition },
            temp.count { it == wrongPosition })
}