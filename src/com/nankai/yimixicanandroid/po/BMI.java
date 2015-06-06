package com.nankai.yimixicanandroid.po;
/**
 * 文件名：BMI.java
 * 功能说明：封装身体质量指数信息
 * 作者：谭米玲
 * 时间：2015-06-06 21:00
 * */
public class BMI {
	private double BMINumber;//BMI指数
	private String BMIInformation;//计算反馈信息
	private String Disease;//疾病预警
	public BMI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BMI(double bMINumber, String bMIInformation, String disease) {
		super();
		BMINumber = bMINumber;
		BMIInformation = bMIInformation;
		Disease = disease;
	}
	/**
	 * @return the bMINumber
	 */
	public double getBMINumber() {
		return BMINumber;
	}
	/**
	 * @param bMINumber the bMINumber to set
	 */
	public void setBMINumber(double bMINumber) {
		BMINumber = bMINumber;
	}
	/**
	 * @return the bMIInformation
	 */
	public String getBMIInformation() {
		return BMIInformation;
	}
	/**
	 * @param bMIInformation the bMIInformation to set
	 */
	public void setBMIInformation(String bMIInformation) {
		BMIInformation = bMIInformation;
	}
	/**
	 * @return the disease
	 */
	public String getDisease() {
		return Disease;
	}
	/**
	 * @param disease the disease to set
	 */
	public void setDisease(String disease) {
		Disease = disease;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BMI [BMINumber=" + BMINumber + ", BMIInformation="
				+ BMIInformation + ", Disease=" + Disease + "]";
	}
	
	
}
