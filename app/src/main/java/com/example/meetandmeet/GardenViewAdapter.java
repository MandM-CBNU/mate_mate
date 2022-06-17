package com.example.meetandmeet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class   GardenViewAdapter extends RecyclerView.Adapter<GardenViewAdapter.Holder> {
    /// 코드 작성자 2020069049 이진희 ///
    private Context context;
    private List<itemVO> list = new ArrayList<>();

    //생성자: 생성자에서 데이터 리스트 객체 전탈 받음
    public GardenViewAdapter(Context context, List<itemVO>list) {
        this.context = context;
        this.list = list;
        //어뎁터에서 액티비티 액션을 가져올 때 context가 필요, 어탭터는 context가 없음
        //선택한 액티비티에 대한 context를 가져올때 필요
    }

    //ViweHolder 생성
    //row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cardview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        Holder holder = new Holder(cardview);
        return holder;
    }

    //만들어진 VIEWHOLDER에 DATA 삽입 LISTVIEW의 GETVIEW와 동일

    @Override
    public void onBindViewHolder(Holder holder, int position){
        //각 위치에 문자열 세팅
        int itemposition = position;

        holder.garden_img.setImageResource(list.get(itemposition).imgResId);
        holder.garden_name.setText(list.get(itemposition).name);
        holder.garden_birth.setText(list.get(itemposition).birth);
        holder.garden_phone.setText(list.get(itemposition).phone);
        Log.e("Garden","onBindViewHolder"+itemposition);
    }

    //몇개의 데이터를 리스트로 뿌려줘야 하는지 반드시 정의
    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }

    // 뷰홀더
    // 이 부분에서 super를 통해 상속을 받았다.
    // 이 RecyclerView 에 뷰 holder 에서 상속을 받아서 거기에 아이템 값을 찾아와야 한다
    //viewHolder는 하나의 view를 보존하는 역할
    public class Holder extends RecyclerView.ViewHolder {
        public ImageView garden_img;
        public TextView garden_name;
        public TextView garden_birth;
        public TextView garden_phone;

        public Holder(View view) {
            super(view);
            garden_img = (ImageView) view.findViewById(R.id.garden_img);
            garden_name = (TextView) view.findViewById(R.id.garden_name);
            garden_birth = (TextView) view.findViewById(R.id.garden_birth);
            garden_phone = (TextView) view.findViewById(R.id.garden_phone);
        }
    }
}
