package ttt

class CLIDisplayBoard(val display: Display): DisplayBoard {
    override fun show(board: Board) {
        display.show(
                "-------------\n" +
                        "| ${cell(0, board)} | ${cell(1, board)} | ${cell(2, board)} |\n" +
                        "-------------\n" +
                        "| ${cell(3, board)} | ${cell(4, board)} | ${cell(5, board)} |\n" +
                        "-------------\n" +
                        "| ${cell(6, board)} | ${cell(7, board)} | ${cell(8, board)} |\n" +
                        "-------------\n"
        )
    }

    private fun cell(position: Int, board: Board): String {
        val content = board.markAt(position)
        if(content == Mark.EMPTY) return " "
        return content.toString()
    }
}