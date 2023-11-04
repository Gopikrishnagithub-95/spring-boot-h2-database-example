package com.javatpoint.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//defining class name as Table name
@Table
public class SubRegionEntity {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(insertable = false, updatable = false)
	private Integer regionId;
	
    public RegionalEntity getRegionalEntity() {
		return regionalEntity;
	}
	public void setRegionalEntity(RegionalEntity regionalEntity) {
		this.regionalEntity = regionalEntity;
	}
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "regionId")
	private RegionalEntity regionalEntity;
    
	@Column
	private Integer value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
