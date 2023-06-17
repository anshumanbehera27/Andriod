package com.example.loginpage


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.loginpage.R.id.btnLogin
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

// TODO 1 : how to pass a dataclass object from one activity to other , Using INtents
// TODO 2 : how to pass a normal class object from one activity to other ,using Intents
// todo parcelbale and seriable
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(btnLogin)
        val etUserName: TextInputEditText = findViewById(R.id.tietUsername)
        val etPassword: TextInputEditText = findViewById(R.id.tietPassword)

        val usernameLayout: TextInputLayout = findViewById(R.id.etUsername)
        val passwordLayout: TextInputLayout = findViewById(R.id.etPassword)

        val tvGotoFAQs:TextView  = findViewById(R.id.tvGotoFaq)

        etUserName.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus)
                usernameLayout.isErrorEnabled = false
        }
        etPassword.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus)
                passwordLayout.isErrorEnabled = false
        }

        // TODO 2: set a click action
        btn.setOnClickListener {
            // TODO 1: get values from ets
            val username = etUserName.text.toString()
            val password = etPassword.text.toString()

            // TODO 3: safety checks on user inputs
            if(username.isBlank()) {
                // Show an error "Please enter a valid username"
                usernameLayout.error = "Please enter a valid username"
            }

            if(password.isEmpty()) {
                //Show error
                passwordLayout.error = "Please enter a password first"
            }

            // TODO 4: Display a Toast on button click
            if(checkFormDetails(username, password)) {
                Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@MainActivity, welcome_activity::class.java)
//                // extra requred  key and value
//                intent.putExtra(USERNMAE_KEY, username)
//                intent.putExtra(PASSWORD_KEY , password)
//
//                startActivity(intent)
                // when we  have more number of value to fatch in the data
                //Bundel is a Key value par object in the andriod
                val bundle = Bundle();
                bundle.putString(USERNMAE_KEY , username)
                bundle.putString(PASSWORD_KEY , password)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
        // TODO : go to the next activity
        /*
        intentes -> one of the use is to negativate  to a new acitvity
        start a new service
        Open some other app
        broad cast message
        */
        /*
        intents are of 2 types
        1  - explicit Intents  -> use for internal navigation - from one activity to other (in the same app)

        2 - Implicits Intents -> use for external navaction - from one activity to other App

        // what is the requrement of the intents
         1 - from sender context address
        2-  reciver - referance
        */

        tvGotoFAQs.setOnClickListener{
            //implicite intent ->action
            // redrict this to a webpages geeksforgeek.com
            // we need to covert this url to uri
            val url:String = "https://www.geeksforgeeks.org/"
            val uri = Uri.parse(url)
            println("URL -$url /nURI - $uri")
            val ImplicitIntent = Intent(Intent.ACTION_VIEW , uri)
            startActivity(ImplicitIntent)

        }

    }

    private fun checkFormDetails(username: String, password: String): Boolean {
        return !(username.isBlank() || password.isEmpty())
    }

    /*

     */
}