package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class HumanPlayerTest : StringSpec() {
    init {

        val inputFake = InputFake("1")
        val humanPlayer = HumanPlayer(Mark.X, inputFake)

        "it has a mark" {
            humanPlayer.mark shouldBe Mark.X
        }

        "gets move from input" {
            humanPlayer.move()

            inputFake.isRead shouldBe true
        }

        "changes input to valid move" {
            var move = humanPlayer.move()

            move shouldBe 0
        }
    }
}

class InputFake(var input: String) : Input {

    var isRead = false

    override fun read(): String {
        isRead = true
        return input
    }

}