import java.util.*

abstract class MenuModel<T> {

    abstract val menu: MutableList<T>

    abstract fun create()
    abstract fun printMenuItems(list: MutableList<T>)
    abstract fun goToNextNested(element: T)
    
    fun processInput() {
        printMenuItems(menu)
        var input = Scanner(System.`in`).nextLine()
        while (input != Strings.EXT.code) {
            when (input) {
                Strings.NEW.code -> {
                    create()
                }
                else -> {
                    val result = input.toIntOrNull()
                    when {
                        result == null -> println(Strings.ERR_INPT_TYPES.code)
                        (result - 2) >= 0 && (result - 2) < menu.size -> {
                            val element = menu[(result - 2)]
                            goToNextNested(element)
                        }
                        else -> println(Strings.ERR_INPT_RANGE.code)
                    }
                }
            }
            printMenuItems(menu)
            input = Scanner(System.`in`).nextLine()
        }
    }
}