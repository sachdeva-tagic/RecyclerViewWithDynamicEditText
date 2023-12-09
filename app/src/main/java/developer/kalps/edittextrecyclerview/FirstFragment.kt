package developer.kalps.edittextrecyclerview

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import developer.kalps.edittextrecyclerview.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), EditTextChangeListener {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var etAdapter: ETRecyclerViewAdapter

    private var listEt = listOf(
        EditTextDataInfo("a","a"),
        EditTextDataInfo("b","b"),
        EditTextDataInfo("c","c"),
        EditTextDataInfo("d","d"),
        EditTextDataInfo("e","e"),
        EditTextDataInfo("f","f"),
        EditTextDataInfo("g","g"),
        EditTextDataInfo("h","h"),
        EditTextDataInfo("i","i"),
        EditTextDataInfo("j","j"),
        EditTextDataInfo("k","k"),
        EditTextDataInfo("l","l"),
        EditTextDataInfo("m","m"),
        EditTextDataInfo("n","n"),
        EditTextDataInfo("o","o"),
        EditTextDataInfo("p","p"),
        EditTextDataInfo("q","q"),
        EditTextDataInfo("r","r"),
        EditTextDataInfo("s","s"),
        EditTextDataInfo("t","t"),
        EditTextDataInfo("u","u"),
        EditTextDataInfo("v","v"),
        EditTextDataInfo("w","w"),
        EditTextDataInfo("x","x"),
        EditTextDataInfo("y","y"),
        EditTextDataInfo("z","z"),
        EditTextDataInfo("a","a"),
        EditTextDataInfo("b","b"),
        EditTextDataInfo("c","c"),
        EditTextDataInfo("d","d"),
        EditTextDataInfo("e","e"),
        EditTextDataInfo("f","f"),
        EditTextDataInfo("g","g"),
        EditTextDataInfo("h","h"),
        EditTextDataInfo("i","i"),
        EditTextDataInfo("j","j"),
        EditTextDataInfo("k","k"),
        EditTextDataInfo("l","l"),
        EditTextDataInfo("m","m"),
        EditTextDataInfo("n","n"),
        EditTextDataInfo("o","o"),
        EditTextDataInfo("p","p"),
        EditTextDataInfo("q","q"),
        EditTextDataInfo("r","r"),
        EditTextDataInfo("s","s"),
        EditTextDataInfo("t","t"),
        EditTextDataInfo("u","u"),
        EditTextDataInfo("v","v"),
        EditTextDataInfo("w","w"),
        EditTextDataInfo("x","x"),
        EditTextDataInfo("y","y"),
        EditTextDataInfo("z","z")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etAdapter = ETRecyclerViewAdapter(this)
        binding.etRecyclerView.adapter = etAdapter

        etAdapter.etList = listEt //todo : this needs to be tested for a case where data is updated after recycler view is alsready showing edit texts, i.e case of new item addition

        binding.btData.setOnClickListener {
            val text = etAdapter.etList.joinToString(" | ") { "(${it.hint}:${it.text})" }
            AlertDialog.Builder(context).setMessage(
                text
            ).show()
        }

        binding.ntUpdateList.setOnClickListener {
            val list = arrayOf(
                "k","l","m","n","o",
                "p","q","r","s","t",
                "u","v","w","x","y","z"
                ).map {EditTextDataInfo(it,it)  }
            etAdapter.etList = list
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun changeListener(position: Int, changedText: String) {
        listEt[position].text = changedText
    }
}