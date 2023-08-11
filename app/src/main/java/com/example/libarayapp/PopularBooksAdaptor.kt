package com.example.libarayapp

import Items
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PopularBooksAdaptor(): RecyclerView.Adapter<PopularBooksAdaptor.booksHolder>() {
    var booksList:ArrayList<Items> =arrayListOf<Items>()
    inner class booksHolder(view:View):ViewHolder(view)
    {
        val imageView:ImageView=view.findViewById(R.id.bookImage)
        val bookName:TextView=view.findViewById(R.id.bookName)

       val booksComponent:ConstraintLayout=view.findViewById(R.id.bookComponent)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): booksHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.books_list_component,parent,false)
        return booksHolder(view)

    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    override fun onBindViewHolder(holder: booksHolder, position: Int) {
        holder.bookName.text= booksList[position].volumeInfo?.title ?:""

        GlobalScope.launch(Dispatchers.Main) {
            try {
                val imageUrl = booksList[position].volumeInfo?.imageLinks?.thumbnail

                val result = withContext(Dispatchers.IO) { // Perform network operation on IO dispatcher (background thread)
                    Picasso.get()
                        .load(imageUrl)
                        .placeholder(R.mipmap.book_icon)
                        .get() // Fetches and returns Bitmap synchronously
                }

                holder.imageView.setImageBitmap(result) // Set loaded bitmap to ImageView

            } catch (e: Exception) {
                e.printStackTrace()

            }
        }

        holder.booksComponent.setOnClickListener()
        {
            val intent:Intent=Intent(it.context,BooksDetails::class.java)
            intent.putExtra("itemList",booksList[position])


            it.context.startActivity(intent)
        }





    }

    fun setData(list: List<Items>) {
        booksList.clear()
        booksList.addAll(list)

        notifyDataSetChanged()
    }


}