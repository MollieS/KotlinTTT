package ttt

class CLIDisplay : Display {
    override fun show(toShow: String) {
        print(toShow)
    }

    override fun welcome() {
        show("welcome to ttt")
    }

    override fun promptForMove() {
        show("please choose a move")
    }
}
