/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 14:24
 */


package ru.belyaev.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@NamedQuery(name = "Product.findMaxHeight", query = "SELECT MAX(height) FROM Product")
@NamedQuery(name = "Product.findMinHeight", query = "SELECT MIN(height) FROM Product")
@NamedQuery(name = "Product.findMaxWidth", query = "SELECT MAX(width) FROM Product")
@NamedQuery(name = "Product.findMinWidth", query = "SELECT MIN(width) FROM Product")
@NamedQuery(name = "Product.findMaxLength", query = "SELECT MAX(length) FROM Product")
@NamedQuery(name = "Product.findMinLength", query = "SELECT MIN(length) FROM Product")
@NamedQuery(name = "Product.findMaxPrice", query = "SELECT MAX(price) FROM Product")
@NamedQuery(name = "Product.findMinPrice", query = "SELECT MIN(price) FROM Product")
@NamedQuery(name = "Product.searchFilters", query = "SELECT p FROM Product p WHERE (p.length between ?1 and ?2) and (p.width between ?3 and ?4) and (p.height between ?5 and ?6) and " +
        "(p.price between ?7 and ?8)")
@NamedQuery(name = "Product.searchFiltersCount", query = "SELECT count(p) FROM Product p WHERE (p.length between ?1 and ?2) and (p.width between ?3 and ?4) and (p.height between ?5 and ?6) and " +
        "(p.price between ?7 and ?8)")
@Entity
@Table(name ="product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private BigDecimal length;

    @Column
    private BigDecimal width;

    @Column
    private BigDecimal height;

    @Column
    private BigDecimal price;

    @Column
    private String status;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private Integer totalCount;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(length, product.length) &&
                Objects.equals(width, product.width) &&
                Objects.equals(height, product.height) &&
                Objects.equals(price, product.price) &&
                Objects.equals(status, product.status) &&
                Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, length, width, height, price, status, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
