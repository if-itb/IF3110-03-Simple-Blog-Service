
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="judul" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tanggal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="konten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusPublikasi" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePost", propOrder = {
    "id",
    "judul",
    "tanggal",
    "konten",
    "statusPublikasi"
})
public class UpdatePost {

    protected Integer id;
    protected String judul;
    protected String tanggal;
    protected String konten;
    protected Integer statusPublikasi;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
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
     * Gets the value of the statusPublikasi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatusPublikasi() {
        return statusPublikasi;
    }

    /**
     * Sets the value of the statusPublikasi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatusPublikasi(Integer value) {
        this.statusPublikasi = value;
    }

}
