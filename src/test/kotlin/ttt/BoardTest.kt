package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class BoardTest : StringSpec() {
    init {

        var board = Board()
        val fullGrid = listOf(Mark.X, Mark.X, Mark.X)
        val grid = listOf(Mark.X, Mark.X, Mark.EMPTY)

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
            val board = Board(fullGrid)

            board.isEmpty() shouldBe false
            board.isFull() shouldBe true
        }

        "it knows available positions" {
            val board = Board(grid)

            val availablePositions = board.availablePositions()

            availablePositions shouldBe listOf(2)
        }
    }
}