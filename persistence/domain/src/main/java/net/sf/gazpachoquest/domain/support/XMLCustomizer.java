package net.sf.gazpachoquest.domain.support;

// See more at http://www.eclipse.org/eclipselink/documentation/2.4/moxy/advanced_concepts002.htm
/**
 * @hidden 
 */
public class XMLCustomizer implements org.eclipse.persistence.oxm.XMLNameTransformer {

    // Use the unqualified class name as our root element name.
    @Override
    public String transformRootElementName(String name) {
        String className = name.substring(name.lastIndexOf('.') + 1);
        char[] characters = className.toCharArray();
        StringBuilder builder = new StringBuilder();
        builder.append(Character.toLowerCase(characters[0]));

        for (int idx = 1; idx < characters.length; idx++) {
            char character = characters[idx];
            if (Character.isUpperCase(character)) {
                builder.append('-');
                builder.append(Character.toLowerCase(character));
            } else {
                builder.append(character);
            }
        }
        return builder.toString();
    }

    // The same algorithm as root element name plus "Type" appended to the end.
    @Override
    public String transformTypeName(String name) {
        return transformRootElementName(name) + "Type";
    }

    // The name will be lower-case with word breaks represented by '-'.
    // Note: A capital letter in the original name represents the start of a new
    // word.
    @Override
    public String transformElementName(String name) {
        StringBuilder strBldr = new StringBuilder();
        for (char character : name.toCharArray()) {
            if (Character.isUpperCase(character)) {
                strBldr.append('-');
                strBldr.append(Character.toLowerCase(character));
            } else {
                strBldr.append(character);
            }
        }
        return strBldr.toString();
    }

    // The original name converted to upper-case.
    @Override
    public String transformAttributeName(String name) {
        return name.toUpperCase();
    }

}
