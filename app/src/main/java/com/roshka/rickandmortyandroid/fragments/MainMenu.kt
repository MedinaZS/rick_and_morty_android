package com.roshka.rickandmortyandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.roshka.rickandmortyandroid.databinding.FragmentMainMenuBinding

class MainMenu : Fragment() {


    private var _binding: FragmentMainMenuBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainMenuBinding.inflate(inflater, container, false)

        binding.buttonCharacters.setOnClickListener { navigateToCharacters() }

        return binding.root
    }

    private fun navigateToCharacters() {
        val direction = MainMenuDirections.actionMainMenuToCharactersFragment()
        findNavController().navigate(direction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}