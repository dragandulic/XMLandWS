package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="roomtype" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element ref="{http://www.travel.com/accommodation}Accommodation"/&gt;
 *         &lt;element name="january" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="february" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="march" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="april" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="may" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="june" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="july" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="august" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="september" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="october" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="november" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="december" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "id",
    "roomtype",
    "accommodation",
    "january",
    "february",
    "march",
    "april",
    "may",
    "june",
    "july",
    "august",
    "september",
    "october",
    "november",
    "december"
})
@XmlRootElement(name = "PricePlan")
@Entity
public class PricePlan {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    protected long id;
    protected int roomtype;
    @XmlElement(name = "Accommodation", required = true)
    @ManyToOne
   	@JoinColumn(name="accommodation_id")
    protected Accommodation accommodation;
    protected int january;
    protected int february;
    protected int march;
    protected int april;
    protected int may;
    protected int june;
    protected int july;
    protected int august;
    protected int september;
    protected int october;
    protected int november;
    protected int december;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the roomtype property.
     * 
     */
    public int getRoomtype() {
        return roomtype;
    }

    /**
     * Sets the value of the roomtype property.
     * 
     */
    public void setRoomtype(int value) {
        this.roomtype = value;
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

    /**
     * Gets the value of the january property.
     * 
     */
    public int getJanuary() {
        return january;
    }

    /**
     * Sets the value of the january property.
     * 
     */
    public void setJanuary(int value) {
        this.january = value;
    }

    /**
     * Gets the value of the february property.
     * 
     */
    public int getFebruary() {
        return february;
    }

    /**
     * Sets the value of the february property.
     * 
     */
    public void setFebruary(int value) {
        this.february = value;
    }

    /**
     * Gets the value of the march property.
     * 
     */
    public int getMarch() {
        return march;
    }

    /**
     * Sets the value of the march property.
     * 
     */
    public void setMarch(int value) {
        this.march = value;
    }

    /**
     * Gets the value of the april property.
     * 
     */
    public int getApril() {
        return april;
    }

    /**
     * Sets the value of the april property.
     * 
     */
    public void setApril(int value) {
        this.april = value;
    }

    /**
     * Gets the value of the may property.
     * 
     */
    public int getMay() {
        return may;
    }

    /**
     * Sets the value of the may property.
     * 
     */
    public void setMay(int value) {
        this.may = value;
    }

    /**
     * Gets the value of the june property.
     * 
     */
    public int getJune() {
        return june;
    }

    /**
     * Sets the value of the june property.
     * 
     */
    public void setJune(int value) {
        this.june = value;
    }

    /**
     * Gets the value of the july property.
     * 
     */
    public int getJuly() {
        return july;
    }

    /**
     * Sets the value of the july property.
     * 
     */
    public void setJuly(int value) {
        this.july = value;
    }

    /**
     * Gets the value of the august property.
     * 
     */
    public int getAugust() {
        return august;
    }

    /**
     * Sets the value of the august property.
     * 
     */
    public void setAugust(int value) {
        this.august = value;
    }

    /**
     * Gets the value of the september property.
     * 
     */
    public int getSeptember() {
        return september;
    }

    /**
     * Sets the value of the september property.
     * 
     */
    public void setSeptember(int value) {
        this.september = value;
    }

    /**
     * Gets the value of the october property.
     * 
     */
    public int getOctober() {
        return october;
    }

    /**
     * Sets the value of the october property.
     * 
     */
    public void setOctober(int value) {
        this.october = value;
    }

    /**
     * Gets the value of the november property.
     * 
     */
    public int getNovember() {
        return november;
    }

    /**
     * Sets the value of the november property.
     * 
     */
    public void setNovember(int value) {
        this.november = value;
    }

    /**
     * Gets the value of the december property.
     * 
     */
    public int getDecember() {
        return december;
    }

    /**
     * Sets the value of the december property.
     * 
     */
    public void setDecember(int value) {
        this.december = value;
    }

}