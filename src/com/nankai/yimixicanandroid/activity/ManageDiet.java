package com.nankai.yimixicanandroid.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.Habit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ManageDiet extends Activity {
	private List<Map<String, ?>> lstData;
	private ListView lstMessages;
	final int classID=1;//习惯类ID
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_mnglist);
		this.lstMessages = (ListView) this.findViewById(R.id.mnglist_item);
		this.lstData = fetchData();
		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
				R.layout.mnglist_item, new String[] { "imgPhoto",
						"habit" }, new int[] {
						R.id.itemimg, R.id.itemtext});
		this.lstMessages.setAdapter(adapter);
		this.lstMessages.setOnItemClickListener(new ItemOcl());
	}
		private List<Map<String, ?>> fetchData() {
			// TODO Auto-generated method stub
			// 步骤4-1：创建一个空集合对象
			List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
			
			// 步骤4-2：调用方法实现对网络服务的请求
			String response = WebAccessUtils.httpRequest("DietHabitServlet");
			
			// 步骤4-3：设置一个全新的类型Type
			Type ListMessages = new TypeToken<ArrayList<Habit>>() {
			}.getType();
			
			// 步骤4-4：创建并实例化一个Gson对象
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
			// 步骤4-5：解析JSon数据
			List<Habit> lstVMessages = gson.fromJson(response, ListMessages);			
			// 步骤4-6：使用循环遍历集合对象
			for (Habit vMessage : lstVMessages) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("habitid", vMessage.getHibitID());
				item.put("imgPhoto", R.drawable.mng1);
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
