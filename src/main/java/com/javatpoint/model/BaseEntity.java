package com.javatpoint.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.jsf.FacesContextUtils;

@Entity
//defining class name as Table name
@Table(name="BASEENTITY")
public class BaseEntity {
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPglId() {
		return pglid;
	}
	public void setPglId(Integer pglid) {
		this.pglid = pglid;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	public Integer getPglid() {
		return pglid;
	}
	public void setPglid(Integer pglid) {
		this.pglid = pglid;
	}
	public GuideLinesEntity getGuideLinesEntityByBase() {
		return guideLinesEntityByBase;
	}
	public void setGuideLinesEntityByBase(GuideLinesEntity guideLinesEntityByBase) {
		this.guideLinesEntityByBase = guideLinesEntityByBase;
	}
	@Basic
	@Column(insertable = false, updatable = false)
	private Integer pglid;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id", name = "pglid")
	private GuideLinesEntity guideLinesEntityByBase;
	@Column
	private Integer value;

}
