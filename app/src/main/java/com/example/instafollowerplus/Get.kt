package com.example.instafollowerplus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.instafollowerplus.ads.MyApplication
import com.example.instafollowerplus.databinding.ActivityGetBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class Get : AppCompatActivity() {
    private lateinit var adView: AdView
    private lateinit var binding: ActivityGetBinding
    private lateinit var adView2: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)
        adView = findViewById(R.id.adView1)
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        binding.adView2.loadAd(adRequest)

        var btntxt = intent.getStringExtra("btnText")
        binding.btn.setText(btntxt)
    }
    fun showThankYouDialog(view: View) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Congratulations ✨🎉, Wait For 30 min For Result" +
                    "Long Queue😥😥 ")
                .setTitle("Thanks For Using The Service")
                .setPositiveButton("OK") { dialog, id ->
                    val myApplication = application as? MyApplication
                    myApplication?.triggerAdDisplay()
                    dialog.dismiss()
                }
            val dialog = builder.create()
            dialog.show()
    }
}
