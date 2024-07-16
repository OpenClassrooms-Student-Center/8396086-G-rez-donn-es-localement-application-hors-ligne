package com.openclassrooms.room.ui.vaccine

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.room.data.entity.Vaccine
import com.openclassrooms.room.databinding.ItemVaccineBinding

class VaccineAdapter(private var vaccines: List<Vaccine>) :
  RecyclerView.Adapter<VaccineAdapter.VaccineViewHolder>()
{

  inner class VaccineViewHolder(binding: ItemVaccineBinding) :
    RecyclerView.ViewHolder(binding.root)
  {

    private val id: TextView = binding.id

    private val name: TextView = binding.name

    fun bind(vaccine: Vaccine)
    {
      id.text = vaccine.id.toString()
      name.text = vaccine.name
    }

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder
  {
    val binding = ItemVaccineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return VaccineViewHolder(binding)
  }

  override fun onBindViewHolder(holder: VaccineViewHolder, position: Int)
  {
    holder.bind(vaccines[position])
  }

  override fun getItemCount(): Int =
    vaccines.size

  fun update(vaccines: List<Vaccine>)
  {
    this.vaccines = vaccines
    notifyDataSetChanged()
  }

}
