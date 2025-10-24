package com.example.responsi1mobileh1d023059

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.responsi1mobileh1d023059.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d023059.network.RetrofitInstance
import kotlinx.coroutines.launch

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    
    // API Token dari football-data.org
    private val API_TOKEN = "cd8b0d547b884f8598207f3d0238c50c"
    private val BAYERN_MUNICH_ID = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        loadCoachData()
    }

    private fun loadCoachData() {
        lifecycleScope.launch {
            val response = RetrofitInstance.api.getTeam(BAYERN_MUNICH_ID, API_TOKEN)

            binding.tvCoachName.text = response.coach?.name
            binding.tvDateOfBirth.text = response.coach?.dateOfBirth
            binding.tvNationality.text = response.coach?.nationality
        }
    }
}