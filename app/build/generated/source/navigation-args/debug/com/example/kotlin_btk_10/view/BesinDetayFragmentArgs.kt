package com.example.kotlin_btk_10.view

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class BesinDetayFragmentArgs(
  public val besinid: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("besinid", this.besinid)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("besinid", this.besinid)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): BesinDetayFragmentArgs {
      bundle.setClassLoader(BesinDetayFragmentArgs::class.java.classLoader)
      val __besinid : Int
      if (bundle.containsKey("besinid")) {
        __besinid = bundle.getInt("besinid")
      } else {
        throw IllegalArgumentException("Required argument \"besinid\" is missing and does not have an android:defaultValue")
      }
      return BesinDetayFragmentArgs(__besinid)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): BesinDetayFragmentArgs {
      val __besinid : Int?
      if (savedStateHandle.contains("besinid")) {
        __besinid = savedStateHandle["besinid"]
        if (__besinid == null) {
          throw IllegalArgumentException("Argument \"besinid\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"besinid\" is missing and does not have an android:defaultValue")
      }
      return BesinDetayFragmentArgs(__besinid)
    }
  }
}
