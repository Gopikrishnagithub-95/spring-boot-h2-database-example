package com.javatpoint.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
//defining class name as Table name
@Table
public class RegionalEntity {
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
	public GuideLinesEntity getGuideLinesEntity() {
		return guideLinesEntity;
	}
	public void setGuideLinesEntity(GuideLinesEntity guideLinesEntity) {
		this.guideLinesEntity = guideLinesEntity;
	}
	@Column
	private Integer pglid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "pglid")
	private GuideLinesEntity guideLinesEntity;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "regionalEntity")
	@Fetch(value = FetchMode.SUBSELECT)
//	@JoinColumn(referencedColumnName = "id", name = "regionId")
	private List<SubRegionEntity> subRegions;
	
	public List<SubRegionEntity> getSubRegions() {
		return subRegions;
	}
	public void setSubRegions(List<SubRegionEntity> subRegions) {
		this.subRegions = subRegions;
	}
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
}
