package ttt

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class HumanPlayerTest : StringSpec() {
    init {
        "it has a mark" {
            var humanPlayer = HumanPlayer(Mark.X)

            (humanPlayer.mark) shouldBe Mark.X
        }
    }
}