package canon.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BoldTest {

    @Test
    fun testBoldMapping() {
        val mapped = Bold("testId", "testClass", "testText").toMap(HashMap<String, Any>())

        assertEquals(1, mapped.size)
        assertEquals("testText", mapped.get("text"))
    }
}