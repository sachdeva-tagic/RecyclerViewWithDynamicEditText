package developer.kalps.edittextrecyclerview

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.kalps.edittextrecyclerview.databinding.EtItemBinding

class ETViewHolder(private val binding: EtItemBinding) : RecyclerView.ViewHolder(binding.root) {

    private var _callback: EditTextChangeListener? = null

    fun bind(etInfo: EditTextDataInfo, callback: EditTextChangeListener) {
        _callback = callback
        binding.tilItem.hint = etInfo.hint
        binding.etItem.setText(etInfo.text) // todo this works for now, but this should be text input edittext
        binding.etItem.addTextChangedListener(etTextWatcher)
    }

    private val etTextWatcher = textWatcher { text ->
        _callback?.changeListener(adapterPosition, text)
    }

    fun textWatcher(callback: (input: String) -> Unit) : TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                callback.invoke(s.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup) = ETViewHolder(
            EtItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}