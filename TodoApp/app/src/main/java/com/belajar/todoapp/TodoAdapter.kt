package com.belajar.todoapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter bertugas "menjembatani" data (List<Todo>) dengan tampilan RecyclerView.
 * Bayangkan RecyclerView seperti mesin fotokopi: dia punya 1 desain item
 * (item_todo.xml), lalu adapter ini yang mengisi desain itu dengan data
 * berbeda-beda untuk tiap baris.
 *
 * Parameter:
 * - todoList: daftar tugas yang ditampilkan
 * - onItemChecked: fungsi yang dipanggil saat checkbox dicentang/dilepas
 * - onItemDeleted: fungsi yang dipanggil saat tombol hapus ditekan
 */
class TodoAdapter(
    private val todoList: MutableList<Todo>,
    private val onItemChecked: (Int) -> Unit,
    private val onItemDeleted: (Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    // ViewHolder = "wadah" yang menyimpan referensi ke tiap komponen UI dalam 1 baris item
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.checkboxTodo)
        val textView: TextView = itemView.findViewById(R.id.textTodo)
        val deleteButton: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    // Dipanggil saat RecyclerView butuh baris baru untuk ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    // Dipanggil untuk mengisi data ke dalam baris pada posisi tertentu
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]

        holder.textView.text = todo.text
        holder.checkBox.isChecked = todo.isDone

        // Kalau sudah selesai, teks dicoret (strikethrough)
        if (todo.isDone) {
            holder.textView.paintFlags = holder.textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.textView.paintFlags = holder.textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.checkBox.setOnClickListener {
            onItemChecked(holder.adapterPosition)
        }

        holder.deleteButton.setOnClickListener {
            onItemDeleted(holder.adapterPosition)
        }
    }

    // Memberitahu RecyclerView berapa total item yang harus ditampilkan
    override fun getItemCount(): Int = todoList.size
}
