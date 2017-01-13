
package org.chamerling.heroku.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for post complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="post">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idFirebasePost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="judulPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tanggalPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kontenPost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publishStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cookieOn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "post", propOrder = {
    "idFirebasePost",
    "idPost",
    "judulPost",
    "tanggalPost",
    "kontenPost",
    "publishStatus",
    "cookieOn",
    "konten",
    "tanggal"
})
public class Post {

    protected String idFirebasePost;
    protected int idPost;
    protected String judulPost;
    protected String tanggalPost;
    protected String kontenPost;
    protected int publishStatus;
    protected boolean cookieOn;
    protected String konten;
    protected String tanggal;

    /**
     * Gets the value of the idFirebasePost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFirebasePost() {
        return idFirebasePost;
    }

    /**
     * Sets the value of the idFirebasePost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFirebasePost(String value) {
        this.idFirebasePost = value;
    }

    /**
     * Gets the value of the idPost property.
     * 
     */
    public int getIdPost() {
        return idPost;
    }

    /**
     * Sets the value of the idPost property.
     * 
     */
    public void setIdPost(int value) {
        this.idPost = value;
    }

    /**
     * Gets the value of the judulPost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJudulPost() {
        return judulPost;
    }

    /**
     * Sets the value of the judulPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJudulPost(String value) {
        this.judulPost = value;
    }

    /**
     * Gets the value of the tanggalPost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTanggalPost() {
        return tanggalPost;
    }

    /**
     * Sets the value of the tanggalPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTanggalPost(String value) {
        this.tanggalPost = value;
    }

    /**
     * Gets the value of the kontenPost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKontenPost() {
        return kontenPost;
    }

    /**
     * Sets the value of the kontenPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKontenPost(String value) {
        this.kontenPost = value;
    }

    /**
     * Gets the value of the publishStatus property.
     * 
     */
    public int getPublishStatus() {
        return publishStatus;
    }

    /**
     * Sets the value of the publishStatus property.
     * 
     */
    public void setPublishStatus(int value) {
        this.publishStatus = value;
    }

    /**
     * Gets the value of the cookieOn property.
     * 
     */
    public boolean isCookieOn() {
        return cookieOn;
    }

    /**
     * Sets the value of the cookieOn property.
     * 
     */
    public void setCookieOn(boolean value) {
        this.cookieOn = value;
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
