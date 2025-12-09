// Класс для архива
data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

// Класс для заметки
data class Note(val title: String, val content: String)
