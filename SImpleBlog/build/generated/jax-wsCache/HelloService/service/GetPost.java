
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getPost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getPost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="postid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPost", propOrder = {
    "postid"
})
public class GetPost {

    protected String postid;

    /**
     * Gets the value of the postid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostid() {
        return postid;
    }

    /**
     * Sets the value of the postid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostid(String value) {
        this.postid = value;
    }

}
