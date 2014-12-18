
package org.penguasadunia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for servicePost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="servicePost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="judul" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusDeleted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusPublished" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tanggal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicePost", propOrder = {
    "idAuthor",
    "judul",
    "key",
    "konten",
    "statusDeleted",
    "statusPublished",
    "tanggal"
})
public class ServicePost {

    protected String idAuthor;
    protected String judul;
    protected String key;
    protected String konten;
    protected String statusDeleted;
    protected String statusPublished;
    protected String tanggal;

    /**
     * Gets the value of the idAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAuthor() {
        return idAuthor;
    }

    /**
     * Sets the value of the idAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAuthor(String value) {
        this.idAuthor = value;
    }

    /**
     * Gets the value of the judul property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Sets the value of the judul property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJudul(String value) {
        this.judul = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the konten property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKonten() {
        return konten;
    }

    /**
     * Sets the value of the konten property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKonten(String value) {
        this.konten = value;
    }

    /**
     * Gets the value of the statusDeleted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDeleted() {
        return statusDeleted;
    }

    /**
     * Sets the value of the statusDeleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDeleted(String value) {
        this.statusDeleted = value;
    }

    /**
     * Gets the value of the statusPublished property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusPublished() {
        return statusPublished;
    }

    /**
     * Sets the value of the statusPublished property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusPublished(String value) {
        this.statusPublished = value;
    }

    /**
     * Gets the value of the tanggal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * Sets the value of the tanggal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTanggal(String value) {
        this.tanggal = value;
    }

}
