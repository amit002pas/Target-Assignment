package com.yodlee.practice.fun;
/***
 * 
 * @author akumar23
 *
 */
public class Battle {
	
	String type;
	int width;
	int height;
	String location_A;
	String location_B;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getLocation_A() {
		return location_A;
	}
	public void setLocation_A(String location_A) {
		this.location_A = location_A;
	}
	public String getLocation_B() {
		return location_B;
	}
	public void setLocation_B(String location_B) {
		this.location_B = location_B;
	}
	@Override
	public String toString() {
		return "Battle [type=" + type + ", width=" + width + ", height="
				+ height + ", location_A=" + location_A + ", location_B="
				+ location_B + "]";
	}
	

}
