package com.bestamibakir.orneksinif

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bestamibakir.orneksinif.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var ornekSinifListesi : ArrayList<OrnekSinif>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ornekSinif1 = OrnekSinif("isim1", R.drawable.gorsel1)
        val ornekSinif2 = OrnekSinif("isim2", R.drawable.gorsel2)

        ornekSinifListesi = arrayListOf(ornekSinif1,ornekSinif2)

        val adapter = OrnekSinifAdapter(ornekSinifListesi)
        binding.ornekRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.ornekRecyclerView.adapter = adapter
    }
}