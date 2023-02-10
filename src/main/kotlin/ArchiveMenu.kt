import java.util.Scanner

class ArchiveMenu(archive: Archive) : MenuModel<Note>() {

    override val menu: MutableList<Note> = archive.notes
    private val notes = mutableMapOf<String, Note>()

    override fun create() {
        println(Strings.NEW_NAME_REQST.code)
        val name = Scanner(System.`in`).nextLine()
        if (notes[name] == null) {
            println(Strings.NEW_TEXT_REQST.code)
            val input = Scanner(System.`in`).nextLine()
            val note = Note(name, input)
            notes[name] = note
            menu.add(note)
        } else {
            println(Strings.ERR_ELEM_EXIST.code)
        }
    }

    override fun printMenuItems(list: MutableList<Note>) {
        println(Strings.SEL_ITEM_REQST.code)
        println("${Strings.NEW.code}. ${Strings.NEW_NOTE.code}")
        for (i in list.indices) {
            println("${i + 2}. ${list[i].name}")
        }
        println("${Strings.EXT.code}. ${Strings.EXT_TEXT.code}")
    }

    override fun goToNextNested(element: Note) {
        println("\n ${element.text} \n")
    }

}