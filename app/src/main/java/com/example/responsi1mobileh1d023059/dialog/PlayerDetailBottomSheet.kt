package com.example.responsi1mobileh1d023059.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d023059.databinding.FragmentPlayerDetailBinding
import com.example.responsi1mobileh1d023059.model.Player
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailBottomSheet : BottomSheetDialogFragment() {
    
    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!
    
    companion object {
        private const val ARG_PLAYER_NAME = "player_name"
        private const val ARG_PLAYER_DOB = "player_dob"
        private const val ARG_PLAYER_NATIONALITY = "player_nationality"
        private const val ARG_PLAYER_POSITION = "player_position"
        
        fun newInstance(player: Player): PlayerDetailBottomSheet {
            return PlayerDetailBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PLAYER_NAME, player.name)
                    putString(ARG_PLAYER_DOB, player.dateOfBirth)
                    putString(ARG_PLAYER_NATIONALITY, player.nationality)
                    putString(ARG_PLAYER_POSITION, player.position)
                }
            }
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        arguments?.let {
            binding.tvDetailName.text = it.getString(ARG_PLAYER_NAME) ?: "Unknown"
            binding.tvDetailDateOfBirth.text = it.getString(ARG_PLAYER_DOB) ?: "N/A"
            binding.tvDetailNationality.text = it.getString(ARG_PLAYER_NATIONALITY) ?: "N/A"
            binding.tvDetailPosition.text = it.getString(ARG_PLAYER_POSITION) ?: "N/A"
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
