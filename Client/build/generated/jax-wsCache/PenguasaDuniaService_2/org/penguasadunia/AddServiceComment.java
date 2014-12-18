
package org.penguasadunia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addServiceComment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addServiceComment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="komentar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tanggal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_ServicePost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_ServiceUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addServiceComment", propOrder = {
    "serviceUsername",
    "email",
    "komentar",
    "tanggal",
    "idServicePost",
    "idServiceUser",
    "guest"
})
public class AddServiceComment {

    @XmlElement(name = "ServiceUsername")
    protected String serviceUsername;
    protected String email;
    protected String komentar;
    protected String tanggal;
    @XmlElement(name = "id_ServicePost")
    protected String idServicePost;
    @XmlElement(name = "id_ServiceUser")
    protected String idServiceUser;
    protected String guest;

    /**
     * Gets the value of the serviceUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceUsername() {
        return serviceUsername;
    }

    /**
     * Sets the value of the serviceUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceUsername(String value) {
        this.serviceUsername = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the komentar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKomentar() {
        return komentar;
    }

    /**
     * Sets the value of the komentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKomentar(String value) {
        this.komentar = value;
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
     * Gets the value of the idServicePost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdServicePost() {
        return idServicePost;
    }

    /**
     * Sets the value of the idServicePost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdServicePost(String value) {
        this.idServicePost = value;
    }

    /**
     * Gets the value of the idServiceUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdServiceUser() {
        return idServiceUser;
    }

    /**
     * Sets the value of the idServiceUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdServiceUser(String value) {
        this.idServiceUser = value;
    }

    /**
     * Gets the value of the guest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuest() {
        return guest;
    }

    /**
     * Sets the value of the guest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuest(String value) {
        this.guest = value;
    }

}
