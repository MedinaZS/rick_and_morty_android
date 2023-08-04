package com.roshka.rickandmortyandroid.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.roshka.rickandmortyandroid.databinding.ItemCharacterBinding
import com.roshka.rickandmortyandroid.models.Character
import com.squareup.picasso.Picasso

class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun render(characterModel: Character) {
        binding.textName.text = characterModel.name
        binding.textStatus.text = characterModel.status
        binding.textSpecie.text = characterModel.species

        Picasso.get().load(characterModel.image).into(binding.imageCharacter)
    }
}