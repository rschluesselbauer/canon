package canon.model

import canon.api.IRenderable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class EmailTest {

    @Test
    fun testEmailMapping() {
        val mapped = Email("testId", "testClass", "placeHolder", true,
                "testName", "testValue").toMap(HashMap<String, Any>())

        assertEquals(4, mapped.size)
        assertEquals("placeHolder", mapped.get("placeholder"))
        assertEquals(true, mapped.get("required"))
        assertEquals("testName", mapped.get("name"))
        assertEquals("testValue", mapped.get("value"))
    }
}