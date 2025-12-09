// Класс для работы с заметками
class NoteScreen(private val notes: MutableList<Note>) : BaseMenu<Note>(notes, "Список заметок:") {

    // Получаем название заметки для отображения
    override fun getDisplayName(item: Note): String {
        return item.title
    }

    // Текст для кнопки создания
    override fun getCreateItemText(): String {
        return "Создать заметку"
    }

    // Создать новую заметку
    override fun createItem(): Boolean {
        // Запрашиваем название
        print("Введите название заметки: ")
        val title = scanner.nextLine().trim()

        // Проверяем название
        if (title.isEmpty()) {
            showError("Название не может быть пустым")
            return true
        }

        // Запрашиваем содержание
        print("Введите содержание заметки: ")
        val content = scanner.nextLine().trim()

        // Проверяем содержание
        if (content.isEmpty()) {
            showError("Содержание не может быть пустым")
            return true
        }

        // Создаем новую заметку
        val newNote = Note(title, content)
        notes.add(newNote)
        println("Заметка '$title' создана")

        return true
    }

    // Показать заметку
    override fun selectItem(item: Note): Boolean {
        // Выводим заголовок
        println("\n★★★ ${item.title} ★★★")
        // Выводим содержание
        println(item.content)
        // Ждем нажатия Enter
        println("\nНажмите Enter для возврата")
        scanner.nextLine()
        return true
    }
}
