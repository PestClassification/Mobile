package com.yan.foia.ui.unlogged

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yan.foia.R
import com.yan.foia.ui.unlogged.fragments.welcome.WelcomeFragment

class UnloggedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.unlogged_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.unlogged)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.unlogged_fragment_container, WelcomeFragment(), null)
            .addToBackStack(null)
            .commit()
    }
}