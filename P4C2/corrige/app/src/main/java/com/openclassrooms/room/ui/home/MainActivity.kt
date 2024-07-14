package com.openclassrooms.room.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.room.R
import com.openclassrooms.room.data.entity.Animal
import com.openclassrooms.room.ui.vaccine.VaccineActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AnimalsAdapter.OnAnimalClickListener
{

  private val viewModel: HomeViewModel by viewModels()

  private val adapter = AnimalsAdapter(emptyList(), this@MainActivity)

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
      adapter = this@MainActivity.adapter
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

  override fun onAnimalClick(animal: Animal)
  {
    val intent = Intent(this, VaccineActivity::class.java).apply {
      putExtra(VaccineActivity.ANIMAL_ID, animal.id)
    }

    startActivity(intent)
  }

}