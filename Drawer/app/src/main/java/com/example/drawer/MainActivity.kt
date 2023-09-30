package com.example.drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)

        toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open,
            R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nav_view: NavigationView = findViewById(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.home->{
                    replaceFragment(HomeFragment(), it.title.toString())
                }
                R.id.settings->{
                    replaceFragment(SettingsFragment(), it.title.toString())
                }
                R.id.profile->{
                    replaceFragment(ProfileFragment(), it.title.toString())
                }
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment, title:String){
        var fragementManager = supportFragmentManager
        var fragementTrans = fragementManager.beginTransaction()
        fragementTrans.replace(R.id.frameLayout, fragment)
        fragementTrans.commit()
        setTitle(title)
        drawerLayout.close()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}