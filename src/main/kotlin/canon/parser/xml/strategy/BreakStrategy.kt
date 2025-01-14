package canon.parser.xml.strategy

import canon.api.IRenderable
import canon.extension.attrAsText
import canon.model.Break
import org.w3c.dom.Node

class BreakStrategy : AbstractParseStrategy<Break>() {

    override fun parse(node: Node, context: Map<String, Any?>, factory: (Node, Map<String, Any?>) -> List<IRenderable>): Break {
        val id = node.attrAsText("id")
        val `class` = node.attrAsText("class")

        return Break(id, `class`)
    }
}