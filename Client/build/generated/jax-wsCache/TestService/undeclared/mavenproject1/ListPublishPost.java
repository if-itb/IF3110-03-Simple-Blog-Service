
package undeclared.mavenproject1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listPublishPost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listPublishPost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="published" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listPublishPost", propOrder = {
    "published"
})
public class ListPublishPost {

    protected boolean published;

    /**
     * Gets the value of the published property.
     * 
     */
    public boolean isPublished() {
        return published;
    }

    /**
     * Sets the value of the published property.
     * 
     */
    public void setPublished(boolean value) {
        this.published = value;
    }

}
