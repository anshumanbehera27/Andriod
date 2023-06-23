package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginpage.databinding.ActivityListBinding
import com.example.loginpage.databinding.MyListItemBinding

class ListActivity : AppCompatActivity()  , MYItemclickListener{
    private lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)

        setContentView(binding.root)
// TODO List View
// this for the list view
//        val intengers = (1 .. 25).toList();
//        val MYadapter = ArrayAdapter(this , android.R.layout.simple_list_item_1 ,intengers)
//        binding.mylistView.adapter = MYadapter
//
//
////        binding.mylistView.setOnClickListener{
////            Log.d("lgiuefqew", "Element was clicked")
////        }
//
//        // we need the click event for one paticular elelemt of the listr
//        binding.mylistView.setOnItemClickListener{
//            parent, view , postion , id -> Log.d("dkjdjhldk" , "Element $postion was clicked")
//        }
//
//
//    }
        //TODO  recycle view
        // create a list of the user
        val user = listOf<User>(
            User("rohit " , "sharma" , "93628743687") ,
            User("anshuman " , "sharma" , "93628743687"),
            User("somi " , "sharma" , "93628743687") ,
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),


        )
        // Setting a LayOut Manager For the RV

        binding.Recycleview.layoutManager = LinearLayoutManager(this , RecyclerView.VERTICAL ,false )

        // Setting An Adpter for RV
        binding.Recycleview.adapter = MyAdapter(user ,this)





    }

    override fun onItemClicked(user: User) {
       Log.d("kjwhfui" , user.toString())
    }



}
data class User(
    val firstname: String  = "Abc"
    , val  latsname : String  = "Xyz",
    val contanct:String = "MNO"
)
