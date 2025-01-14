package canon.parser.xml.strategy

import canon.api.IRenderable
import canon.extension.attrAsText
import canon.model.Headline
import org.w3c.dom.Node

class HeadlineStrategy : AbstractParseStrategy<Headline>() {

    override fun parse(node: Node, context: Map<String, Any?>, factory: (Node, Map<String, Any?>) -> List<IRenderable>): Headline {
        val id = node.attrAsText("id")
        val `class` = node.attrAsText("class")

        return Headline(id, `class`, node.textContent)
    }

}
