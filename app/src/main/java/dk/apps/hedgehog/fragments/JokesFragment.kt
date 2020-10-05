package dk.apps.hedgehog.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dk.apps.hedgehog.R
import dk.apps.hedgehog.adapters.ListAdapter
import dk.apps.hedgehog.interfaces.ApiService
import dk.apps.hedgehog.objects.Joke
import dk.apps.hedgehog.objects.Result
import kotlinx.android.synthetic.main.fragment_jokes.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NumberFormatException

class JokesFragment : Fragment() {

    var mJokesList: List<Joke> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_jokes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = ApiService.create()
        reload_btn.setOnClickListener {
            try {
                val count: Int = edit_count.text.toString().toInt()
                val result = apiService.getJokes(count)
                result.enqueue(object : Callback<Result> {
                    override fun onResponse(call: Call<Result>, response: Response<Result>) {
                        mJokesList = response.body()!!.value
                        reloadJokes(mJokesList)
                        edit_count.text.clear()
                    }

                    override fun onFailure(call: Call<Result>, t: Throwable?) {
                        Toast.makeText(view.context, "Unable to load the jokes", Toast.LENGTH_SHORT).show()
                    }
                })
            } catch (e: NumberFormatException) {}
        }
        reloadJokes(mJokesList)
    }

    fun reloadJokes(list: List<Joke>) {
        jokes_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ListAdapter(list)
        }
    }

}