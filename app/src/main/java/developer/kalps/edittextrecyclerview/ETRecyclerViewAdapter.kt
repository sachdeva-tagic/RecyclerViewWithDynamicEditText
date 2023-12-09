package developer.kalps.edittextrecyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ETRecyclerViewAdapter(private val callback : EditTextChangeListener) : RecyclerView.Adapter<ETViewHolder>() {

    var etList: List<EditTextDataInfo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ETViewHolder {
        val vh =  ETViewHolder.create(parent,callback)
        vh.setIsRecyclable(false)
        return vh
    }

    override fun onBindViewHolder(holder: ETViewHolder, position: Int) {
        holder.bind(etList[position])
    }

    override fun getItemCount(): Int = etList.size

    override fun getItemViewType(position: Int) = position

    override fun getItemId(position: Int) = position.toLong()

}