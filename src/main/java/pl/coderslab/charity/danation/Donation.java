package pl.coderslab.charity.danation;

import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int quantity;
    @ManyToOne
    private Institution institution;
    @ManyToMany
    private List<Category> category;
    private String street;
    private String city;
    private java.sql.Date pickUpDate;
    private java.sql.Date pickUpTime;
    private String pickUpComment;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}
