package com.example.registroalumnos

import android.os.Bundle
import android.widget.Toast
import com.example.registroalumnos.BBDD.DatabaseApp
import com.example.registroalumnos.BBDD.InformacionAlumnos
import com.example.registroalumnos.databinding.ActivityAddAlumnoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class anadir_alumno : ActivityWithMenus(){

    private lateinit var binding: ActivityAddAlumnoBinding
    lateinit var lista: MutableList<InformacionAlumnos>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAlumnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = ArrayList()
        binding.BTAnadir.setOnClickListener{

            if(binding.Enombre.text.toString().isEmpty() or binding.Eapellido.text.toString().isEmpty()or binding.Ecurso.text.toString().isEmpty()){

                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
            }

            else{

                CoroutineScope(Dispatchers.IO).launch {

                    var nombre_=binding.Enombre.text.toString()
                    var apellidos_= binding.Eapellido.text.toString()
                    var curso_= binding.Ecurso.text.toString()
                    var alumnado = InformacionAlumnos(nombre = nombre_, apellido = apellidos_, curso = curso_)
                    lista.add(alumnado)


                    DatabaseApp.database.interfazDAO().addAlumno(alumnado)
                    clearFocus()
                }
            }


        }

    }
    fun clearFocus(){
        binding.Enombre.setText("")
        binding.Eapellido.setText("")
        binding.Ecurso.setText("")
    }

}