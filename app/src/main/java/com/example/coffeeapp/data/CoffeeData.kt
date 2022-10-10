package com.example.coffeeapp.data

import android.content.Context
import com.example.coffeeapp.R
import com.example.coffeeapp.model.Coffee

class CoffeeData(val context: Context) {

    fun loadCoffee() : List<Coffee> {
        return listOf<Coffee>(
            Coffee(R.array.coffee_data1),
            Coffee(R.array.coffee_data2),
            Coffee(R.array.coffee_data3)
        )
    }

    fun loadOneCoffee(index : Int) : Coffee{
        return loadCoffee()[index]
    }
}