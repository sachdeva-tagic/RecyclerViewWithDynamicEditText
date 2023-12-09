package developer.kalps.edittextrecyclerview.unused

import androidx.fragment.app.Fragment
import developer.kalps.edittextrecyclerview.EditTextChangeListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), EditTextChangeListener {


    override fun changeListener(position: Int, changedText: String) {

    }
}