package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: ArrayList<Int>
    lateinit var title: Array<String>
    lateinit var description: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }

    private fun dataInitialize(){
        movieArrayList = arrayListOf<Movie>()

        image = arrayListOf(
            R.drawable.luca,
            R.drawable.rayadandragon,
            R.drawable.sing2,
            R.drawable.theiceage,
            R.drawable.finch,
            R.drawable.jung_e,
            R.drawable.knowing,
            R.drawable.sanandreas
        )

        title = arrayOf(
            getString(R.string.luca),
            getString(R.string.raya),
            getString(R.string.sing),
            getString(R.string.ice),
            getString(R.string.finch),
            getString(R.string.jung),
            getString(R.string.knowing),
            getString(R.string.andreas)
        )

        description = arrayOf(
            getString(R.string.luca),
            getString(R.string.raya),
            getString(R.string.sing),
            getString(R.string.ice),
            getString(R.string.finch),
            getString(R.string.jung),
            getString(R.string.knowing),
            getString(R.string.andreas)
        )

        for (i in image.indices){
            val movie = Movie(image[i], title[i], description[i])
            movieArrayList.add(movie)
        }
    }

}

