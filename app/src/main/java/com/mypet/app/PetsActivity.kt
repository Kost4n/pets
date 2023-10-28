package com.mypet.app

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mypet.app.databinding.ActivityPetsBinding

class PetsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetsBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navigView

        val navController = findNavController(R.id.nav_activity_pets)
        navView.setupWithNavController(navController)
    }
}