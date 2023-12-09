package developer.kalps.edittextrecyclerview

import org.w3c.dom.CharacterData

data class EditTextDataInfo(
    val hint: String,
    var text: String
){
    companion object{
        fun list1()= "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".map { EditTextDataInfo(it.toString(),it.toString()) }
    }
}
