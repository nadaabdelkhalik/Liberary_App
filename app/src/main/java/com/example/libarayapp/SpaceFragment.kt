package com.example.libarayapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpaceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpaceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private  var reference: DatabaseReference =database.reference.child("quotes")

    private var list:ArrayList<String> =ArrayList()
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

       val view= inflater.inflate(R.layout.fragment_space, container, false)
        val editText:EditText=view.findViewById(R.id.editText4)
        val saveButton:Button=view.findViewById(R.id.SaveQoutes)

        val qoutesRecycler: RecyclerView =view.findViewById(R.id.qoutesRecycle)
        val layoutManager= LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
        qoutesRecycler.layoutManager=layoutManager
        val adaptor=QoutesAdaptor()
        adaptor.setData(list)
        qoutesRecycler.adapter=adaptor
        saveButton.setOnClickListener()

        {
            val newQuote = editText.text.toString()

            if (newQuote.isNotEmpty()) {
                reference.push().setValue(newQuote)
                editText.text.clear()
            }

            reference.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    list.clear()

                    for (snapshot in dataSnapshot.children) {
                        snapshot.getValue(String::class.java)?.let { quote ->
                            list.add(0,quote)

                        }
                    }

                    adaptor.setData(list)
                    qoutesRecycler.adapter=adaptor


                }

                override fun onCancelled(databaseError: DatabaseError) {}
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
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpaceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}