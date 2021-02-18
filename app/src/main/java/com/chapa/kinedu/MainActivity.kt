package com.chapa.kinedu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.chapa.kinedu.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }

    fun solution(A: IntArray): Int {
        val myList = A.toMutableList().filter { it > 0 }
        for (i in 1..100000) myList.find { it == i } ?: return i
        return 1
    }
    
    fun solution(A: Array<String>, B: Array<String>, P: String) : String {
        return A.zip(B).toMap().toMutableMap().filterValues { it.contains(P) }.keys.minBy { it.length } ?: "NO CONTACT"
    }

    fun solution(S: String): String {
        val filtered = S.filter { it.isDigit() }

        val difTerm = filtered.length % 3 == 1

        var result = ""
        var counter = 0
        var dashesCounter = 0
        for (i in filtered.indices) {
            result += filtered[i]
            counter++

            if (difTerm) {
                val charsLeft = filtered.length - i
                if (charsLeft == 3) {
                    result += "-"
                    dashesCounter++
                    counter = 0
                }

            }

            if (counter == 3 && i != filtered.length) {
                result += "-"
                dashesCounter++
                counter = 0
            }
        }

        return result
    }



    fun solution(Y: Int, A: String, B: String, W: String): Int {
        val monthA = getMonthNumber(A)
        val monthB = getMonthNumber(B)
        val starts = getFirstMonday(Y, monthA)
        val finishes = getLastSunday(Y, monthB)
        val days = finishes - (starts - 1)
        return days / 7
    }

    fun getMonthNumber(month : String) : Int {
        val myCalendar = Calendar.getInstance()
        myCalendar.time = SimpleDateFormat("MMMM").parse(month)
        return myCalendar.get(Calendar.MONTH)
    }

    fun getFirstMonday(year: Int, month: Int): Int {
        val myCalendar : Calendar = Calendar.getInstance()
        myCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        myCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1)
        myCalendar.set(Calendar.MONTH, month)
        myCalendar.set(Calendar.YEAR, year)
        return myCalendar.get(Calendar.DAY_OF_YEAR)
    }

    fun getLastSunday(year: Int, month: Int): Int {
        val myCalendar : Calendar = Calendar.getInstance()
        myCalendar[year, month + 1] = 1
        myCalendar.add(Calendar.DATE, -1)
        myCalendar.add(Calendar.DAY_OF_MONTH, -(myCalendar[Calendar.DAY_OF_WEEK] - 1))
        return myCalendar.get(Calendar.DAY_OF_YEAR)
    }



    fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
        val myPaths = A.zip(B).toMutableList()
        myPaths.addAll(B.zip(A).toMutableList())
        for(i in 1 until N) if (myPaths.none { it.first == i && it.second == (i + 1) }) return false
        return true
    }





}