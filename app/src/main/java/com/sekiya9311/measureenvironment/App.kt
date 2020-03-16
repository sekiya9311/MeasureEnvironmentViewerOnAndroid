package com.sekiya9311.measureenvironment

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

open class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeFirebase()
    }

    private fun initializeFirebase() {
        FirebaseApp.initializeApp(this)

        FirebaseFirestore.setLoggingEnabled(true)
        val firestore = FirebaseFirestore.getInstance()
        val setting = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()
        setting.areTimestampsInSnapshotsEnabled()
        firestore.firestoreSettings = setting
    }
}
