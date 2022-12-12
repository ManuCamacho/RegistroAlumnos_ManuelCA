package com.example.registroalumnos

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus :AppCompatActivity() {
    companion object{
        var actividadActual=0;
    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        if (menu != null) {
            for (i in 0 until menu.size()) {
                if (i == actividadActual) menu.getItem(i).isEnabled = false
                else menu.getItem(i).isEnabled = true
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.AddAlumno ->{
                val intent = Intent(this,anadir_alumno::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=0;
                startActivity(intent)
                true
            }
            R.id.UpdateAlumno ->{
                val intent = Intent(this,update_alumno::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=1;
                startActivity(intent)
                true
            }
            R.id.DeleteAlumno ->{
                val intent = Intent(this,delete_alumno::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                actividadActual=2;
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}