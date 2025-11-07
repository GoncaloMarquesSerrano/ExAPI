package pt.ipt.dam2025.exapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.ipt.dam2025.exapi.R
import pt.ipt.dam2025.exapi.model.Fact

class FactListAdapter(
    private val facts: List<Fact.DogFact>,
    private val context: Context
) : RecyclerView.Adapter<FactListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fact = facts[position]
        holder.bindView(fact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fact_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = facts.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(fact: Fact.DogFact) {
            val title: TextView = itemView.findViewById(R.id.factTextView)
            title.text = fact.attributes.body
        }
    }
}
