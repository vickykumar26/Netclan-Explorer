package com.example.netclanexplorer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Refine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)

        val spLayout = findViewById<TextView>(R.id.sp_layout)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrow_back = findViewById<ImageView>(R.id.arrow_back)

        arrow_back.setOnClickListener {
            val i = Intent(this@Refine,MainActivity::class.java)
            startActivity(i)
            finish()
        }



        ArrayAdapter.createFromResource(
            this,
            R.array.list_mode,
            R.layout.drop_down_item
        )
            .also {
                spinner.adapter = it
                it.setDropDownViewResource(R.layout.drop_down_item)
            }

        spLayout.setOnClickListener {
            spinner.performClick()
        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                ContextCompat.getColor(this@Refine, R.color.black)?.let {
                    if (p1 is TextView) {
                        p1.setTextColor(it)
                        p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                    }
                }
                p0?.getItemAtPosition(p2).let {
                    spLayout.text = it.toString()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val adaptor = RefineAdapter(fetchData())
        recyclerView.layoutManager = GridLayoutManager(this,4)
        recyclerView.adapter = adaptor

    }
    private fun fetchData(): ArrayList<String> {
        val item = ArrayList<String>()

        item.add("Coffee")
        item.add("Business")
        item.add("Hobbies")
        item.add("Friendship")
        item.add("Movies")
        item.add("Dinning")
        item.add("Dating")
        item.add("Matrimony")

        return item
    }

}