package com.example.thirdTimeApp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.toastapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null){
            lifecycleScope.launch(IO) {
                SpHelper.init(applicationContext) { message ->
                    makeSnackbar(message)
                }
            }
        }

    }

    private fun makeSnackbar(message: String){
        Snackbar.make(binding.container, message, Snackbar.LENGTH_LONG).show()
    }
}