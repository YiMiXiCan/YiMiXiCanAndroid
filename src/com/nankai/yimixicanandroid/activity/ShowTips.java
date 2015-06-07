package com.nankai.yimixicanandroid.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ShowTips extends Activity {
	private List<Map<String,?>> data;
    private ListView lstMassages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		this.setContentView(R.layout.activity_tipslist);
		lstMassages=(ListView)this.findViewById(R.id.lstMessages);
		data=getdata();

		SimpleAdapter adapter=new SimpleAdapter(this, this.data, R.layout.tipitem_single, new String[]{"tipimg","tiptitle","tiptxt"}, new int[]{R.id.tipimg,R.id.tiptitle,R.id.tiptxt});
		this.lstMassages.setAdapter(adapter);
		this.tipback=(ImageView)this.findViewById(R.id.tlist_back);
		this.tiptohome=(ImageView)this.findViewById(R.id.tlist_to_home);
		this.lstMassages.setOnItemClickListener(new itemocl());
		this.tipback.setOnClickListener(new viewocl());
		this.tiptohome.setOnClickListener(new viewocl());
	}
	  private ImageView tipback,tiptohome;

	private List<Map<String,?>> getdata(){
		
		List<Map<String,?>> lstData=new ArrayList<Map<String,?>>();
		
		int type=this.getIntent().getIntExtra("type",0);
		Map<String,Object>item01=new HashMap<String,Object>();
		Map<String,Object>item02=new HashMap<String,Object>();
		Map<String,Object>item03=new HashMap<String,Object>();
		Map<String,Object>item04=new HashMap<String,Object>();
		Map<String,Object>item05=new HashMap<String,Object>();
		Map<String,Object>item06=new HashMap<String,Object>();
		switch(type){
		case 1:
		item01.put("tipID",101);
		item01.put("tipimg", R.drawable.a101);
		item01.put("tiptitle", "吃鸡蛋的知识");
		item01.put("tiptxt", "在营养学界，鸡蛋一直有“全营养食品”的美称。的确，");
		//�û�2 
		item02.put("tipID",102);
		item02.put("tipimg", R.drawable.a102);
		item02.put("tiptitle", "冬季五种饮食养生小常识");
		item02.put("tiptxt", "冬天万物凋零，所以是一个非常萧瑟的季节。但是");
		item03.put("tipID",103);
		item03.put("tipimg", R.drawable.a103);
		item03.put("tiptitle", "女性常吃水果的好处");
		item03.put("tiptxt", "好处一：苹果中的营养成分及其他植物化学成分有助于抗击癌症");
		item04.put("tipID",104);
		item04.put("tipimg", R.drawable.a104);
		item04.put("tiptitle", "消化不良时哪些食物要少吃");
		item04.put("tiptxt", "胃胀、胃痛、嗳气、反酸、腹胀、腹泻……当你出现这些消化不良的症状时");
		item05.put("tipID",105);
		item05.put("tipimg", R.drawable.a105);
		item05.put("tiptitle", "金桔的营养价值与食疗作用");
		item05.put("tiptxt", "金桔有何营养价值与食疗作用呢?金桔又名金柑，原产我国，");
		item06.put("tipID",106);
		item06.put("tipimg", R.drawable.a112);
		item06.put("tiptitle", "补钙的食物有哪些");
		item06.put("tiptxt", "日常有许多食物可供钙源补充。这里介绍一些富含钙的补钙食品：");
		lstData.add(item01);
		lstData.add(item02);
		lstData.add(item03);
		lstData.add(item04);
		lstData.add(item05);
		lstData.add(item06);
		break;
	case 2:
		item01.put("tipID",201);
		item01.put("tipimg", R.drawable.a201);
		item01.put("tiptitle", "长寿的五大因素");
		item01.put("tiptxt", "导读：众所周知，健康饮食、积极运动和遗传基因堪称长寿三大主因。");
		//�û�2
		item02.put("tipID",202);
		item02.put("tipimg", R.drawable.a202);
		item02.put("tiptitle", "体重自测预知寿命长短");
		item02.put("tiptxt", "遗传性瘦，BMI值很少会低于18,瘦子中有一部分人属于“遗传性瘦”");
		
		item03.put("tipID",203);
		item03.put("tipimg", R.drawable.a203);
		item03.put("tiptitle", "上班族保健养生知识");
		item03.put("tiptxt", "“上班族”是当今社会发展的生力军，他们的身体状况是否健康");
		
		item04.put("tipID",204);
		item04.put("tipimg", R.drawable.a204);
		item04.put("tiptitle", "错误的睡眠习惯对健康的危害");
		item04.put("tiptxt", "一天的疲劳，都靠睡个好觉解除。但一些错误的睡眠习惯，");
		item05.put("tipID",205);
		item05.put("tipimg", R.drawable.a205);
		item05.put("tiptitle", "和体温相近的食物能延缓肠胃老化");
		item05.put("tiptxt", "　“趁热吃”一向是中国人待客的一句客套话，不过");
		item06.put("tipID",206);
		item06.put("tipimg", R.drawable.a206);
		item06.put("tiptitle", "亚健康的症状有哪些，如何避免？");
		item06.put("tiptxt", "现代快节奏的生活，让很多人患了一个叫做‘亚健康’的病症。");
		
		lstData.add(item01);
		lstData.add(item02);
		lstData.add(item03);
		lstData.add(item04);
		lstData.add(item05);
		lstData.add(item06);
		break;
case 3:
	    item01.put("tipID",301);
		item01.put("tipimg", R.drawable.a301);
		item01.put("tiptitle", "白领女性的错误减肥观念");
		item01.put("tiptxt", "不少体态较胖的白领丽人，尽管采取了各种减肥方法，");
		//�û�2
		item02.put("tipID",302);
		item02.put("tipimg", R.drawable.a302);
		item02.put("tiptitle", "5个瘦腿运动加速瘦腿");
		item02.put("tiptxt", "1、刮肝经，洗澡时在大腿内侧根部多做按摩，");
		
		item03.put("tipID",303);
		item03.put("tipimg", R.drawable.a303);
		item03.put("tiptitle", "有氧运动让你加速瘦身");
		item03.put("tiptxt", "在过去很长一段时间里，大家总是习惯于把自己放进合成纤维紧身衣中，");
		
		item04.put("tipID",304);
		item04.put("tipimg", R.drawable.a304);
		item04.put("tiptitle", "能快速减肥的运动有哪些");
		item04.put("tiptxt", "如今，减肥的方法数不胜数，我们尝试了一种又一种，");
		
		item05.put("tipID",305);
		item05.put("tipimg", R.drawable.a305);
		item05.put("tiptitle", "省钱实用的爬楼梯减肥法");
		item05.put("tiptxt", "爬楼梯减肥法省钱实用");
		item06.put("tipID",306);
		item06.put("tipimg", R.drawable.a306);
		item06.put("tiptitle", "缩腹走路减肥法");
		item06.put("tiptxt", "首先要学习“腹式呼吸法”：吸气时，肚皮涨起；呼气时，");
		
		lstData.add(item01);
		lstData.add(item02);
		lstData.add(item03);
		lstData.add(item04);
		lstData.add(item05);
		lstData.add(item06);
		
		break;
case 4:
	item01.put("tipID",401);
	item01.put("tipimg", R.drawable.a401);
	item01.put("tiptitle", "六种情况下洗澡会要命");
	item01.put("tiptxt", "误区：小王每次洗澡的时候都会觉得头晕胸闷，喘不上气，");
	//�û�2
	item02.put("tipID",402);
	item02.put("tipimg", R.drawable.a402);
	item02.put("tiptitle", "三个健康的排便习惯");
	item02.put("tiptxt", "虽然听着不雅，但事实上，重视排便应像重视吃饭一样，");
	
	item03.put("tipID",403);
	item03.put("tipimg", R.drawable.a403);
	item03.put("tiptitle", "染发会给健康埋下隐患");
	item03.put("tiptxt", "临安一名64岁的阿姨，因为经常头晕无力，到杭州求诊");
	
	item04.put("tipID",404);
	item04.put("tipimg", R.drawable.a404);
	item04.put("tiptitle", "如何有效抑制头皮屑");
	item04.put("tiptxt", "中国人头皮健康状况”调查结果显示，10个中国人中有9人正处于");
	
	item05.put("tipID",405);
	item05.put("tipimg", R.drawable.a405);
	item05.put("tiptitle", "如何让牙齿快速美白");
	item05.put("tiptxt", "利用光敏固化技术在牙齿表面覆盖瓷化树脂，安全无痛苦，");
	
	item06.put("tipID",406);
	item06.put("tipimg", R.drawable.a406);
	item06.put("tiptitle", "5个收缩毛孔的健康配方");
	item06.put("tiptxt", "毛孔粗大是困扰我们的重大肌肤问题之一，试过很多具有收缩毛孔作用的");
	
	lstData.add(item01);
	lstData.add(item02);
	lstData.add(item03);
	lstData.add(item04);
	lstData.add(item05);
	lstData.add(item06);
	break;
		}
		
		return lstData;
		
	}
	private class itemocl implements AdapterView.OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			// TODO Auto-generated method stub
			Map<String,?> currentitem=data.get(position);
			int tid=(Integer) currentitem.get("tipID");
			Toast.makeText(getApplicationContext(), "你点击了我"+currentitem.get("tiptitle"),Toast.LENGTH_LONG ).show();
			Intent intent=new Intent();
			intent.putExtra("tid", tid);
			intent.setClass(ShowTips.this, SingleTip.class);
			startActivity(intent);
		}
		
	}
	private class viewocl implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tlist_back:
				Toast.makeText(getApplicationContext(), "返回",Toast.LENGTH_LONG ).show();
				
				intent.setClass(ShowTips.this, ChooseTips.class);
				startActivity(intent);
				break;

			case R.id.tlist_to_home:
				Toast.makeText(getApplicationContext(), "返回主页", Toast.LENGTH_LONG).show();
				
				intent.setClass(ShowTips.this, Main.class);
				startActivity(intent);
				break;
			
			}
		}
}
}

