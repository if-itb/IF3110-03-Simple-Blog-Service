
package org.chamerling.heroku.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteComment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteComment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="postid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteComment", propOrder = {
    "postid",
    "commid"
})
public class DeleteComment {

    protected String postid;
    protected String commid;

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

    /**
     * Gets the value of the commid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommid() {
        return commid;
    }

    /**
     * Sets the value of the commid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommid(String value) {
        this.commid = value;
    }

}
