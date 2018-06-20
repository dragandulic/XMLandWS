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
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element ref="{http://www.travel.com/reguser}RegUser"/&gt;
 *         &lt;element ref="{http://www.travel.com/comment}Comment"/&gt;
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
    "rating",
    "regUser",
    "comment"
})
@XmlRootElement(name = "Review", namespace = "http://www.travel.com/review")

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlElement(name = "Id", namespace = "http://www.travel.com/review")
    protected Long id;


    @XmlElement(name = "Rating", namespace = "http://www.travel.com/review", defaultValue = "5")
    protected Long rating;
    @XmlElement(name = "RegUser", namespace = "http://www.travel.com/reguser", required = true)
    @ManyToOne
    @JoinColumn(name = "reg_user_id")
    protected RegUser regUser;
    @XmlElement(name = "Comment", namespace = "http://www.travel.com/comment")
    @OneToOne
    @JoinColumn(name = "comment_id")
    protected Comment comment;
    
   
    @XmlElement(name = "Accommodation", required = true)
    @ManyToOne
   	@JoinColumn(name="accommodation")
    protected Accommodation accommodation;

    /**
     * Gets the value of the rating property.
     * 
     */
   

    /**
     * Gets the value of the regUser property.
     * 
     * @return
     *     possible object is
     *     {@link RegUser }
     *     
     */
    public RegUser getRegUser() {
        return regUser;
    }

    public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * Sets the value of the regUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegUser }
     *     
     */
    public void setRegUser(RegUser value) {
        this.regUser = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link Comment }
     *     
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comment }
     *     
     */
    public void setComment(Comment value) {
        this.comment = value;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
    
    

}
