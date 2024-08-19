package com.yan.foia.logged

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.ShapeAppearanceModel
import com.yan.foia.R
import com.yan.foia.databinding.LoggedMainBinding
import java.lang.reflect.Type

class LoggedActivity : AppCompatActivity() {

    private var _binding: LoggedMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        _binding = LoggedMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.logged)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val navView: BottomNavigationView = binding.navbar

        navView.itemActiveIndicatorColor = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_selected), intArrayOf(-android.R.attr.state_selected)),
            intArrayOf(0x01000000, Color.TRANSPARENT))
        navView.itemActiveIndicatorWidth = (resources.displayMetrics.density * 100).toInt()
        navView.itemActiveIndicatorHeight = (resources.displayMetrics.density * 100).toInt()
        navView.itemRippleColor = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_selected), intArrayOf(-android.R.attr.state_selected), intArrayOf(android.R.attr.state_focused)),
            intArrayOf(com.google.android.material.R.attr.colorOnPrimary, Color.TRANSPARENT, Color.TRANSPARENT))
//        val navController = findNavController(binding.loggedNavHost.id)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.logged_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_camera
            )
        )

        setSupportActionBar(binding.especialdemais)
//        supportActionBar?.
        supportActionBar?.hide()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
}