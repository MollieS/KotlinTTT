package ttt

interface Display {

    fun show(toShow: String)

    fun welcome(): String

    fun promptForMove(): String
}