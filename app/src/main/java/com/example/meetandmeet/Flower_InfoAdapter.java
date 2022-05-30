package com.example.meetandmeet;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Flower_InfoAdapter extends BaseAdapter {
    Context context;
    private int[] posterID;
    private String[] msgID;


    public Flower_InfoAdapter(Context context,int[] posterID,String[] msgID) {
        this.context = context;
        this.posterID=posterID;
        this.msgID=msgID;

    }

    public int getCount() {
        return posterID.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }



    public View getView(int position, View covertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(400, 600));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);

        imageView.setImageResource(posterID[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView=View.inflate(context, R.layout.flwr_dialog,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.flwr_img);
                ivPoster.setImageResource(posterID[position]);
                ivPoster.setPadding(40,5,5,5);
                TextView tvMsg=(TextView)dialogView.findViewById(R.id.flwr_msg);
                tvMsg.setPadding(40,5,40,5);
                tvMsg.setText(msgID[position]);
                dlg.setTitle("꽃말");
                dlg.setIcon(R.drawable.ic_baseline_local_florist_24);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
        return imageView;
    }

}
