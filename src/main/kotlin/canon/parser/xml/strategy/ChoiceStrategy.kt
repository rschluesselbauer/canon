package canon.parser.xml.strategy

import canon.api.IRenderable
import canon.extension.attrAsBoolean
import canon.extension.attrAsText
import canon.model.Choice
import org.w3c.dom.Node

class ChoiceStrategy : AbstractParseStrategy<Choice>() {

    override fun parse(node: Node, context: Map<String, Any?>, factory: (Node, Map<String, Any?>) -> List<IRenderable>): Choice {
        val id = node.attrAsText("id")
        val `class` = node.attrAsText("class")
        val text = node.attrAsText("text")
        val selected = node.attrAsBoolean("selected", false)

        return Choice(id, `class`, text, selected, factory(node, context))
    }
}