package com.roshka.rickandmortyandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roshka.rickandmortyandroid.R
import com.roshka.rickandmortyandroid.models.Character

class CharactersAdapter(val charactersList: List<Character>) :
    RecyclerView.Adapter<CharactersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharactersViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false))
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val item = charactersList[position]
        holder.render(item)
    }
}

