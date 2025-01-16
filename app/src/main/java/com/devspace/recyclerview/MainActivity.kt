package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvlist.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvlist.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }

}


val contacts = listOf(

    Contact(
        "Roque",
        "(55)11 98756-75884",
        R.drawable.sample2
    ),

    Contact(
        "Bruna",
        "(55)11 92256-7444",
        R.drawable.sample1
    ),
    Contact(
        "Brenda",
        "(55)11 92356-7384",
        R.drawable.sample3
    ),

    Contact(
        "Julia",
        "(55)11 98326-7464",
        R.drawable.sample4
    ),

    Contact(
        "Camila",
        "(55)11 99756-3384",
        R.drawable.sample5
    ),

    Contact(
        "Francisco",
        "(55)11 99336-2284",
        R.drawable.sample8
    ),

    Contact(
        "Erick",
        "(55)11 99116-1184",
        R.drawable.sample9
    ),

    Contact(
        "João",
        "(55)11 99236-1135",
        R.drawable.sample10
    ),

    Contact(
        "Helena",
        "(55)11 99216-1235",
        R.drawable.sample11
    ),

    Contact(
        "José",
        "(55)11 92356-1284",
        R.drawable.sample12
    ),

    Contact(
        "Maria",
        "(55)11 99226-3384",
        R.drawable.sample13
    ),

    Contact(
        "Enzo",
        "(55)11 99336-1974",
        R.drawable.sample14
    ),

    Contact(
        "Laura",
        "(55)11 99212-2135",
        R.drawable.sample15
    ),

    Contact(
        "Gabi",
        "(55)11 99217-1234",
        R.drawable.sample16
    )

)