package com.openclassrooms.room.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.room.data.entity.Animal
import com.openclassrooms.room.databinding.ItemAnimalBinding

class AnimalsAdapter(private var animals: List<Animal>, private val listener: OnAnimalClickListener) :
  RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>()
{

  interface OnAnimalClickListener
  {

    fun onAnimalClick(animal: Animal)

  }

  inner class AnimalViewHolder(binding: ItemAnimalBinding) :
    RecyclerView.ViewHolder(binding.root)
  {

    private val id: TextView = binding.id

    private val type: TextView = binding.type

    private val race: TextView = binding.race

    fun bind(animal: Animal, listener: OnAnimalClickListener)
    {
      id.text = animal.id.toString()
      type.text = animal.type.name
      race.text = animal.race.name

      itemView.setOnClickListener {
        listener.onAnimalClick(animal)
      }
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder
  {
    val binding = ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return AnimalViewHolder(binding)
  }

  override fun onBindViewHolder(holder: AnimalViewHolder, position: Int)
  {
    holder.bind(animals[position], listener)
  }

  override fun getItemCount(): Int =
    animals.size

  fun update(animals: List<Animal>)
  {
    this.animals = animals
    notifyDataSetChanged()
  }

}
