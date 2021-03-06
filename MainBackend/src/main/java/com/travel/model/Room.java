//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.05 at 11:44:03 PM CEST 
//


package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumberOfBed" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Free" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element ref="{http://www.travel.com/accommodation}Accommodation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
@XmlRootElement(name = "Room", namespace = "http://www.travel.com/room")

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement(name = "Id", namespace = "http://www.travel.com/room")
    protected long id;


    @XmlElement(name = "NumberOfBed", namespace = "http://www.travel.com/room", defaultValue = "2")
    protected int numberOfBed;
    @XmlElement(name = "Free", namespace = "http://www.travel.com/room", defaultValue = "true")
    protected boolean free;
    @XmlElement(name = "Accommodation", required = true)
    @OneToOne
    @JoinColumn(name = "accommodation_id")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    

}
