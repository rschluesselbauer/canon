package canon.parser.xml.strategy

import canon.extension.toNode
import canon.parser.xml.CanonXmlParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class OverlaysStrategyTest {

    @Test
    fun testParse() {
        val xml = "<overlays id='testId' class='testClass' trigger='testTrigger'>" +
                "<overlay id='testId1' class='testClass' trigger='testTrigger'>" +
                "<text id='testId2' class='testClass'>test</text>" +
                "</overlay></overlays>"
        val parsed = OverlayStrategy().parse(xml.toNode(), HashMap<String, Any?>(), CanonXmlParser()::toRenderables)

        assertNotNull(parsed)
        assertEquals("testId", parsed.id)
        assertEquals("testClass", parsed.`class`)
        assertEquals("testTrigger", parsed.trigger)
        assertEquals(1, parsed.renderables?.size)
    }

}
