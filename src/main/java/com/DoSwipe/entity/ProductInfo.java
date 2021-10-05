package com.DoSwipe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prodid")
	private int Proid;
	
	@Column(name = "proname")
	private String proName;
	
	@Column(name = "prodisc")
	private String proDisc;
	
	@Column(name = "prodqnt")
	private double prodQnt;
	
	@Column(name = "prodcost")
	private double prodCost;
	
	@Column(name = "prodtotal")
	private double prodTotal;

}
