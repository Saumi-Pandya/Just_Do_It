package com.example.just_do_it.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.just_do_it.BuildConfig
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}