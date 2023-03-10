package com.paulo.kmm.viewmodel

import com.paulo.kmm.BaseSharedViewModel
import com.paulo.kmm.models.Story
import com.paulo.kmm.models.StoryMedia
import com.paulo.kmm.providers.DataSourceProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SampleViewModel: BaseSharedViewModel() {
    // your business logic and states goes here

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories

    private val _error = MutableStateFlow(false)
    val error: StateFlow<Boolean> = _error

    private val dataSourceProvider = DataSourceProvider()

    fun loadStories(){
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.insertStories(mockStories())
                db.getAllStories()
            }.onSuccess {
                _error.emit(true)
            }.onSuccess {
                _stories.emit(it)
            }
        }
    }
    fun clear(){
        scope.launch {
            kotlin.runCatching {
                val db = dataSourceProvider.getLocalCommonDatabase()
                db.clearDatabase()
                db.getAllStories()
            }.onSuccess {
                _error.emit(true)
            }.onSuccess {
                _stories.emit(it)
            }
        }
    }
}
private fun mockStories(): List<Story> {
    return listOf(
        createStory("1", "Story1"),
        createStory("2", "Story2"),
        createStory("2", "Story2")
    )
}

private fun createStory(id: String, name: String): Story {
    return Story(
        id = id,
        name = name,
        StoryMedia(
            name = "test",
            imgUrl = "uri",
            mimeType = "image/png"
        ),
        slides = emptyList()
    )
}
