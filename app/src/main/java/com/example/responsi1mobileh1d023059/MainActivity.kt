package com.example.responsi1mobileh1d023059

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023059.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutHistory.let{
            it.imgIcon.setImageResource(R.drawable.ic_history)
            it.tvLayout.setText(R.string.history)
        }
        binding.layoutCoach.let{
            it.imgIcon.setImageResource(R.drawable.ic_coach)
            it.tvLayout.setText(R.string.coach)
        }
        binding.layoutSquad.let{
            it.imgIcon.setImageResource(R.drawable.ic_himpunan)
            it.tvLayout.setText(R.string.squad)
        }
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.layoutCoach.root.setOnClickListener {
            val intent = Intent(this, CoachActivity::class.java)
            startActivity(intent)
        }

        binding.layoutSquad.root.setOnClickListener {
            val intent = Intent(this, SquadActivity::class.java)
            startActivity(intent)
        }
//        binding.layoutBook.root.setOnClickListener {
//            val intent = Intent(this, DaftarBukuActivity::class.java)
//            startActivity(intent)
//        }
    }
}
