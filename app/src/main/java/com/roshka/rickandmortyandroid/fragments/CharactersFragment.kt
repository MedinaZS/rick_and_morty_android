package com.roshka.rickandmortyandroid.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.roshka.rickandmortyandroid.Api
import com.roshka.rickandmortyandroid.adapter.CharactersAdapter
import com.roshka.rickandmortyandroid.databinding.FragmentCharactersBinding
import com.roshka.rickandmortyandroid.models.Character
import com.roshka.rickandmortyandroid.models.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharactersFragment : Fragment(), OnQueryTextListener {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CharactersAdapter
    private var charactersList = mutableListOf<Character>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        getCharacters()
        initRecyclerView()

        (activity as AppCompatActivity?)!!.supportActionBar?.title = "Rick and Morty"


        return binding.root
    }

    private fun getCharacters() {
        val response = Api.retrofitService.getAllCharacters()

        response.enqueue(object : Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.body() != null) {
                    //Mostrar recycler view
                    val results: List<Character> = response.body()?.results ?: emptyList()
                    charactersList.clear()
                    charactersList.addAll(results)
                    println("Hay datos")
                    println(charactersList[0].name)
                    //Avisar al adapter que ha habido cambios
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                println("Error characters response $t")
            }

        })
    }

    private fun initRecyclerView() {
        adapter = CharactersAdapter(charactersList)
        binding.recyclerCharacters.layoutManager = LinearLayoutManager(context)
        binding.recyclerCharacters.adapter = adapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}