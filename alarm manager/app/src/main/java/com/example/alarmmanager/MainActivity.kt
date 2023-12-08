package com.example.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var btnSetAlaram: Button
    lateinit var timePicker: TimePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Set Yout Alarm"
        timePicker = findViewById(R.id.timePicker)
        btnSetAlaram = findViewById(R.id.button)
        btnSetAlaram.setOnClickListener {
            val calender: Calendar = Calendar.getInstance()
            if (Build.VERSION.SDK_INT >= 23) {
                calender.set(
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH),
                    timePicker.hour,
                    timePicker.minute
                )
            } else {
                calender.set(
                    calender.get(Calendar.YEAR),
                    calender.get(Calendar.MONTH),
                    calender.get(Calendar.DAY_OF_MONTH),
                    timePicker.currentHour,
                    timePicker.currentMinute
                )
            }
            setAlarm(calender.timeInMillis)
        }
    }

    private fun setAlarm(timeInMillis: Long) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, MyAlarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setRepeating(
            AlarmManager.RTC,
            timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show()
    }

    private class MyAlarm : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d("Alarm notif", "Alarm just fired")
        }
    }
}