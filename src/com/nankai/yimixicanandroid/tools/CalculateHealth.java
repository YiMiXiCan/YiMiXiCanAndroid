package com.nankai.yimixicanandroid.tools;
/**
 * 文件名：CalculateHealth.java
 * 功能说明：健康计算,包括：
 * 1.身体质量指数BMI计算
 * 2.女性最佳体型计算
 * 3.人体每日所需能量的计算
 * 4.每日需水量计算
 * 作者：谭米玲
 * 时间：2015-06-06 21:30
 * */
import com.nankai.yimixicanandroid.po.BMI;
import com.nankai.yimixicanandroid.po.CaloryNeed;
import com.nankai.yimixicanandroid.po.WaterNeed;
//身体质量指数BMI计算：体重指数BMI=体重(kg)/身高的平方(㎡)
import com.nankai.yimixicanandroid.po.FemaleBody;
public class CalculateHealth {
	public BMI bmi(double weight,double height)//单位：kg,m
	{
		BMI bmi = new BMI();
		bmi.setBMINumber(weight/height/height);
		double BMINumber=bmi.getBMINumber();
		if(BMINumber<18.5)
		{
			bmi.setBMIInformation("偏瘦了");
			bmi.setDisease("低（其它疾病危险性增加）");
		}
		else if(BMINumber>=18.5&&BMINumber<24)
		{
			bmi.setBMIInformation("这身材真是太让人羡慕了！");
			bmi.setDisease("平均水平");
		}
		else if(BMINumber>=24&&BMINumber<28)
		{
			bmi.setBMIInformation("有点偏胖喔~");
			bmi.setDisease("增加");
		}
		else if(BMINumber>=28)
		{
			bmi.setBMIInformation("啊，太胖了，快与我减肥去吧~");
			bmi.setDisease("严重增加");
		}			
		return bmi;
	}
	
//女性最佳体型计算
	public FemaleBody bestfemale(double height)//单位：cm
	{
		FemaleBody body=new FemaleBody();
		body.setArm(height*0.15*0.3937);
		body.setBust(height*0.53*0.3937);
		body.setWaistmax(height*0.43*0.3937);
		body.setHips(height*0.54*0.3937);
		body.setLowerLeg(height*0.21*0.3937);
		body.setThigh(height*0.26+7.8*0.3937);
		body.setWaistmin(height*0.37*0.3937);
		return body;
	}

//人体每日所需能量的计算
	public CaloryNeed dailycalory(int age,double weight,double height)//单位： ,kg,cm
	{
		CaloryNeed caloryNeed=new CaloryNeed();
		double malecalory= 66+( 13.7*weight ) + ( 5 *height ) - ( 6.8 *age);
		double femalecalory= 655 + ( 9.6 *weight ) + ( 1.8*height) - ( 4.7 *age );
//		几乎不动 Calorie-Calculation = BMR x 1.2
		caloryNeed.setMale1(malecalory*1.2);
		caloryNeed.setFemale1(femalecalory*1.2);
//		稍微运动（每周1-3次）总需 = BMR x 1.375
		caloryNeed.setMale2(malecalory*1.375);
		caloryNeed.setFemale2(femalecalory*1.375);
//		中度运动（每周3-5次）总需 = BMR x 1.55
		caloryNeed.setMale3(malecalory*1.55);
		caloryNeed.setFemale3(femalecalory*1.55);
//		积极运动（每周6-7次）总需 = BMR x 1.725
		caloryNeed.setMale4(malecalory*1.725);
		caloryNeed.setFemale4(femalecalory*1.725);
//		专业运动（2倍运动量）总需 = BMR x 1.9
		caloryNeed.setMale5(malecalory*1.9);
		caloryNeed.setFemale5(femalecalory*1.9);
		return caloryNeed;
	}
	//每日需水量计算
	public WaterNeed dailywater(double weight)//单位：33
	{
		WaterNeed waterNeed=new WaterNeed();
		double totalwater=weight*33;//
		waterNeed.setTotal(totalwater);//每日需水总量
		//喝水分配
		waterNeed.setTime1(totalwater*0.15);//早晨6: 30(*0.15)
		waterNeed.setTime2(totalwater*0.135);//上午8: 30(*0.135)
		waterNeed.setTime3(totalwater*8/55.0);//中午11 : 00 (*8/55)
		waterNeed.setTime4(totalwater*0.135);//下午12: 50(*0.135)
		waterNeed.setTime5(totalwater*0.147);//下午15: 00(*0.147)
		waterNeed.setTime6(totalwater*0.147);//晚上17: 30(*0.147)
		waterNeed.setTime7(totalwater*23/165.0);//夜里22: 00(*23/165)
		return waterNeed;		
	}
	
}
