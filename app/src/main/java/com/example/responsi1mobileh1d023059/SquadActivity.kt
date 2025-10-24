package com.example.responsi1mobileh1d023059

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023059.adapter.PlayerAdapter
import com.example.responsi1mobileh1d023059.databinding.ActivitySquadBinding
import com.example.responsi1mobileh1d023059.dialog.PlayerDetailBottomSheet
import com.example.responsi1mobileh1d023059.network.RetrofitInstance
import kotlinx.coroutines.launch

class SquadActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivitySquadBinding
    private val API_TOKEN = "cd8b0d547b884f8598207f3d0238c50c"
    private val BAYERN_MUNICH_ID = 5
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupRecyclerView()
        loadSquadData()
    }
    
    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    
    private fun loadSquadData() {
        lifecycleScope.launch {
            val response = RetrofitInstance.api.getTeam(BAYERN_MUNICH_ID, API_TOKEN)
            val players = response.squad ?: emptyList()
            
            val adapter = PlayerAdapter(players) { player ->
                showPlayerDetail(player)
            }
            
            binding.recyclerView.adapter = adapter
        }
    }
    
    private fun showPlayerDetail(player: com.example.responsi1mobileh1d023059.model.Player) {
        val bottomSheet = PlayerDetailBottomSheet.newInstance(player)
        bottomSheet.show(supportFragmentManager, "PlayerDetailBottomSheet")
    }
}
