package com.example.registroalumnos.BBDD

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(InformacionAlumnos::class), version = 1)

abstract class DBRegistroAlumnos:RoomDatabase() {
    abstract fun interfazDAO():InterfazDAO
}