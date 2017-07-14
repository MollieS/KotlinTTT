package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class BoardTest : StringSpec() {
    init {

        var board = Board()

        "it knows its size" {
            board.size shouldBe 9
        }

        "it should be empty when initialized" {
            board.isEmpty() shouldBe true
        }

        "a mark can be placed" {
            board = board.placeMark(Mark.X, 0)

            board.isEmpty() shouldBe false
            board.markAt(0) shouldBe Mark.X
        }

        "it knows when it is full" {
            val grid = listOf<Mark>(Mark.X, Mark.X, Mark.X)
            val board = Board(grid)

            board.isEmpty() shouldBe false
            board.isFull() shouldBe true
        }

        "it knows available positions" {
            val grid = listOf<Mark>(Mark.X, Mark.X, Mark.EMPTY)
            val board = Board(grid)

            val availblePositions = board.availablePositions()

            availblePositions shouldBe listOf<Int>(2)
        }
    }
}