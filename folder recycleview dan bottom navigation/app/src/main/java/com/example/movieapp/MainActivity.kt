package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTEN_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val exploreFragment = ExploreFragment()
        val subscriptionFragment = SubscriptionFragment()
        val libraryFragment = LibraryFragment()
        val accountFragment = AccountFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_explore -> makeCurrentFragment(exploreFragment)
                R.id.menu_subscription -> makeCurrentFragment(subscriptionFragment)
                R.id.menu_library -> makeCurrentFragment(libraryFragment)
                R.id.menu_account -> makeCurrentFragment(accountFragment)
            }
            true
        }


    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.f1_fragment, fragment)
            commit()
        }
    }
}