/**
 * Comment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package simpleblog.service.endpoint;

public class Comment  implements java.io.Serializable {
    private java.lang.String email;

    private java.lang.String id;

    private java.lang.String konten;

    private java.lang.String name;

    private java.lang.String postId;

    private java.lang.String tanggal;

    public Comment() {
    }

    public Comment(
           java.lang.String email,
           java.lang.String id,
           java.lang.String konten,
           java.lang.String name,
           java.lang.String postId,
           java.lang.String tanggal) {
           this.email = email;
           this.id = id;
           this.konten = konten;
           this.name = name;
           this.postId = postId;
           this.tanggal = tanggal;
    }


    /**
     * Gets the email value for this Comment.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Comment.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the id value for this Comment.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Comment.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the konten value for this Comment.
     * 
     * @return konten
     */
    public java.lang.String getKonten() {
        return konten;
    }


    /**
     * Sets the konten value for this Comment.
     * 
     * @param konten
     */
    public void setKonten(java.lang.String konten) {
        this.konten = konten;
    }


    /**
     * Gets the name value for this Comment.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Comment.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the postId value for this Comment.
     * 
     * @return postId
     */
    public java.lang.String getPostId() {
        return postId;
    }


    /**
     * Sets the postId value for this Comment.
     * 
     * @param postId
     */
    public void setPostId(java.lang.String postId) {
        this.postId = postId;
    }


    /**
     * Gets the tanggal value for this Comment.
     * 
     * @return tanggal
     */
    public java.lang.String getTanggal() {
        return tanggal;
    }


    /**
     * Sets the tanggal value for this Comment.
     * 
     * @param tanggal
     */
    public void setTanggal(java.lang.String tanggal) {
        this.tanggal = tanggal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Comment)) return false;
        Comment other = (Comment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.konten==null && other.getKonten()==null) || 
             (this.konten!=null &&
              this.konten.equals(other.getKonten()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.postId==null && other.getPostId()==null) || 
             (this.postId!=null &&
              this.postId.equals(other.getPostId()))) &&
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
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getKonten() != null) {
            _hashCode += getKonten().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPostId() != null) {
            _hashCode += getPostId().hashCode();
        }
        if (getTanggal() != null) {
            _hashCode += getTanggal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Comment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.service.simpleblog/", "comment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postId"));
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
