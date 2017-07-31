package ttt

class DisplaySpy : Display {
    var welcomeWasCalled: Boolean = false
    var promptForMoveWasCalled: Boolean = false
    var calledWith: String = ""

    override fun promptForMove() {
        promptForMoveWasCalled = true
    }

    override fun welcome() {
        welcomeWasCalled = true
    }

    override fun show(toShow: String) {
        calledWith = toShow
    }
}