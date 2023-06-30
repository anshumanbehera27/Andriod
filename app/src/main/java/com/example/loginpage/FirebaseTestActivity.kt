package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginpage.databinding.ActivityFirebaseTestBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.util.UUID

class FirebaseTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirebaseTestBinding

    private lateinit var mFirebaseDatabase : FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    // TODO 1 - Strore the data to the database
        mFirebaseDatabase  = FirebaseDatabase.getInstance("https://myfirstandriod-109ef-default-rtdb.asia-southeast1.firebasedatabase.app/")
        val reference = mFirebaseDatabase.reference

        val userReferance = reference.child("Users")
        val bookRef = reference.child("Books")
        bookRef.child(UUID.randomUUID().toString()).setValue("Angles And Demons")

        binding.btn.setOnClickListener{
            val firstName = binding.vet1.text.toString()
            val lastName = binding.vet2.text.toString()

            userReferance.child(UUID.randomUUID().toString()).setValue("$firstName $lastName")
            // here we will use the random id beacuse in the data base  we have to store the evey paticular id Uniquly
            binding.vet1.text.clear()
            binding.vet2.text.clear()
        }

        // TODO 2 - Featch the data from the fireBase
        userReferance.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               Log.d("kjsguiye" , "DB Updated ")
                var str  = ""
                // this is for  the single value
                snapshot.children.forEach{
                    str  += "${it.key} - ${it.value}\n"
                }
                binding.tv1.text  = str
                //binding.tv1.text = snapshot.children.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}
/*
* ref -> TOp ele of your DataBase
* ref.child("user') checks if there is user as a child in the data base or not
* if not , it creaters ones and returns  referance of this level now
* After that on button click
* feating the deatils and pusing it into the db like userrefe.child(fn).setvalue(ln)
* this creates a Key value  pair in users becuase we are Adding them in the userref
 */