package com.example.tryingtousedatabases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.tryingtousedatabases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val db = MainDB.getDb(this)
        db.getDao().getData().asLiveData().observe(this)
        {
            list->
            binding.tv.text = ""
            list.forEach{
                val text = "Id: ${it.id}, Name: ${it.name}, Pass: ${it.pass}\n"
                binding.tv.append(text)
            }
        }

        binding.saveb.setOnClickListener()
        {
            val item = Items(null, binding.name.text.toString(), binding.pass.text.toString())
            Thread{db.getDao().insertitem(item)}.start()



        }



        setContentView(binding.root)
    }
}