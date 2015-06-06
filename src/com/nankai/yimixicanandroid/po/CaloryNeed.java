package com.nankai.yimixicanandroid.po;
/**
 * 文件名：CaloryNeed.java
 * 功能说明：人每日所需卡路里，分男性与女性
 * 作者：谭米玲
 * 时间：2015-06-06 22:00
 * */
public class CaloryNeed {
	//男性按体力运动程度大小需卡路里的级别
	private double male1;
	private double male2;
	private double male3;
	private double male4;
	private double male5;
	//女性按体力运动程度大小需卡路里的级别
	private double female1;
	private double female2;
	private double female3;
	private double female4;
	private double female5;
	public CaloryNeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CaloryNeed(double male1, double male2, double male3, double male4,
			double male5, double female1, double female2, double female3,
			double female4, double female5) {
		super();
		this.male1 = male1;
		this.male2 = male2;
		this.male3 = male3;
		this.male4 = male4;
		this.male5 = male5;
		this.female1 = female1;
		this.female2 = female2;
		this.female3 = female3;
		this.female4 = female4;
		this.female5 = female5;
	}
	/**
	 * @return the male1
	 */
	public double getMale1() {
		return male1;
	}
	/**
	 * @param male1 the male1 to set
	 */
	public void setMale1(double male1) {
		this.male1 = male1;
	}
	/**
	 * @return the male2
	 */
	public double getMale2() {
		return male2;
	}
	/**
	 * @param male2 the male2 to set
	 */
	public void setMale2(double male2) {
		this.male2 = male2;
	}
	/**
	 * @return the male3
	 */
	public double getMale3() {
		return male3;
	}
	/**
	 * @param male3 the male3 to set
	 */
	public void setMale3(double male3) {
		this.male3 = male3;
	}
	/**
	 * @return the male4
	 */
	public double getMale4() {
		return male4;
	}
	/**
	 * @param male4 the male4 to set
	 */
	public void setMale4(double male4) {
		this.male4 = male4;
	}
	/**
	 * @return the male5
	 */
	public double getMale5() {
		return male5;
	}
	/**
	 * @param male5 the male5 to set
	 */
	public void setMale5(double male5) {
		this.male5 = male5;
	}
	/**
	 * @return the female1
	 */
	public double getFemale1() {
		return female1;
	}
	/**
	 * @param female1 the female1 to set
	 */
	public void setFemale1(double female1) {
		this.female1 = female1;
	}
	/**
	 * @return the female2
	 */
	public double getFemale2() {
		return female2;
	}
	/**
	 * @param female2 the female2 to set
	 */
	public void setFemale2(double female2) {
		this.female2 = female2;
	}
	/**
	 * @return the female3
	 */
	public double getFemale3() {
		return female3;
	}
	/**
	 * @param female3 the female3 to set
	 */
	public void setFemale3(double female3) {
		this.female3 = female3;
	}
	/**
	 * @return the female4
	 */
	public double getFemale4() {
		return female4;
	}
	/**
	 * @param female4 the female4 to set
	 */
	public void setFemale4(double female4) {
		this.female4 = female4;
	}
	/**
	 * @return the female5
	 */
	public double getFemale5() {
		return female5;
	}
	/**
	 * @param female5 the female5 to set
	 */
	public void setFemale5(double female5) {
		this.female5 = female5;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CaloryNeed [male1=" + male1 + ", male2=" + male2 + ", male3="
				+ male3 + ", male4=" + male4 + ", male5=" + male5
				+ ", female1=" + female1 + ", female2=" + female2
				+ ", female3=" + female3 + ", female4=" + female4
				+ ", female5=" + female5 + "]";
	}
	
	
}
