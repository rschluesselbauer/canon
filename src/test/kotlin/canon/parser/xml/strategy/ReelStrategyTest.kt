package canon.parser.xml.strategy

import canon.extension.toNode
import canon.parser.xml.CanonXmlParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ReelStrategyTest {

    @Test
    fun testParse() {
        val xml = "<reel id='testId' class='testClass' name='testName'>" +
                "<reelValue id='testId2' class='testClass' value='testValue' valueType='string'></reelValue>" +
                "</reel>"
        val parsed = ReelStrategy().parse(xml.toNode(), HashMap<String, Any?>(), CanonXmlParser()::toRenderables)

        assertNotNull(parsed)
        assertEquals("testId", parsed.id)
        assertEquals("testClass", parsed.`class`)
        assertEquals("testName", parsed.name)
        assertEquals(1, parsed.renderables?.size)
    }

}
