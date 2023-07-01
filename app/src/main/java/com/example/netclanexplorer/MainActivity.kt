package com.example.netclanexplorer

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.ViewTreeObserver
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    var isMenuOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val tabLayout = findViewById<TabLayout>(R.id.tab)
        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        val refine  = findViewById<ImageView>(R.id.img_refine)
        val drawerOpenOrNot = findViewById<ImageView>(R.id.paragraph)

        refine.setOnClickListener {
            val i = Intent(this@MainActivity,Refine::class.java)
            startActivity(i)
            finish()
        }

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        drawerOpenOrNot.setOnClickListener {
            if (isMenuOpen){
                drawerLayout.close()
                isMenuOpen = false
            }else{
                drawerLayout.open()
                isMenuOpen = true
            }
        }


        navView.setNavigationItemSelectedListener {
            drawerLayout.close()
            when(it.itemId){

                R.id.editprofile -> Toast.makeText(applicationContext,"Clicked Edit Profile",Toast.LENGTH_SHORT).show()
                R.id.my_network -> Toast.makeText(applicationContext,"Clicked My Network",Toast.LENGTH_SHORT).show()
                R.id.switch_business -> Toast.makeText(applicationContext,"Clicked Switch Business",Toast.LENGTH_SHORT).show()
                R.id.merchant-> Toast.makeText(applicationContext,"Clicked Merchant",Toast.LENGTH_SHORT).show()
                R.id.dating -> Toast.makeText(applicationContext,"Clicked dating",Toast.LENGTH_SHORT).show()
                R.id.matrimony -> Toast.makeText(applicationContext,"Clicked Matrimony",Toast.LENGTH_SHORT).show()
                R.id.buy_sell_rent -> Toast.makeText(applicationContext,"Clicked Buy Sell Rent",Toast.LENGTH_SHORT).show()
                R.id.jobs -> Toast.makeText(applicationContext,"Clicked Jobs",Toast.LENGTH_SHORT).show()
                R.id.business_card -> Toast.makeText(applicationContext,"Clicked Business Card",Toast.LENGTH_SHORT).show()
                R.id.netclan_groups -> Toast.makeText(applicationContext,"Clicked Netclan Groups",Toast.LENGTH_SHORT).show()
                R.id.notes -> Toast.makeText(applicationContext,"Clicked Notes",Toast.LENGTH_SHORT).show()
                R.id.live_location -> Toast.makeText(applicationContext,"Clicked Live Location",Toast.LENGTH_SHORT).show()

            }
            true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {

            if(toggle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)
        }


        tabLayout.setupWithViewPager(viewPager)

        val vpAdapter = VPAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vpAdapter.addFragment(Personal_Fragment(), "Personal")
        vpAdapter.addFragment(Business_Fragment(), "Business")
        vpAdapter.addFragment(Merchant_Fragment(), "Merchant")

        viewPager.adapter = vpAdapter


        setSupportActionBar(toolbar)



    }
}