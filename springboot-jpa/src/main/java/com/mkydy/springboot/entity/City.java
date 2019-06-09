package com.mkydy.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cityId;
	
	private String cityName;
	
	private String cityIntroduce;
	
	public City(int cityId, String cityName, String cityIntroduce) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityIntroduce = cityIntroduce;
    }

    public City(String cityName, String cityIntroduce) {
        this.cityName = cityName;
        this.cityIntroduce = cityIntroduce;
    }

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityIntroduce() {
		return cityIntroduce;
	}

	public void setCityIntroduce(String cityIntroduce) {
		this.cityIntroduce = cityIntroduce;
	}

	public City() {
		
	}
    
    
}
