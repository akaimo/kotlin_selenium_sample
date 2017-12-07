package code.example

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class HelloWorldTest {
    @Test fun sample() {
        val str = "test"
        println(str)
        assertNotNull(str)
    }
}