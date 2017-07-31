package ttt

class Game(val display: Display, val board: Board, val playerOne: Player, val playerTwo: Player, var displayBoard: DisplayBoard) {
    fun start() {
        display.welcome()
        play()
        displayBoard.show(board)
    }

    private fun play() {
        while(!board.isFull()) {
            displayBoard.show(board)
            display.promptForMove()
            val move = currentPlayer().move()
            board.placeMark(currentPlayer().mark, move)
        }
    }


    private fun currentPlayer(): Player {
        val availablePositions = board.availablePositions().count()
        if(availablePositions % 2 == 0) {
            return playerTwo
        } else {
            return playerOne
        }
    }
}

