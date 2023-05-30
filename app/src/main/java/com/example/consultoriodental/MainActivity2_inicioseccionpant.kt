package com.example.consultoriodental
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.consultoriodental.databinding.ActivityMainActivity2InicioseccionpantBinding

class MainActivity2_inicioseccionpant : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainActivity2InicioseccionpantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainActivity2InicioseccionpantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMainActivity2Inicioseccionpant.toolbar)

        binding.appBarMainActivity2Inicioseccionpant.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController =
            findNavController(R.id.nav_host_fragment_content_main_activity2_inicioseccionpant)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val btnLink = findViewById<Button>(R.id.btnLinkss)
        btnLink.setOnClickListener {
            val url = "https://maps.app.goo.gl/k2mPrMiytPiWDhjQA" // URL del enlace
            val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(openUrlIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_activity2_inicioseccionpant, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(R.id.nav_host_fragment_content_main_activity2_inicioseccionpant)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

}

