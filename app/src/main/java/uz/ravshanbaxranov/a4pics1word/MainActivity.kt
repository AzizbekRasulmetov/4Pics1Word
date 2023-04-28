package uz.ravshanbaxranov.a4pics1word

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.MobileAds
import uz.ravshanbaxranov.a4pics1word.databinding.ActivityMainBinding
import uz.ravshanbaxranov.a4pics1word.repository.SharedPref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)

    }
}