package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BBDD.DatabaseApp
import com.example.registroalumnos.BBDD.InformacionAlumnos
import com.example.registroalumnos.databinding.ActivityDeleteAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class delete_alumno : ActivityWithMenus() {

    private lateinit var bindingdelete: ActivityDeleteAlumnoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingdelete= ActivityDeleteAlumnoBinding.inflate(layoutInflater)
        setContentView(bindingdelete.root)
        bindingdelete.BTDelete.setOnClickListener(){

            if(bindingdelete.Eborrar.text.toString().isEmpty()    ){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var nombre_=bindingdelete.Eborrar.text.toString()

                    var deletealumno: InformacionAlumnos
                    deletealumno = DatabaseApp.database.interfazDAO().obtenerAlumnoPorNombre(nombre_)
                    deletealumno.nombre=nombre_

                    DatabaseApp.database.interfazDAO().deleteAlumno(deletealumno)

                    clearFocus()
                }
            }
        }
    }
    fun clearFocus(){
        bindingdelete.Eborrar.setText("")

    }
}