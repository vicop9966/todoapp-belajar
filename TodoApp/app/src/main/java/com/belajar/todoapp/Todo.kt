package com.belajar.todoapp

/**
 * Ini adalah "model" data kita.
 * Setiap tugas punya: judul (text), dan status selesai/belum (isDone).
 *
 * "data class" di Kotlin otomatis membuatkan fungsi bawaan
 * seperti toString(), equals(), dll — jadi kita tidak perlu tulis manual.
 */
data class Todo(
    var text: String,
    var isDone: Boolean = false
)
