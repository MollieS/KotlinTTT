package ttt


class HumanPlayer(override val mark: Mark, val input: Input): Player{
    override fun move(): Int {
        return input.read().toInt() - 1
    }
}