package dk.apps.hedgehog.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dk.apps.hedgehog.objects.Joke
import dk.apps.hedgehog.view_holders.JokeViewHolder

class ListAdapter(private val list: List<Joke>) : RecyclerView.Adapter<JokeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JokeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke: Joke = list[position]
        holder.bind(joke)
    }

    override fun getItemCount(): Int = list.size
}