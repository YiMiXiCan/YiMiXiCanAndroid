package com.nankai.yimixicanandroid.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.reflect.Type;

import org.apache.http.NameValuePair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.Habit;
import com.nankai.yimixicanandroid.tools.MyAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

public class ManageDiet extends Activity {
	private List<Map<String, ?>> lstData;
	private ListView lstMessages;
	final int classID=1;//习惯类ID
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_mnglist);
		this.lstMessages = (ListView) this.findViewById(R.id.item);
		this.lstData = fetchData();
		MyAdapter adapter = new MyAdapter(this, this.lstData,
				R.layout.mnglist_item, new String[] { "imgPhoto",
						"habit" }, new int[] {
						R.id.itemimg, R.id.itemtext});
		this.lstMessages.setAdapter(adapter);
		this.lstMessages.setOnItemClickListener(new ItemOcl());
	}
		private List<Map<String, ?>> fetchData() {
			// TODO Auto-generated method stub
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
			List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
			String response = WebAccessUtils.httpRequest("DietHabitServlet", lstNameValuePairs);		
			List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
			Type ListMessages = new TypeToken<ArrayList<Habit>>() {
			}.getType();	
			
			List<Habit> lstVMessages = gson.fromJson(response, ListMessages);			
			for (Habit vMessage : lstVMessages) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("habitid", vMessage.getHibitID());
				item.put("imgPhoto",vMessage.getImgurl());
				item.put("habit", vMessage.getName());
				// 步骤4-7：将创建好的选项对象添加到集合中
				lst.add(item);			
			}
			return lst;
		}
		
		// 步骤6：自定义列表选项单击事件处理
		private class ItemOcl implements AdapterView.OnItemClickListener{
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				// 步骤6-1：使用该方法的position参数获取选中的选项对象并赋值到Map集合中
				Map<String, ?> selectedItem = lstData.get(position);
				// 测试
			//	Toast.makeText(getApplicationContext(), "您选中的是编号为:"+selectedItem.get("mid"), Toast.LENGTH_LONG).show();
			}			
		}
}
