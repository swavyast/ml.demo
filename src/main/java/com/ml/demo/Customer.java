package com.ml.demo;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    
    @Id
    @GeneratedValue(generator = "id_generator")
    @GenericGenerator(name="id_generator", strategy = "com.ml.demo.ID_Generator")
    private String id;
    private String name;
    private String email;
    private long phone;
    private String city;
  //  private Cart myCart;
    
    public Customer(String name, String email, long phone, String city) {
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.city = city;
	//this.myCart = myCart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /*
     * public Cart getMyCart() { return myCart; }
     * 
     * public void setMyCart(Cart myCart) { this.myCart = myCart; }
     */

    @Override
    public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", city=" + city
		 + "]";
    }

    class Cart{
	private int itemNo;
	private List<Item> listOfItems;
	private double shippingCharges;
	private double discounts;
	private double totalAmount;
	
	public Cart(int itemNo, List<Item> listOfItems, double shippingCharges, double discounts, double totalAmount) {
	    this.itemNo = itemNo;
	    this.listOfItems = listOfItems;
	    this.shippingCharges = shippingCharges;
	    this.discounts = discounts;
	    this.totalAmount = totalAmount;
	}
	public int getItemNo() {
	    return itemNo;
	}
	public void setItemNo(int itemNo) {
	    this.itemNo = itemNo;
	}
	public List<Item> getListOfItems() {
	    return listOfItems;
	}
	public void setListOfItems(List<Item> listOfItems) {
	    this.listOfItems = listOfItems;
	}
	public double getShippingCharges() {
	    return shippingCharges;
	}
	public void setShippingCharges(double shippingCharges) {
	    this.shippingCharges = shippingCharges;
	}
	public double getDiscounts() {
	    return discounts;
	}
	public void setDiscounts(double discounts) {
	    this.discounts = discounts;
	}
	public double getTotalAmount() {
	    return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
	    this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
	    return "Cart [itemNo=" + itemNo + ", listOfItems=" + listOfItems + ", shippingCharges=" + shippingCharges
		    + ", discounts=" + discounts + ", totalAmount=" + totalAmount + "]";
	}
    }
    
}
