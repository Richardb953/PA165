package cz.fi.muni.pa165.entity;


import cz.fi.muni.pa165.enums.Color;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	  @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Color color;

    @Column
    @Temporal(TemporalType.DATE)
    private Date addedDate;

    public Product() {
    }

    public Product(String name, Color color, Date addedDate) {
        this.name = name;
        this.color = color;
        this.addedDate = addedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;

        return getName().equals(product.getName());

    }

    @Override public int hashCode() {
        return getName().hashCode();
    }
}
