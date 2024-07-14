package com.openclassrooms.room.ui.vaccine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.room.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VaccineActivity : AppCompatActivity()
{

  companion object
  {

    const val ANIMAL_ID = "ANIMAL_ID"

  }

  private val viewModel: VaccineViewModel by viewModels()

  private val adapter = VaccineAdapter(emptyList())

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()

    setContentView(R.layout.activity_main)

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    findViewById<RecyclerView>(R.id.main).apply {
      adapter = this@VaccineActivity.adapter
      setHasFixedSize(true)
    }

    observeAnimals()

  }

  private fun observeAnimals()
  {
    lifecycleScope.launch {
      viewModel.animals.collect {
        adapter.update(it)
      }
    }
  }

}