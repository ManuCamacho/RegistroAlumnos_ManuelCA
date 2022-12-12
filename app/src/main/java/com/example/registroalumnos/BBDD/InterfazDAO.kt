package com.example.registroalumnos.BBDD

import androidx.room.*

@Dao
interface InterfazDAO {
    @Insert
    fun addAlumno(taskEntity: InformacionAlumnos):Long

    @Update
    fun updateAlumno(taskEntity: InformacionAlumnos):Int

    @Delete
    fun deleteAlumno(taskEntity: InformacionAlumnos):Int

    @Query("SELECT * FROM Alumnos WHERE nombre like :nombre")
    fun obtenerAlumnoPorNombre(nombre:String):InformacionAlumnos
}