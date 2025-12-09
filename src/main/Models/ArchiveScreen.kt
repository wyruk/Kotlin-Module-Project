// Класс для работы с архивами
class ArchiveScreen(private val archives: MutableList<Archive>) : BaseMenu<Archive>(archives, "Список архивов:") {

    // Получаем имя архива для отображения
    override fun getDisplayName(item: Archive): String {
        return item.name
    }

    // Текст для кнопки создания
    override fun getCreateItemText(): String {
        return "Создать архив"
    }

    // Создать новый архив
    override fun createItem(): Boolean {
        print("Введите название архива: ")
        val name = scanner.nextLine().trim()

        // Проверяем, что имя не пустое
        if (name.isEmpty()) {
            showError("Название не может быть пустым")
        } else {
            // Создаем новый архив
            val newArchive = Archive(name)
            archives.add(newArchive)
            println("Архив '$name' создан")
        }

        return true
    }

    // Выбрать архив
    override fun selectItem(item: Archive): Boolean {
        // Показываем меню заметок для этого архива
        val noteMenu = NoteScreen(item.notes)
        noteMenu.show()
        return true
    }
}
