import java.util.*

class MainMenu : MenuModel<Archive>() {

    override val menu: MutableList<Archive> = mutableListOf()
    private val archives = mutableMapOf<String, Archive>()

    override fun create() {
        println(Strings.NEW_NAME_REQST.code)
        val input = Scanner(System.`in`).nextLine()
        if (archives[input] == null) {
            val archive = Archive(input, mutableListOf())
            archives[input] = archive
            menu.add(archive)
        } else {
            println(Strings.ERR_ELEM_EXIST.code)
        }
    }

    override fun printMenuItems(list: MutableList<Archive>) {
        println(Strings.SEL_ITEM_REQST.code)
        println(Strings.MENU_SEPARATOR.code)
        println("${Strings.NEW.code}. ${Strings.NEW_ARCH.code}")
        for (i in list.indices) {
            println("${i + 2}. ${list[i].name}")
        }
        println("${Strings.EXT.code}. ${Strings.EXT_TEXT.code}")
    }

    override fun goToNextNested(element: Archive) {
        ArchiveMenu(element).processInput()
    }
}
