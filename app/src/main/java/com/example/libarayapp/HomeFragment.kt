package com.example.libarayapp

import Items
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libarayapp.data.Curtain
import com.google.android.material.chip.Chip


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)



        val genderRecycler: RecyclerView =view.findViewById(R.id.genderRecycle)

        val gridLayoutManager=GridLayoutManager(view.context,3)

         genderRecycler.layoutManager=gridLayoutManager
        val booksAdaptor= PopularBooksAdaptor()


        val chip1:Chip=view.findViewById(R.id.chip_option_1)
        val chip2:Chip=view.findViewById(R.id.chip_option_2)
        val chip3:Chip=view.findViewById(R.id.chip_option_3)
        val chip4:Chip=view.findViewById(R.id.chip_option_4)
        val chip5:Chip=view.findViewById(R.id.chip_option_5)
        val chip6:Chip=view.findViewById(R.id.chip_option_6)
        val chip7:Chip=view.findViewById(R.id.chip_option_7)
        val chip8:Chip=view.findViewById(R.id.chip_option_8)
        val chip9:Chip=view.findViewById(R.id.chip_option_9)
        val chip10:Chip=view.findViewById(R.id.chip_option_10)
        val chip11:Chip=view.findViewById(R.id.chip_option_11)

        chip1.isChecked=true
        val curtain = Curtain()

        val handler = Handler(Looper.getMainLooper())



        curtain.call("Science Fiction", object : Curtain.Callback {

            override fun onSuccess(items: List<Items>) {
                handler.post {
                    println(items.toString())

                    booksAdaptor.setData(items)

                    genderRecycler.adapter = booksAdaptor
                }
            }

            override fun onFailure(errorMessage: String) {
                // Handle failure case

                handler.post{
                    println(errorMessage)
                }
            }
        })

         chip1.setOnClickListener()
         {
             
             curtain.call("Science Fiction", object : Curtain.Callback {

                 override fun onSuccess(items: List<Items>) {
                     handler.post {
                         println(items.toString())

                         booksAdaptor.setData(items)

                         genderRecycler.adapter = booksAdaptor
                     }
                 }

                 override fun onFailure(errorMessage: String) {
                     // Handle failure case

                     handler.post{
                         println(errorMessage)
                     }
                 }
             })

         }
        chip2.setOnClickListener()
        {

            curtain.call("Arts", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })
        }
        chip3.setOnClickListener()
        {

            curtain.call("History", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)
                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })
        }
        chip4.setOnClickListener()
        {
            curtain.call("Mystery", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })



        }
        chip5.setOnClickListener()
        {

            curtain.call("Romance", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })

        }
        chip6.setOnClickListener()
        {

            curtain.call("children's books", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })
        }
        chip7.setOnClickListener()
        {
            curtain.call("Travel", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })
        }
        chip8.setOnClickListener()
        {

            curtain.call("Health", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })

        }
        chip9.setOnClickListener()
        {

            curtain.call("cooking", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })

        }
        chip10.setOnClickListener()
        {
            curtain.call("Computer Science", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })

        }
        chip11.setOnClickListener()
        {
            curtain.call("Biographies", object : Curtain.Callback {

                override fun onSuccess(items: List<Items>) {
                    handler.post {
                        println(items.toString())

                        booksAdaptor.setData(items)

                        genderRecycler.adapter = booksAdaptor
                    }
                }

                override fun onFailure(errorMessage: String) {
                    // Handle failure case

                    handler.post{
                        println(errorMessage)
                    }
                }
            })

        }



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}