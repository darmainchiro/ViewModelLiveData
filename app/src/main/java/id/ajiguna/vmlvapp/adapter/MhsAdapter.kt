package id.ajiguna.vmlvapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import id.ajiguna.vmlvapp.R
import id.ajiguna.vmlvapp.model.Mahasiswa
import id.ajiguna.vmlvapp.model.TodoModel

class MhsAdapter(var mhs: LiveData<List<Mahasiswa>>) :
    RecyclerView.Adapter<MhsAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mhs, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tv_name).text = mhs.value!!.get(position).name
            findViewById<TextView>(R.id.tv_nim).text = mhs.value!!.get(position).nim
            findViewById<TextView>(R.id.tv_kelas).text = mhs.value!!.get(position).kelas
        }
    }

    override fun getItemCount(): Int {
        return mhs.value!!.size
    }
}