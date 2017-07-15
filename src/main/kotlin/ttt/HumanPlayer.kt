package ttt


class HumanPlayer(val mark: Mark, val input: Input){
    fun move(): String {
        return input.read()
    }
}