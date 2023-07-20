package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener{view ->

            ClickDatePicker(view)

           }
    }



    fun ClickDatePicker(view: View)
    {
        val mycalendar = Calendar.getInstance()
        val year = mycalendar.get(Calendar.YEAR)
        val month = mycalendar.get(Calendar.MONTH)
        val day = mycalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        {
                view, sel_year, sel_month, sel_dayofmonth ->

            val seldate = "$sel_dayofmonth/${sel_month + 1}/$sel_year"

            tvSelectedDate.setText(seldate)

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val the_date = sdf.parse(seldate)


            val seldateinmin = the_date!!.time / 60000

            val currentdate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentdattomin = currentdate!!.time / 60000

            val difference = currentdattomin - seldateinmin

            tvSelecteddateinminutes.setText(difference.toString())
        },
            year,month,day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }

}