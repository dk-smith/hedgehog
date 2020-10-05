package dk.apps.hedgehog.view_holders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dk.apps.hedgehog.R
import dk.apps.hedgehog.objects.Joke

class JokeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.joke_list_item, parent, false)) {
    private var mJokeText: TextView? = null

    init {
        mJokeText = itemView.findViewById(R.id.joke_text)
    }

    fun bind(joke: Joke) {
        mJokeText?.text = joke.joke;
    }
}