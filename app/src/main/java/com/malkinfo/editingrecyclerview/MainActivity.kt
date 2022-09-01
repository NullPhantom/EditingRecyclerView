package com.malkinfo.editingrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.malkinfo.editingrecyclerview.model.UserData
import com.malkinfo.editingrecyclerview.view.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var addsBtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter:UserAdapter

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set List*/
        userList = ArrayList()

        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        /**set Adapter*/
        userAdapter = UserAdapter(this,userList)
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        userList.add(UserData("Estado: Aguascalientes","ID: 1"))
        userList.add(UserData("Estado: Baja California","ID: 2"))
        userList.add(UserData("Estado: Baja California Sur","ID: 3"))
        userList.add(UserData("Estado: Campeche","ID: 4"))
        userList.add(UserData("Estado: Chiapas","ID: 5"))
        userList.add(UserData("Estado: Chihuahua","ID: 6"))
        userList.add(UserData("Estado: Ciudad de México","ID: 7"))
        userList.add(UserData("Estado: Choahuila","ID: 8"))
        userList.add(UserData("Estado: Colima","ID: 9"))
        userList.add(UserData("Estado: Durango","ID: 10"))
        userList.add(UserData("Estado: Estado de México","ID: 11"))
        userList.add(UserData("Estado: Guanajuato","ID: 12"))
        userList.add(UserData("Estado: Guerrero","ID: 13"))
        userList.add(UserData("Estado: Hidalgo","ID: 14"))
        userList.add(UserData("Estado: Jalisco","ID: 15"))
        userList.add(UserData("Estado: Michoacán","ID: 16"))
        userList.add(UserData("Estado: Morelos","ID: 17"))
        userList.add(UserData("Estado: Nayarit","ID: 18"))
        userList.add(UserData("Estado: Nuevo León","ID: 19"))
        userList.add(UserData("Estado: Oaxaca","ID: 20"))
        userList.add(UserData("Estado: Puebla","ID: 21"))
        userList.add(UserData("Estado: Querétaro","ID: 22"))
        userList.add(UserData("Estado: Quintana Roo","ID: 23"))
        userList.add(UserData("Estado: San Luis Potosí","ID: 24"))
        userList.add(UserData("Estado: Sinaloa","ID: 25"))
        userList.add(UserData("Estado: Sonora","ID: 26"))
        userList.add(UserData("Estado: Tabasco","ID: 27"))
        userList.add(UserData("Estado: Tamaulipas","ID: 28"))
        userList.add(UserData("Estado: Tlaxcala","ID: 29"))
        userList.add(UserData("Estado: Veracruz","ID: 30"))
        userList.add(UserData("Estado: Yucatan","ID: 31"))
        userList.add(UserData("Estado: Zacatecas","ID: 32"))
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)
        /**set view*/
        val userName = v.findViewById<EditText>(R.id.userName)
        val userNo = v.findViewById<EditText>(R.id.userNo)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Añadir"){
            dialog,_->
            val names = userName.text.toString()
            val number = userNo.text.toString()
            userList.add(UserData("Estado: $names","ID: $number"))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Se añadio la información del estado.",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancelar"){
            dialog,_->
            dialog.dismiss()
        }
        addDialog.create()
        addDialog.show()
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.eItem -> {
            // User chose the "Settings" item, show the app settings UI...
            /*userList.removeAll(userList)
            userAdapter.notifyDataSetChanged()
            true*/

            val addDialog = AlertDialog.Builder(this)

           if (userList.isNotEmpty()) {
                AlertDialog.Builder(this)
                addDialog.setTitle("Eliminar toda la lista")
                addDialog.setIcon(R.drawable.ic_warning)
                addDialog.setMessage("¿Estas seguro que deseas eliminar la lista?")

                addDialog.setPositiveButton("Si") { dialog, _ ->

                    userList.removeAll(userList.toSet())
                    userAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "Se elimino la lista.", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                addDialog.setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }
                addDialog.create()
                addDialog.show()
            }else{
                Toast.makeText(this,"Lista vacia.",Toast.LENGTH_SHORT).show()
           }
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    /**ok now run this */

}


