package com.example.libarayapp

import Items
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.libarayapp.data.Curtain

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
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

       val view= inflater.inflate(R.layout.fragment_search, container, false)
        val searchView:SearchView=view.findViewById(R.id.search)
        val hintText = "Enter the book Title or Author "
        val spannableText = SpannableString(hintText)
        spannableText.setSpan(ForegroundColorSpan(Color.GRAY), 0, hintText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        searchView.queryHint = spannableText
        val searchRecycler: RecyclerView =view.findViewById(R.id.searchRecycle)
        val layoutManager= LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        searchRecycler.layoutManager=layoutManager
        val searchAdaptor= PopularBooksAdaptor()

        val curtain = Curtain()
        val handler = Handler(Looper.getMainLooper())
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText:
                                           String): Boolean {


                curtain.call(newText, object : Curtain.Callback {

                    override fun onSuccess(items: List<Items>) {

                        handler.post {
                            println(items.toString())
                            searchAdaptor.setData(items)
                            searchRecycler.adapter=searchAdaptor
                        }



                    }

                    override fun onFailure(errorMessage: String) {
                        // Handle failure case
                        handler.post { println(errorMessage) }

                    }
                })


                return true
            }
        })
return view
}
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}