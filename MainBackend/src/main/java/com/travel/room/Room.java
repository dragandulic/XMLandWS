//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.05 at 08:25:37 PM CEST 
//


package com.travel.room;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.travel.accommodation.Accommodation;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumberOfBed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Free" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element ref="{http://www.travel.com/accommodation}Accommodation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numberOfBed",
    "free",
    "accommodation"
})
@XmlRootElement(name = "Room")
public class Room {

    @XmlElement(name = "NumberOfBed", defaultValue = "2")
    protected int numberOfBed;
    @XmlElement(name = "Free", defaultValue = "true")
    protected boolean free;
    @XmlElement(name = "Accommodation", namespace = "http://www.travel.com/accommodation", required = true)
    protected Accommodation accommodation;

    /**
     * Gets the value of the numberOfBed property.
     * 
     */
    public int getNumberOfBed() {
        return numberOfBed;
    }

    /**
     * Sets the value of the numberOfBed property.
     * 
     */
    public void setNumberOfBed(int value) {
        this.numberOfBed = value;
    }

    /**
     * Gets the value of the free property.
     * 
     */
    public boolean isFree() {
        return free;
    }

    /**
     * Sets the value of the free property.
     * 
     */
    public void setFree(boolean value) {
        this.free = value;
    }

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setAccommodation(Accommodation value) {
        this.accommodation = value;
    }

}
