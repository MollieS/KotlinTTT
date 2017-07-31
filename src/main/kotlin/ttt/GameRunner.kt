package ttt


fun main(args: Array<String>) {
    var board = Board()
    var input = CLIInput()
    var playerOne = HumanPlayer(Mark.X, input)
    var playerTwo = HumanPlayer(Mark.O, input)
    var display = CLIDisplay()
    var displayBoard = CLIDisplayBoard(display)
    var game = Game(display, board, playerOne, playerTwo, displayBoard)
    game.start()
}

