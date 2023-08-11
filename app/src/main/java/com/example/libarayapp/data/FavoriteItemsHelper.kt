package com.example.libarayapp.data

import Items
import android.content.Context
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class FavoriteItemsHelper(private val context: Context) {

    private val sharedPref = context.getSharedPreferences(
        "favorites", Context.MODE_PRIVATE
    )

    fun getFavoriteItems(): List<Items> {

        val json = sharedPref.getString("favorites", null)

        return if (json != null) {
            val typeToken = object : TypeToken<List<Items>>() {}.type
            Gson().fromJson(json, typeToken)
        } else {
            emptyList()
        }

    }

    fun addFavoriteItem(item: Items) {
        val currentFavorites = getFavoriteItems().toMutableList()
        currentFavorites.add(item)

        val json = Gson().toJson(currentFavorites)
        sharedPref.edit().putString("favorites", json).apply()


    }
}
