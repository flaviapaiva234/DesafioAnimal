package com.example.desafiofinalanimals.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.desafiofinalanimals.R
import com.example.desafiofinalanimals.databinding.ActivityMainBinding
import com.example.desafiofinalanimals.databinding.LayoutImagensRecyclerViewBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startBottomNavigation()
    }

    private fun startBottomNavigation(){
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainterView) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigationContainer, navController)
    }
}