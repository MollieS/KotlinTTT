package ttt

class Game(val display: Display, val board: Board, val playerOne: Player, val playerTwo: Player) {
    fun start() {
        display.welcome()
        display.promptForMove()
        var move = playerOne.move()
        board.placeMark(playerOne.mark, move)
        move = playerTwo.move()
        board.placeMark(playerTwo.mark, move)
    }
}
