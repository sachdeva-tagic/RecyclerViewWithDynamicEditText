/*
package developer.kalps.edittextrecyclerview

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView


class ETAdapter(private val mDataset: Array<String>) : RecyclerView.Adapter<ETAdapter.ViewHolder>() {
//    private lateinit var mDataset: Array<String>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ETAdapter.ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.et_item, parent, false)
        // pass MyCustomEditTextListener to viewholder in onCreateViewHolder
        // so that we don't have to do this expensive allocation in onBindViewHolder
        return ViewHolder(v, MyCustomEditTextListener())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // update MyCustomEditTextListener every time we bind a new item
        // so that it knows what item in mDataset to update
        holder.myCustomEditTextListener.updatePosition(holder.adapterPosition)
        holder.mEditText.setText(mDataset[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }


    class ViewHolder(v: View, myCustomEditTextListener: MyCustomEditTextListener) :
        RecyclerView.ViewHolder(v) {
        // each data item is just a string in this case
        var mEditText: EditText
        var myCustomEditTextListener: MyCustomEditTextListener

        init {
            mEditText = v.findViewById(R.id.et_item)
            this.myCustomEditTextListener = myCustomEditTextListener
            mEditText.addTextChangedListener(myCustomEditTextListener)
        }
    }

    // we make TextWatcher to be aware of the position it currently works with
    // this way, once a new item is attached in onBindViewHolder, it will
    // update current position MyCustomEditTextListener, reference to which is kept by ViewHolder
    class MyCustomEditTextListener : TextWatcher {
        private var position = 0
        fun updatePosition(position: Int) {
            this.position = position
        }

        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
            // no op
        }

        override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {
            mDataset.get(position) = charSequence.toString()
        }

        override fun afterTextChanged(editable: Editable) {
            // no op
        }
    }
}*/
