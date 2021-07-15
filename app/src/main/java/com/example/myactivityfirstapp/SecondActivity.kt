package com.example.myactivityfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.*

class SecondActivity : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val count = findViewById<TextView>(R.id.fragCount)
        val addButton = findViewById<Button>(R.id.addButton)
        val removeButton = findViewById<Button>(R.id.removeButton)
        fragmentManager = supportFragmentManager
        fragmentManager.addOnBackStackChangedListener {
            count.text = "Fragment Count = ${fragmentManager.backStackEntryCount}"
        }
        addButton.setOnClickListener{
            addFragment()
        }
        removeButton.setOnClickListener {
            removeFragment()
        }
    }
    private fun removeFragment(){
        fragmentManager.popBackStack()

    }
    private fun addFragment(){
        fragmentManager = supportFragmentManager
        val fragment: Fragment = when(fragmentManager.backStackEntryCount){
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> BlankFragment()
        }
        if (fragment != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment).addToBackStack(null)
            transaction.commit()
        }

    }
}