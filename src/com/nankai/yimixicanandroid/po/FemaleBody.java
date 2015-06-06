package com.nankai.yimixicanandroid.po;
/**
 * 文件名：FemaleBody.java
 * 功能说明：女性身材类
 * 作者：谭米玲
 * 时间：2015-06-06 22:00
 * */
public class FemaleBody {
	private double arm;//臂围
	private double bust;//胸围
	private double waistmin;//腰围下限
	private double waistmax;//腰围上限
	private double hips;//臀围
	private double thigh;//大腿围
	private double lowerLeg;//小腿围
	public FemaleBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FemaleBody(double arm, double bust, double waistmin,
			double waistmax, double hips, double thigh, double lowerLeg) {
		super();
		this.arm = arm;
		this.bust = bust;
		this.waistmin = waistmin;
		this.waistmax = waistmax;
		this.hips = hips;
		this.thigh = thigh;
		this.lowerLeg = lowerLeg;
	}
	/**
	 * @return the arm
	 */
	public double getArm() {
		return arm;
	}
	/**
	 * @param arm the arm to set
	 */
	public void setArm(double arm) {
		this.arm = arm;
	}
	/**
	 * @return the bust
	 */
	public double getBust() {
		return bust;
	}
	/**
	 * @param bust the bust to set
	 */
	public void setBust(double bust) {
		this.bust = bust;
	}
	/**
	 * @return the waistmin
	 */
	public double getWaistmin() {
		return waistmin;
	}
	/**
	 * @param waistmin the waistmin to set
	 */
	public void setWaistmin(double waistmin) {
		this.waistmin = waistmin;
	}
	/**
	 * @return the waistmax
	 */
	public double getWaistmax() {
		return waistmax;
	}
	/**
	 * @param waistmax the waistmax to set
	 */
	public void setWaistmax(double waistmax) {
		this.waistmax = waistmax;
	}
	/**
	 * @return the hips
	 */
	public double getHips() {
		return hips;
	}
	/**
	 * @param hips the hips to set
	 */
	public void setHips(double hips) {
		this.hips = hips;
	}
	/**
	 * @return the thigh
	 */
	public double getThigh() {
		return thigh;
	}
	/**
	 * @param thigh the thigh to set
	 */
	public void setThigh(double thigh) {
		this.thigh = thigh;
	}
	/**
	 * @return the lowerLeg
	 */
	public double getLowerLeg() {
		return lowerLeg;
	}
	/**
	 * @param lowerLeg the lowerLeg to set
	 */
	public void setLowerLeg(double lowerLeg) {
		this.lowerLeg = lowerLeg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FemaleBody [arm=" + arm + ", bust=" + bust + ", waistmin="
				+ waistmin + ", waistmax=" + waistmax + ", hips=" + hips
				+ ", thigh=" + thigh + ", lowerLeg=" + lowerLeg + "]";
	}
		
}
