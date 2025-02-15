package canon.parser.xml.strategy

import canon.api.IRenderable
import canon.extension.attrAsText
import canon.model.Text
import org.w3c.dom.Node

class OldTextStrategy : AbstractParseStrategy<Text>() {

    override fun parse(node: Node, context: Map<String, Any?>, factory: (Node, Map<String, Any?>) -> List<IRenderable>): Text {
        val id = node.attrAsText("id")
        val `class` = node.attrAsText("class")

        return Text(id, `class`, node.textContent)
    }
}