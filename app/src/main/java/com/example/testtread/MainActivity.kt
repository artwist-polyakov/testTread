package com.example.testtread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.myTextView)

        // Создаём `Handler`, привязанный к ГЛАВНОМУ потоку
        val handler = Handler(Looper.getMainLooper())

        button.setOnClickListener {
            // Создаём объект потока
            val newThread = Thread {
                // Отправляем сообщение в MessageQueue
                // ГЛАВНОГО потока
                handler.post {
                    // Меняем текст
                    textView.text = "Changed text"
                }
            }

            // Стартуем поток!
            newThread.start()
        }
    }
}
