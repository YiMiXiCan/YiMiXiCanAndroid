package com.nankai.yimixicanandroid.po;
/**
 * 文件名：WaterNeed.java
 * 功能说明：每日需水量
 * 作者：谭米玲
 * 时间：2015-06-06 23:00
 * */
public class WaterNeed {
	private double total;
	private double time1;
	private double time2;
	private double time3;
	private double time4;
	private double time5;
	private double time6;
	private double time7;
	public WaterNeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WaterNeed(double total, double time1, double time2, double time3,
			double time4, double time5, double time6, double time7) {
		super();
		this.total = total;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
		this.time5 = time5;
		this.time6 = time6;
		this.time7 = time7;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * @return the time1
	 */
	public double getTime1() {
		return time1;
	}
	/**
	 * @param time1 the time1 to set
	 */
	public void setTime1(double time1) {
		this.time1 = time1;
	}
	/**
	 * @return the time2
	 */
	public double getTime2() {
		return time2;
	}
	/**
	 * @param time2 the time2 to set
	 */
	public void setTime2(double time2) {
		this.time2 = time2;
	}
	/**
	 * @return the time3
	 */
	public double getTime3() {
		return time3;
	}
	/**
	 * @param time3 the time3 to set
	 */
	public void setTime3(double time3) {
		this.time3 = time3;
	}
	/**
	 * @return the time4
	 */
	public double getTime4() {
		return time4;
	}
	/**
	 * @param time4 the time4 to set
	 */
	public void setTime4(double time4) {
		this.time4 = time4;
	}
	/**
	 * @return the time5
	 */
	public double getTime5() {
		return time5;
	}
	/**
	 * @param time5 the time5 to set
	 */
	public void setTime5(double time5) {
		this.time5 = time5;
	}
	/**
	 * @return the time6
	 */
	public double getTime6() {
		return time6;
	}
	/**
	 * @param time6 the time6 to set
	 */
	public void setTime6(double time6) {
		this.time6 = time6;
	}
	/**
	 * @return the time7
	 */
	public double getTime7() {
		return time7;
	}
	/**
	 * @param time7 the time7 to set
	 */
	public void setTime7(double time7) {
		this.time7 = time7;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WaterNeed [total=" + total + ", time1=" + time1 + ", time2="
				+ time2 + ", time3=" + time3 + ", time4=" + time4 + ", time5="
				+ time5 + ", time6=" + time6 + ", time7=" + time7 + "]";
	}
	

}
