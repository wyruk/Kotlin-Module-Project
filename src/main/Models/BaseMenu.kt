import java.util.Scanner

// Базовый класс для меню
abstract class BaseMenu<T>(protected val items: List<T>, protected val header: String) {
    // Сканер для ввода
    protected val scanner = Scanner(System.`in`)

    // Показываем меню
    open fun show() {
        var running = true
        while (running) {
            // Печатаем меню
            printMenu()
            // Читаем ввод пользователя
            val input = readInput()

            // Обрабатываем выбор
            if (input == 0) {
                // Создать новый элемент
                val result = createItem()
                if (!result) {
                    running = false
                }
            } else if (input >= 1 && input <= items.size) {
                // Выбрать элемент из списка
                val selectedItem = items[input - 1]
                val result = selectItem(selectedItem)
                if (!result) {
                    running = false
                }
            } else if (input == items.size + 1) {
                // Выход
                running = false
            } else {
                // Неправильный ввод
                showError("Такой цифры нет. Пожалуйста, введите корректный символ.")
            }
        }
    }

    // Текст для кнопки создания (можно переопределить)
    protected open fun getCreateItemText(): String {
        return "Создать"
    }

    // Печатаем меню на экран
    protected open fun printMenu() {
        println(header)
        println("0. ${getCreateItemText()}")
        // Печатаем все элементы списка
        for (i in items.indices) {
            val item = items[i]
            val displayName = getDisplayName(item)
            println("${i + 1}. $displayName")
        }
        println("${items.size + 1}. Выход")
        print("Выберите пункт меню: ")
    }

    // Читаем ввод пользователя
    protected fun readInput(): Int {
        while (true) {
            try {
                val line = scanner.nextLine()
                val number = line.toInt()
                return number
            } catch (e: Exception) {
                // Если не число, показываем ошибку
                showError("Введите число")
                println()
                // Показываем меню снова
                printMenu()
            }
        }
    }

    // Показываем ошибку
    protected fun showError(message: String) {
        println("Ошибка: $message")
    }

    // Получить имя для отображения (нужно реализовать)
    abstract fun getDisplayName(item: T): String

    // Создать новый элемент (нужно реализовать)
    abstract fun createItem(): Boolean

    // Выбрать элемент (нужно реализовать)
    abstract fun selectItem(item: T): Boolean
}
