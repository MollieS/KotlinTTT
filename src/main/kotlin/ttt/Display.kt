package ttt

interface Display {

    fun show(toShow: String)

    fun welcome(): Unit

    fun promptForMove(): Unit
}