package com.example.task2

import androidx.annotation.IntRange
import androidx.annotation.NonNull


fun main() {
    println(decryptData(listOf(10, 50, 100, 13, 150), 50, 1, 2))
}


fun decryptData(
    @NonNull price: List<Int>,
    @IntRange(from = 1) discount: Int,
    @IntRange(from = 0) offset: Int,
    @IntRange(from = 1) readLength: Int,
): List<Int>?{
    return if (offset <= price.lastIndex){
        val offsetedPrices = price.drop(offset)
        if (readLength <= offsetedPrices.size){
            offsetedPrices.take(readLength).map { _price ->
                _price * discount/100
            }
        } else{
            println("ReadLength is bigger than offseted prices size. Max value is ${offsetedPrices.size}. Try again.")
            emptyList()
        }
    } else {
        println("Offset is bigger than prices size. Max value is ${price.lastIndex}. Try again.")
        emptyList()
    }
}