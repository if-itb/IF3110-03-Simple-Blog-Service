
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for search complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="search">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="katakunci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "search", propOrder = {
    "katakunci"
})
public class Search {

    protected String katakunci;

    /**
     * Gets the value of the katakunci property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKatakunci() {
        return katakunci;
    }

    /**
     * Sets the value of the katakunci property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKatakunci(String value) {
        this.katakunci = value;
    }

}
