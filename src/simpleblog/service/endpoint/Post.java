/**
 * Post.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package simpleblog.service.endpoint;

public class Post  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String judul;

    private java.lang.String konten;

    private java.lang.String status;

    private java.lang.String tanggal;

    public Post() {
    }

    public Post(
           java.lang.String id,
           java.lang.String judul,
           java.lang.String konten,
           java.lang.String status,
           java.lang.String tanggal) {
           this.id = id;
           this.judul = judul;
           this.konten = konten;
           this.status = status;
           this.tanggal = tanggal;
    }


    /**
     * Gets the id value for this Post.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Post.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the judul value for this Post.
     * 
     * @return judul
     */
    public java.lang.String getJudul() {
        return judul;
    }


    /**
     * Sets the judul value for this Post.
     * 
     * @param judul
     */
    public void setJudul(java.lang.String judul) {
        this.judul = judul;
    }


    /**
     * Gets the konten value for this Post.
     * 
     * @return konten
     */
    public java.lang.String getKonten() {
        return konten;
    }


    /**
     * Sets the konten value for this Post.
     * 
     * @param konten
     */
    public void setKonten(java.lang.String konten) {
        this.konten = konten;
    }


    /**
     * Gets the status value for this Post.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Post.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the tanggal value for this Post.
     * 
     * @return tanggal
     */
    public java.lang.String getTanggal() {
        return tanggal;
    }


    /**
     * Sets the tanggal value for this Post.
     * 
     * @param tanggal
     */
    public void setTanggal(java.lang.String tanggal) {
        this.tanggal = tanggal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Post)) return false;
        Post other = (Post) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.judul==null && other.getJudul()==null) || 
             (this.judul!=null &&
              this.judul.equals(other.getJudul()))) &&
            ((this.konten==null && other.getKonten()==null) || 
             (this.konten!=null &&
              this.konten.equals(other.getKonten()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.tanggal==null && other.getTanggal()==null) || 
             (this.tanggal!=null &&
              this.tanggal.equals(other.getTanggal())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getJudul() != null) {
            _hashCode += getJudul().hashCode();
        }
        if (getKonten() != null) {
            _hashCode += getKonten().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getTanggal() != null) {
            _hashCode += getTanggal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Post.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.service.simpleblog/", "post"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("judul");
        elemField.setXmlName(new javax.xml.namespace.QName("", "judul"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("konten");
        elemField.setXmlName(new javax.xml.namespace.QName("", "konten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tanggal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tanggal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
