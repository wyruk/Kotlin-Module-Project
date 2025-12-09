// Главная функция программы
fun main() {
    // Создаем список архивов
    val archives = mutableListOf<Archive>()
    // Показываем меню архивов
    val archiveMenu = ArchiveScreen(archives)
    archiveMenu.show()
}
