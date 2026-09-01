package com.belajar.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.belajar.todoapp.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    // "binding" memberi kita akses langsung ke semua View di activity_main.xml
    // tanpa perlu findViewById berulang-ulang.
    private lateinit var binding: ActivityMainBinding

    // Daftar tugas kita simpan di memori selama app berjalan
    private val todoList = mutableListOf<Todo>()

    private lateinit var adapter: TodoAdapter

    // Nama file SharedPreferences tempat kita menyimpan data secara permanen
    private val PREFS_NAME = "todo_prefs"
    private val KEY_TODO_LIST = "todo_list"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTodos() // ambil data yang tersimpan sebelumnya (kalau ada)
        setupRecyclerView()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter(
            todoList = todoList,
            onItemChecked = { position ->
                // toggle status selesai/belum, lalu simpan & refresh tampilan
                todoList[position].isDone = !todoList[position].isDone
                saveTodos()
                adapter.notifyItemChanged(position)
            },
            onItemDeleted = { position ->
                todoList.removeAt(position)
                saveTodos()
                adapter.notifyItemRemoved(position)
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun setupAddButton() {
        binding.btnAdd.setOnClickListener {
            val text = binding.editTextTodo.text.toString().trim()

            if (text.isEmpty()) {
                binding.editTextTodo.error = "Tulis tugasnya dulu"
                return@setOnClickListener
            }

            todoList.add(Todo(text = text, isDone = false))
            adapter.notifyItemInserted(todoList.size - 1)
            binding.editTextTodo.text.clear()
            saveTodos()

            // auto-scroll ke item baru
            binding.recyclerView.scrollToPosition(todoList.size - 1)
        }
    }

    /**
     * Menyimpan daftar tugas ke SharedPreferences dalam format JSON.
     * Kita tidak pakai database (Room) dulu supaya lebih sederhana untuk belajar.
     */
    private fun saveTodos() {
        val jsonArray = JSONArray()
        for (todo in todoList) {
            val obj = JSONObject()
            obj.put("text", todo.text)
            obj.put("isDone", todo.isDone)
            jsonArray.put(obj)
        }

        val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        prefs.edit().putString(KEY_TODO_LIST, jsonArray.toString()).apply()
    }

    /**
     * Membaca kembali daftar tugas yang pernah disimpan.
     */
    private fun loadTodos() {
        val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val jsonString = prefs.getString(KEY_TODO_LIST, null) ?: return

        val jsonArray = JSONArray(jsonString)
        todoList.clear()
        for (i in 0 until jsonArray.length()) {
            val obj = jsonArray.getJSONObject(i)
            todoList.add(
                Todo(
                    text = obj.getString("text"),
                    isDone = obj.getBoolean("isDone")
                )
            )
        }
    }
}
