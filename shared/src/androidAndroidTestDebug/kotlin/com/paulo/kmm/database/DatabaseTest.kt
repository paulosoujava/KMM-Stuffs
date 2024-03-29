package com.paulo.kmm.database

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.paulo.kmm.models.StoryMedia
import com.paulo.kmm.utils.AndroidMainApp
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var database: Database

    @Before
    fun prepareTest() {
        AndroidMainApp.context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Database(createSqlDriver())
        database.clearDatabase()
    }

    @After
    fun cleanupTest() {
        database.clearDatabase()
    }

    @Test
    fun clearDatabase() {
        assertEquals(0, database.getAllStories().size)
    }

    @Test
    fun getAllStories() {
        val stories = listOf(
            createStory("1", "Story1"),
            createStory("2", "Story2"),
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(2, source.size)
    }

    @Test
    fun insertStories() {
        val stories = listOf(
            createStory("1", "Story1"),
            createStory("2", "Story2"),
            createStory("3", "Story3"),
            createStory("4", "Story4"),
        )
        database.insertStories(stories)
        val source = database.getAllStories()
        assertEquals(4, source.size)
    }

    private fun createStory(
        id: String,
        name: String
    ): com.paulo.kmm.models.Story {
        return com.paulo.kmm.models.Story(
            id = id,
            name = name,
            storyMedia = StoryMedia(
                name = "Test",
                imgUrl = "none",
                mimeType = "image/jpg"
            ),
            slides = emptyList()
        )
    }
}
