package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String instrument;
    private String exchange;
    private String type;
    private String product;
    private String time;
    private int qty;
    private double price;
    private double tradeValue;
    private String orderNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTradeValue() {
		return tradeValue;
	}
	public void setTradeValue(double tradeValue) {
		this.tradeValue = tradeValue;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public File(String instrument, String exchange, String type, String product, String time, int qty,
			double price, double tradeValue, String orderNumber) {
		super();
		
		this.instrument = instrument;
		this.exchange = exchange;
		this.type = type;
		this.product = product;
		this.time = time;
		this.qty = qty;
		this.price = price;
		this.tradeValue = tradeValue;
		this.orderNumber = orderNumber;
	}
    
    public File() {
		// TODO Auto-generated constructor stub
	}
    

    
}
