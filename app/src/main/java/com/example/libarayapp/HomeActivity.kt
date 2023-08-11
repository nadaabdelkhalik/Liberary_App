package com.example.libarayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNavigationView:BottomNavigationView=findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {

                    openFragment(HomeFragment())
                    true
                }
                R.id.navigation_search -> {

                    openFragment(SearchFragment())
                    true
                }
                R.id.navigation_favourite -> {
                    // Handle Notifications section selection
                    openFragment(FavouriteFragment())
                    true
                }
                R.id.navigation_profile -> {
                    // Handle Notifications section selection
                    openFragment(SpaceFragment())
                    true
                }
                else -> false
            }
        }


        bottomNavigationView.menu.findItem(R.id.navigation_home).isChecked = true
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
















}





