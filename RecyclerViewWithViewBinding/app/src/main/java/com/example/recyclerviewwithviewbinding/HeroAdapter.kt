package com.example.recyclerviewwithviewbinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithviewbinding.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter(val superhero:List<Superhero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int = superhero.size


    class HeroHolder(var view: View):RecyclerView.ViewHolder(view){

        private val binding = ItemSuperheroBinding.bind(view)

        fun render(superhero: Superhero){
            binding.tvRealName.text = superhero.realName
            binding.tvSuperHeroName.text = superhero.superHeroName
            binding.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.image).into( binding.ivHero)
            binding.tile.setOnClickListener {
                Toast.makeText(view.context, "Has seleccionado a ${superhero.superHeroName}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}