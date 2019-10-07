package canon.model

import canon.api.IEvaluator
import canon.api.IRenderable
import org.apache.commons.lang3.StringUtils
import kotlin.collections.Map

class Slider(id: String,
             `class`: String,
             val min: Double,
             val max: Double,
             val step: Double,
             val value: Double,
             val name:String,
             val values:String) : AbstractRenderable(id, `class`), IRenderable {

    override fun toMap(context: Map<String, Any>, evaluator: IEvaluator): Map<String, Any> {

        var valuesArray = arrayOf<String>()

        if (StringUtils.isNotEmpty(values)) {
            val values = evaluator.evaluate(values, context)
            valuesArray = StringUtils.split(values, ",")
        }

        return mapOf("name" to evaluator.evaluate(name, context), "min" to min, "max" to max, "step" to step,
                "value" to value, "values" to valuesArray)
    }
}
