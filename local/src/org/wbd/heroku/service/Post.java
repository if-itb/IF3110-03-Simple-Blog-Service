/**
 * Post.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.wbd.heroku.service;

public class Post  implements java.io.Serializable {
    private boolean deleted;

    private java.lang.String id;

    private java.lang.String id_author;

    private java.lang.String judul;

    private java.lang.String konten;

    private boolean published;

    private java.lang.String tanggal;

    public Post() {
    }

    public Post(
           boolean deleted,
           java.lang.String id,
           java.lang.String id_author,
           java.lang.String judul,
           java.lang.String konten,
           boolean published,
           java.lang.String tanggal) {
           this.deleted = deleted;
           this.id = id;
           this.id_author = id_author;
           this.judul = judul;
           this.konten = konten;
           this.published = published;
           this.tanggal = tanggal;
    }


    /**
     * Gets the deleted value for this Post.
     * 
     * @return deleted
     */
    public boolean isDeleted() {
        return deleted;
    }


    /**
     * Sets the deleted value for this Post.
     * 
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
     * Gets the id_author value for this Post.
     * 
     * @return id_author
     */
    public java.lang.String getId_author() {
        return id_author;
    }


    /**
     * Sets the id_author value for this Post.
     * 
     * @param id_author
     */
    public void setId_author(java.lang.String id_author) {
        this.id_author = id_author;
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
     * Gets the published value for this Post.
     * 
     * @return published
     */
    public boolean isPublished() {
        return published;
    }


    /**
     * Sets the published value for this Post.
     * 
     * @param published
     */
    public void setPublished(boolean published) {
        this.published = published;
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
            this.deleted == other.isDeleted() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.id_author==null && other.getId_author()==null) || 
             (this.id_author!=null &&
              this.id_author.equals(other.getId_author()))) &&
            ((this.judul==null && other.getJudul()==null) || 
             (this.judul!=null &&
              this.judul.equals(other.getJudul()))) &&
            ((this.konten==null && other.getKonten()==null) || 
             (this.konten!=null &&
              this.konten.equals(other.getKonten()))) &&
            this.published == other.isPublished() &&
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
        _hashCode += (isDeleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getId_author() != null) {
            _hashCode += getId_author().hashCode();
        }
        if (getJudul() != null) {
            _hashCode += getJudul().hashCode();
        }
        if (getKonten() != null) {
            _hashCode += getKonten().hashCode();
        }
        _hashCode += (isPublished() ? Boolean.TRUE : Boolean.FALSE).hashCode();
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
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.heroku.wbd.org/", "post"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deleted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("id_author");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_author"));
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
        elemField.setFieldName("published");
        elemField.setXmlName(new javax.xml.namespace.QName("", "published"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
