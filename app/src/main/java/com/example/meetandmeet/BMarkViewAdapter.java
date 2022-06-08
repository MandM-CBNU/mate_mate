package com.example.meetandmeet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BMarkViewAdapter extends RecyclerView.Adapter<BMarkViewAdapter.Holder> {

    private Context context;
    private List<markVO> list1 = new ArrayList<>();

    //생성자: 생성자에서 데이터 리스트 객체 전탈 받음
    public BMarkViewAdapter(Context context, List<markVO>list1) {
        this.context = context;
        this.list1 = list1;
        //어뎁터에서 액티비티 액션을 가져올 때 context가 필요, 어탭터는 context가 없음
        //선택한 액티비티에 대한 context를 가져올때 필요
    }

    //ViweHolder 생성
    //row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View Bcardview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_bookmark_item,parent,false);
        Holder holder = new Holder(Bcardview);
        return holder;
    }

    //만들어진 VIEWHOLDER에 DATA 삽입 LISTVIEW의 GETVIEW와 동일

    @Override
    public void onBindViewHolder(Holder holder, int position){
        //각 위치에 문자열 세팅
        int itemposition = position;

        holder.mark_img.setImageResource(list1.get(itemposition).imgResId);
        holder.mark_name.setText(list1.get(itemposition).name);
        Log.e("BMark","onBindViewHolder"+itemposition);
    }

    //몇개의 데이터를 리스트로 뿌려줘야 하는지 반드시 정의
    @Override
    public int getItemCount() {
        return (list1 != null ? list1.size() : 0);
    }

    // 뷰홀더
    // 이 부분에서 super를 통해 상속을 받았다.
    // 이 RecyclerView 에 뷰 holder 에서 상속을 받아서 거기에 아이템 값을 찾아와야 한다
    //viewHolder는 하나의 view를 보존하는 역할
    public class Holder extends RecyclerView.ViewHolder {
        public ImageView mark_img;
        public TextView mark_name;

        public Holder(View view) {
            super(view);
            mark_img = (ImageView) view.findViewById(R.id.mark_img);
            mark_name = (TextView) view.findViewById(R.id.mark_name);
        }
    }
}
