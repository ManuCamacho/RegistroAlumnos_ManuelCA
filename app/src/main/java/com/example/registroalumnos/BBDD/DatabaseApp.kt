package com.example.registroalumnos.BBDD

import android.app.Application
import androidx.room.Room

class DatabaseApp:Application() {
    companion object{
        lateinit var database: DBRegistroAlumnos
    }

    override fun onCreate() {
        super.onCreate()
        DatabaseApp.database = Room.databaseBuilder(this,DBRegistroAlumnos::class.java,"DBRegistroAlumnos").build()
    }
}