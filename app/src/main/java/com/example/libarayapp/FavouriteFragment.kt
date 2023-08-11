package com.example.libarayapp

import Items
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.libarayapp.data.Curtain
import com.example.libarayapp.data.FavoriteItemsHelper

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavouriteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavouriteFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view= inflater.inflate(R.layout.fragment_favourite, container, false)


        val favouriteRecycler: RecyclerView =view.findViewById(R.id.favouriteRecycle)
        val gridLayoutManager= GridLayoutManager(view.context,3)
        favouriteRecycler.layoutManager=gridLayoutManager
        val booksAdaptor= PopularBooksAdaptor()




        booksAdaptor.setData(FavoriteItemsHelper(view.context).getFavoriteItems())
        favouriteRecycler.adapter=booksAdaptor
        favouriteRecycler.adapter=booksAdaptor
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavouriteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}