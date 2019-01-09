package com.example.erycoking.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var n1: Double = 0.00
    lateinit var operator: String
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.editText)
    }

    fun getClickedNumber(v : View)
    {
        var btn = v as Button
        val num = btn.text.toString().toInt()
        result.text = result.text.toString() + (num.toString())
    }

    fun opetarotClicked(v: View)
    {
        var operatorBtn = v as Button
        n1 = result.text.toString().toDouble()
        operator = operatorBtn.text.toString()
        result.text = result.text.toString() + operator
    }

    fun calculate(v: View)
    {
        var op: String = operator
        var n2 = (result.text.toString()).split(op).last().toString().toDouble()

        var output: Double? = when (op)
        {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            else -> null
        }

        result.text = output.toString()
    }

    fun del(v: View)
    {
        var current: String = result.text.toString()
        result.text = current.substring(0, current.length - 1)

    }

    fun dotClicked(v: View)
    {
        val btn1 = v as Button
        val dot = btn1.text.toString()
        result.text = result.text.toString() + (dot)
    }

}
