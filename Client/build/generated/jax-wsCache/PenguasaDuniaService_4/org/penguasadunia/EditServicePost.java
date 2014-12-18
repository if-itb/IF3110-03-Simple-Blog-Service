
package org.penguasadunia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editServicePost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editServicePost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_post" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="judul" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "editServicePost", propOrder = {
    "idPost",
    "judul",
    "konten",
    "tanggal"
})
public class EditServicePost {

    @XmlElement(name = "id_post")
    protected String idPost;
    protected String judul;
    protected String konten;
    protected String tanggal;

    /**
     * Gets the value of the idPost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPost() {
        return idPost;
    }

    /**
     * Sets the value of the idPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPost(String value) {
        this.idPost = value;
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
