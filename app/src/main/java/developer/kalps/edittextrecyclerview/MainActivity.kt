package developer.kalps.edittextrecyclerview

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import developer.kalps.edittextrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),EditTextChangeListener {

    private lateinit var binding: ActivityMainBinding

    private val etAdapter = ETRecyclerViewAdapter(this)
    private var listEt = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".map { EditTextDataInfo("$it","$it") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val context = this

        with(binding){
            etRecyclerView.adapter = etAdapter
            btData.setOnClickListener {
                val text = etAdapter.etList.joinToString(" | ") { "(${it.hint}:${it.text})" }
                AlertDialog.Builder(context).setMessage(
                    text
                ).show()
            }

            ntUpdateList.setOnClickListener {
                val list = "klmnopqrstuvwxyz".map {EditTextDataInfo("$it","$it")  }
                etAdapter.etList = list
            }
            etAdapter.etList = listEt
        }
    }

    override fun changeListener(position: Int, changedText: String) {
        listEt[position].text = changedText
    }

}