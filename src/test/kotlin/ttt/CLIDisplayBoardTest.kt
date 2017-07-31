package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class CLIDisplayBoardTest : StringSpec() {
    val displaySpy = DisplaySpy();
    val displayBoard = CLIDisplayBoard(displaySpy)

    init {
        "shows an empty board" {
            val board = Board()

            displayBoard.show(board)

            displaySpy.calledWith shouldBe "-------------\n" +
                    "|   |   |   |\n" +
                    "-------------\n" +
                    "|   |   |   |\n" +
                    "-------------\n" +
                    "|   |   |   |\n" +
                    "-------------\n"
        }

        "shows a board with a mark" {
            val board = Board()
            board.placeMark(Mark.X, 1)

            displayBoard.show(board)

            displaySpy.calledWith shouldBe "-------------\n" +
                    "|   | X |   |\n" +
                    "-------------\n" +
                    "|   |   |   |\n" +
                    "-------------\n" +
                    "|   |   |   |\n" +
                    "-------------\n"
        }
    }
}
