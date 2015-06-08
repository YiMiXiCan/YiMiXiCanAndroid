package com.nankai.yimixicanandroid.tools;

import java.util.List;
import java.util.Map;

import com.nankai.yimixicanandroid.internet.InternetConfig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private LayoutInflater layoutInflater;
	private Context context;
	List<?extends Map<String, ?>>  data;
	int resource;
	String[] from;
	int[] to;
	
 
	
	public MyAdapter( Context context,
			List<? extends Map<String, ?>> data, int resource, String[] from,
			int[] to) {
		super();
		this.layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		this.context = context;
		this.data = data;
		this.resource = resource;
		this.from = from;
		this.to = to;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		//return position;
		return this.data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView=layoutInflater.inflate(resource, null);
		}
			System.out.println("to[0]"+to[0]);
		    ImageView imageView=(ImageView)convertView.findViewById(to[0]);
		  
		    String path=data.get(position).get(from[0]).toString();
		    System.out.println("path>>>>"+path);
		    String URI = "http://"+InternetConfig.IP+":"+InternetConfig.PORT+"/"+InternetConfig.PROJECT+"/";
		    path=URI+path;
		
		    imageView.setImageBitmap(BitMapImage.getBitmapFromServer(path));
			for(int i=1;i<data.get(position).size()-1;i++){
				System.out.println("to["+i+"]"+to[i]);
				TextView textView=(TextView)convertView.findViewById(to[i]);
				if(textView==null){
					System.out.println("jfhjfr");
				}
				//System.out.println(i+">>>"+data.get(position).get(from[i]).toString());
				textView.setText(data.get(position).get(from[i]).toString());
				System.out.println("hfjd");
			}			
		
		return convertView;
	}

}
