package canon.model

import canon.api.IRenderable
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class TransitionTest {

    @Test
    fun testTransitionMapping() {
        val mapped = Transition("testId", "testClass", "testName","down", "right",
                ArrayList<IRenderable>()).toMap(HashMap<String, Any>())

        assertEquals(3, mapped.size)
        assertEquals("testName", mapped.get("name"))
        assertEquals("down", mapped.get("direction"))
        assertEquals("right", mapped.get("wrapped"))
    }
}