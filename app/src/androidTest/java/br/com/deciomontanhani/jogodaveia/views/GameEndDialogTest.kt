package br.com.deciomontanhani.jogodaveia.views

import androidx.test.rule.ActivityTestRule
import br.com.deciomontanhani.jogodaveia.R
import br.com.deciomontanhani.jogodaveia.models.Player
import br.com.deciomontanhani.jogodaveia.views.game.GameActivity
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import org.junit.Rule
import org.junit.Test

class GameEndDialogTest {
    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> =
        ActivityTestRule(GameActivity::class.java)
    private fun givenGameEnded() {
        activityRule.activity.onGameWinnerChanged(Player("Décio", "x"))
    }
    @Test
    @Throws(Exception::class)
    fun display_winner_when_game_ends() {
        givenGameEnded()
        assertDisplayed(R.id.tvWinner)
    }

    @Test
    @Throws(Exception::class)
    fun display_begin_dialog_when_done_clicked() {
        givenGameEnded()
        clickDialogPositiveButton()
        assertNotExist(R.id.tvWinner)
        assertDisplayed(R.id.et_player1)
    }
}