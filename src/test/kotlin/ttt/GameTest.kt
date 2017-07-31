package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class GameTest : StringSpec() {

    var displaySpy = DisplaySpy()
    var playerOne = PlayerSpy(Mark.X, 1)
    var playerTwo = PlayerSpy(Mark.O, 2)
    var board = Board()
    var displayBoard = DisplayBoardSpy()
    var game = Game(displaySpy, board, playerOne, playerTwo, displayBoard)

    init {
        "it welcomes the players" {
            game = buildGameWithBoard(listOf(Mark.X))

            game.start()

            displaySpy.welcomeWasCalled shouldBe true
        }

        "prompts player one for a move" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY))

            game.start()

            displaySpy.promptForMoveWasCalled shouldBe true
        }

        "gets first player move" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY, Mark.EMPTY))

            game.start()

            playerOne.moveWasCalled shouldBe true
        }

        "plays move on board" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY, Mark.EMPTY))

            game.start()

            game.board.markAt(1) shouldBe Mark.X
        }

        "gets second player move" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY, Mark.EMPTY))

            game.start()

            playerTwo.moveWasCalled shouldBe true
        }

        "plays second player move on board" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY, Mark.EMPTY))

            game.start()

            game.board.markAt(2) shouldBe Mark.O
        }

        "shows the board" {
            game = buildGameWithBoard(listOf(Mark.X, Mark.EMPTY, Mark.EMPTY))

            game.start()

            displayBoard.showWasCalled shouldBe true
        }
    }

    fun buildGameWithBoard(grid: List<Mark>): Game {
        board = Board(grid)
        return Game(displaySpy, board, playerOne, playerTwo, displayBoard)
    }
}

class DisplayBoardSpy: DisplayBoard {

    var showWasCalled: Boolean = false

    override fun show(board: Board) {
        showWasCalled = true
    }
}


class PlayerSpy(override val mark: Mark, val move: Int) : Player {
    var moveWasCalled: Boolean = false

    override fun move(): Int {
        moveWasCalled = true
        return move
    }
}