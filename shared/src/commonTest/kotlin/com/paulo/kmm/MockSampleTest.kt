package com.paulo.kmm

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.Test
import kotlin.test.assertEquals



class MockSampleTest {

    class Clock{
        fun getCurrentTime(): String = "12:00"
    }

    @Test
    fun sample_mock_test(){
        val clock = mockk<Clock>()
        every { clock.getCurrentTime() } returns "13:00"

        val time = clock.getCurrentTime()
        verify { clock.getCurrentTime() }
        assertEquals("13:00", time)

    }
}