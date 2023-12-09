package developer.kalps.edittextrecyclerview

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.kalps.edittextrecyclerview.databinding.EtItemBinding

class ETViewHolder(private val binding: EtItemBinding,private val callback: EditTextChangeListener) : RecyclerView.ViewHolder(binding.root) {

    init {
        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable) { callback.changeListener(adapterPosition, s.toString()) }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        }
        binding.etItem.addTextChangedListener(watcher)
    }

    fun bind(etInfo: EditTextDataInfo) {
        binding.tilItem.hint = etInfo.hint
        binding.etItem.setText(etInfo.text)
    }



    companion object {
        fun create(parent: ViewGroup,callback: EditTextChangeListener) = ETViewHolder(
            EtItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            callback
        )
    }
}