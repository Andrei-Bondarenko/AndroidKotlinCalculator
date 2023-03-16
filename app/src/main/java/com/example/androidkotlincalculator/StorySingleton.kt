package com.example.androidkotlincalculator

object StorySingleton {
    private val storyList: ArrayList<String?> = ArrayList()
    fun setStoryEntry(answer: String) {
        storyList.add(answer)
    }

    fun getStoryList(): ArrayList<String?> {
        return storyList
    }
}