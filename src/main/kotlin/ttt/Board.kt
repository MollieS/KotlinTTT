package ttt

class Board(var grid: List<Mark> = emptyList<Mark>()) {
    var size = 9

    init {
        if (grid.isEmpty()) {
            this.grid = emptyGrid()
        }
    }

    fun emptyGrid() : List<Mark> {
        val list = mutableListOf<Mark>()
        while (list.size < size) {
            list.add(Mark.EMPTY)
        }
        return list
    }

    fun placeMark(mark: Mark, position: Int): Board {
        var newGrid: MutableList<Mark> = grid as MutableList<Mark>
        newGrid[position] = mark
        return Board(newGrid)
    }

    fun markAt(position: Int): Mark = grid.get(position)
    fun isFull(): Boolean = grid.none { it == Mark.EMPTY }
    fun isEmpty(): Boolean = grid.all { it == Mark.EMPTY }
    fun availablePositions(): List<Int> {
    }
}

enum class Mark {
    EMPTY,
    X,
    O
}
