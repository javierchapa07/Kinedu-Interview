package com.chapa.kinedu.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chapa.kinedu.R
import com.chapa.kinedu.databinding.ActivitySplashBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Picasso.get().load(R.drawable.logo).into(viewBinding.logo, object : Callback {
            override fun onSuccess() {
                viewBinding.logo.alpha = 0f
                viewBinding.logo.animate().setDuration(3000).alpha(1f).start()
            }

            override fun onError(e: Exception?) { Timber.e(e) }
        })

        GlobalScope.launch {
            delay(3000)
            finish()
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }

        Timber.i("Termina de iniciar splash activity")
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}