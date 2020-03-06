package com.egloos.neuezeal.exam8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    val numberList = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            numberList)

        numberOption.adapter = adapter

        numberOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                notifyText.text = "${numberList[position]}번을 선택하셨습니다"
            }

        }
        addButton.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                numberList.add(Random.nextInt(0..100))
                adapter.notifyDataSetChanged()
            }

        })

        removeButton.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                if (numberList.isNotEmpty() == true){
                    numberList.removeAt(0)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
}
