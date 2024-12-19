package com.example.kotlin_btk_10.view

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.kotlin_btk_10.R
import kotlin.Int

public class besinListeFragmentDirections private constructor() {
  private data class ActionBesinListeFragmentToBesinDetayFragment(
    public val besinid: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_besinListeFragment_to_besinDetayFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("besinid", this.besinid)
        return result
      }
  }

  public companion object {
    public fun actionBesinListeFragmentToBesinDetayFragment(besinid: Int): NavDirections =
        ActionBesinListeFragmentToBesinDetayFragment(besinid)
  }
}
