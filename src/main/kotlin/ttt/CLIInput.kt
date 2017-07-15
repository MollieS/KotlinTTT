package ttt


class CLIInput: Input {
    override fun read(): String {
        return readLine()!!
    }

}