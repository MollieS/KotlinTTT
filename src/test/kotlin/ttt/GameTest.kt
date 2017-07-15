package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec


class GameTest : StringSpec() {

    var displaySpy = DisplaySpy()
    var playerOne = PlayerSpy(Mark.X, 1)
    var playerTwo = PlayerSpy(Mark.O, 2)
    var board = Board()
    var game = Game(displaySpy, board, playerOne, playerTwo)

    init {
        "it welcomes the players" {
            game.start()

            displaySpy.welcomeWasCalled shouldBe true
        }

        "prompts player one for a move" {
            game.start()

            displaySpy.promptForMoveWasCalled shouldBe true
        }

        "gets first player move" {
            game.start()

            playerOne.moveWasCalled shouldBe true
        }

        "plays move on board" {
            game.start()

            playerOne.moveWasCalled shouldBe true

            game.board.markAt(1) shouldBe Mark.X
        }

        "gets second player move" {
            game.start()

            playerTwo.moveWasCalled shouldBe true
        }

        "plays second player move on board" {
            game.start()

            playerOne.moveWasCalled shouldBe true

            game.board.markAt(2) shouldBe Mark.O
        }
    }
}

class DisplaySpy : Display {
    var welcomeWasCalled: Boolean = false
    var promptForMoveWasCalled: Boolean = false

    override fun promptForMove(): String {
        promptForMoveWasCalled = true
        return "prompt"
    }

    override fun welcome(): String {
        welcomeWasCalled = true
        return "welcome"
    }

    var calledWith: String = ""

    override fun show(toShow: String) {
        calledWith = toShow
    }

}

class PlayerSpy(override val mark: Mark, val move: Int) : Player {
    var moveWasCalled: Boolean = false

    override fun move(): Int {
        moveWasCalled = true
        return move;
    }

}