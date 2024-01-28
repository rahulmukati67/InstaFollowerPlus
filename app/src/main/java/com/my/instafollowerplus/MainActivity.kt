package com.my.instafollowerplus

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.my.instafollowerplus.ads.MyApplication
import com.my.instafollowerplus.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adView: AdView
    private lateinit var adView3: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtLikes.setOnClickListener{
            val intent = Intent(this, Get::class.java)
            intent.putExtra("btnText" , "Get Free Likes")
            startActivity(intent)
        }
        binding.txtFollower.setOnClickListener{
            val intent = Intent(this, Get::class.java)
            intent.putExtra("btnText" , "Get Free Followers")
            startActivity(intent)
        }
        binding.txtView.setOnClickListener{
            val intent = Intent(this, Get::class.java)
            intent.putExtra("btnText" , "Get Free View")
            startActivity(intent)
        }
        binding.txtComment.setOnClickListener{
            val intent = Intent(this, Get::class.java)
            intent.putExtra("btnText" , "Get Free Comment")
            startActivity(intent)
        }

        MobileAds.initialize(this)
        adView = findViewById(R.id.adView)
        adView3 = findViewById(R.id.adView3)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView3.loadAd(adRequest)
    }
    override fun onStart() {
        super.onStart()
        val myApplication = application as? MyApplication
        myApplication?.triggerAdDisplay()
    }
    override fun onResume() {
        super.onResume()
        val myApplication = application as? MyApplication
        myApplication?.triggerAdDisplay()
    }
}
