package com.example.libarayapp

import Items
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.libarayapp.data.FavoriteItemsHelper
import com.squareup.picasso.Picasso

class BooksDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_details)
        val receivedIntent = intent

        if (receivedIntent.hasExtra("itemList")) {
            val item = receivedIntent.getSerializableExtra("itemList") as Items

            val text:TextView=findViewById(R.id.bookName)
            val author:TextView= findViewById(R.id.bookAuthor)
            text.text= item.volumeInfo?.title ?: ""

            val authors = item.volumeInfo?.authors
            if (authors != null && authors.isNotEmpty()) {

                author.text= "Author: ${item.volumeInfo?.authors?.get(0)}"
            }
            val rate:TextView= findViewById(R.id.bookRate)
            rate.text= " Book Rate: ${item.volumeInfo?.ratingsCount}"
            val pageCount:TextView= findViewById(R.id.pagesCount)
            pageCount.text= "Page Count: ${item.volumeInfo?.pageCount}"
            val category:TextView= findViewById(R.id.bookCategory)
            val categories = item.volumeInfo?.categories
            if (categories != null && categories.size > 0) {

                category.text= "Category: ${item.volumeInfo?.categories?.get(0)}"

            }
            val description:TextView= findViewById(R.id.bookDescription)
            description.text= item.volumeInfo?.description ?: ""
             val imageView:ImageView=findViewById(R.id.bookImage)
            Picasso.get().load(item.volumeInfo?.imageLinks?.thumbnail).into(imageView)
            val button:Button=findViewById(R.id.previewBook)
            button.setOnClickListener()
            {
                val previewLink= item.volumeInfo?.previewLink

                if(previewLink!=null)
                {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(previewLink)

                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this,"This Book is not available",Toast.LENGTH_SHORT).show()
                }

            }
            val addToFavourite:ImageButton=findViewById(R.id.favourite)
            addToFavourite.setOnClickListener()
            {
                FavoriteItemsHelper(this).addFavoriteItem(item)
            }








        }
    }
}