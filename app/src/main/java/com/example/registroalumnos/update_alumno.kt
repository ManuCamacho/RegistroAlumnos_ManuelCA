package com.example.registroalumnos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BBDD.DatabaseApp
import com.example.registroalumnos.BBDD.InformacionAlumnos
import com.example.registroalumnos.databinding.ActivityUpdateAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class update_alumno : ActivityWithMenus() {

    private lateinit var bindingUpdate: ActivityUpdateAlumnoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUpdate= ActivityUpdateAlumnoBinding.inflate(layoutInflater)
        setContentView(bindingUpdate.root)
        bindingUpdate.BTUpdate.setOnClickListener {

            if(bindingUpdate.Enombre.text.toString().isEmpty()  or bindingUpdate.Ecurso.text.toString().isEmpty()){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }
            else{
                CoroutineScope(Dispatchers.IO).launch {
                    var nombre_=bindingUpdate.Enombre.text.toString()
                    var curso_=bindingUpdate.Ecurso.text.toString()

                    var updatealumno: InformacionAlumnos
                    updatealumno = DatabaseApp.database.interfazDAO().obtenerAlumnoPorNombre(nombre_)
                    updatealumno.curso=curso_

                    DatabaseApp.database.interfazDAO().updateAlumno(updatealumno)

                    clearFocus()

                }
            }
        }
    }

    fun clearFocus(){
        bindingUpdate.Enombre.setText("")
        bindingUpdate.Ecurso.setText("")

    }

}