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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//mark class as an Entity 
@Entity
//defining class name as Table name
@Table(name="GUIDELINES")
public class GuideLinesEntity {
	
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer version;
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "guideLinesEntityByBase")
//	@JoinColumn(referencedColumnName = "id", name = "pglid")
	private List<BaseEntity> base;
	
	public RegionalEntity getRegion() {
		return region;
	}
	public void setRegion(RegionalEntity region) {
		this.region = region;
	}

    @OneToOne(mappedBy = "guideLinesEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private RegionalEntity region;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<BaseEntity> getBase() {
		return base;
	}
	public void setBase(List<BaseEntity> base) {
		this.base = base;
	}

}
