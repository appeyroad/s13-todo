package org.appeyroad.s13.todo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_todo.view.*
import org.appeyroad.s13.todo.models.ToDo

class CustomAdapter(
        private val todos: List<ToDo>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val view = View.inflate(context, R.layout.item_todo, parent)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.text = todos[position].content
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val content = view.content
    }
}
