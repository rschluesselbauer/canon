package canon.parser.xml.validation

import org.xml.sax.SAXException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import javax.xml.validation.Validator

/**
 * XSD schema validator for the gaia markup xml definition.
 *
 * @since 1.0.0
 */
class XmlValidator(xsdStream: InputStream) {

    private val validator: Validator

    init {
        try {
            val factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
            val schema = factory.newSchema(StreamSource(xsdStream))
            this.validator = schema.newValidator()
        } catch (e: SAXException) {
            throw RuntimeException(e)
        }

    }

    /**
     * Validates the given input stream.
     *
     * @param stream the input stream
     * @return boolean
     */
    fun validate(stream: InputStream) {
        validator.validate(StreamSource(stream))
    }

    /**
     * Validates the given markup text.
     *
     * @param markup the markup text
     * @return boolean
     */
    fun validate(markup: String) {
        return validate(markup.byteInputStream(StandardCharsets.UTF_8))
    }


}
