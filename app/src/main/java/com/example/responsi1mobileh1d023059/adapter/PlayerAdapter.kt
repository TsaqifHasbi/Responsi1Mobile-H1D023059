package com.example.responsi1mobileh1d023059.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023059.R
import com.example.responsi1mobileh1d023059.databinding.ItemPlayerBinding
import com.example.responsi1mobileh1d023059.model.Player

class PlayerAdapter(
    private val players: List<Player>,
    private val onItemClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name ?: "Unknown"
            binding.tvNationality.text = player.nationality ?: "N/A"
            binding.tvPosition.text = player.position ?: "N/A"

            val position = player.position?.uppercase() ?: ""

            val cardColorRes = when {
                position.contains("GOALKEEPER") || position == "GK" -> R.color.GK

                position.contains("DEFENCE") || 
                position.contains("BACK") ||
                position == "CB" || position == "LB" || position == "RB" ||
                position.contains("CENTRE-BACK") ||
                position.contains("LEFT-BACK") ||
                position.contains("RIGHT-BACK") ||
                position.contains("DEFENDER") -> R.color.DEFENCES

                position.contains("MIDFIELD") ||
                position == "CM" || position == "CDM" || position == "CAM" ||
                position == "LM" || position == "RM" ||
                position.contains("CENTRAL MIDFIELD") ||
                position.contains("DEFENSIVE MIDFIELD") ||
                position.contains("ATTACKING MIDFIELD") ||
                position.contains("LEFT MIDFIELD") ||
                position.contains("RIGHT MIDFIELD") ||
                position.contains("MIDFIELDER") -> R.color.MIDFIELD
                
                position.contains("OFFENCE") ||
                position.contains("FORWARD") ||
                position.contains("STRIKER") ||
                position.contains("WINGER") ||
                position == "ST" || position == "CF" || position == "LW" || position == "RW" ||
                position.contains("CENTRE-FORWARD") ||
                position.contains("LEFT WINGER") ||
                position.contains("RIGHT WINGER") ||
                position.contains("ATTACKER") -> R.color.OFFENSE
                
                else -> R.color.black
            }
            
            val cardColor = ContextCompat.getColor(binding.root.context, cardColorRes)
            binding.cardView.setCardBackgroundColor(cardColor)

            binding.root.setOnClickListener {
                onItemClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount() = players.size
}

