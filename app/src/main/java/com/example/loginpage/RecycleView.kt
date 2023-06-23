package com.example.loginpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.loginpage.databinding.MyListItemBinding

// Step1 - view Holder -- For holding the custom Layout file for out Item
class  MyViewHolder(itemView: View) : ViewHolder(itemView) {
 val ivUserpic : ImageView = itemView.findViewById(R.id.ivUserpic)
    val tvfirstName: TextView = itemView.findViewById(R.id.tvFirstName)
    val tvlastName:TextView = itemView.findViewById(R.id.tvLastName)
    val tvcontanct : TextView = itemView.findViewById(R.id.tvContact)

    fun binadata(user: User , listener: MYItemclickListener ){
        // iv.profilepic.set image ("some Image) ;
        tvfirstName.text = user.firstname
        tvlastName.text = user.latsname
        tvcontanct.text = user.contanct
       // listener.onItemClicked(user)
        itemView.setOnClickListener{
            listener.onItemClicked(user)
        }

    }

}

//Step2 -  Adapter-- connecting everything and providing it to the RV
class MyAdapter(private val user: List<User> ,private val listener: MYItemclickListener): Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // TODO to attached the view and conver it into  My view holder
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.my_list_item , parent , false)

        return MyViewHolder(view )
    }

    override fun getItemCount(): Int {
        // TODO return the size of the list need to be populated
       return user.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = user[position]
        // Setting Data to the view
        // But For this you need to call Again and agnain
        // also need to expose the variables of your view Holder class which is not requred at all
        // holder.tvfirst.text = user.firstname
        // holder.tvlast.name = user.lastname
        // we will do it in the singe line with the help of the this data
        holder.binadata(user ,listener )

    }

}

// Interface -- for defifning a click action Event on out List item
interface  MYItemclickListener{
    fun  onItemClicked(user: User)


}