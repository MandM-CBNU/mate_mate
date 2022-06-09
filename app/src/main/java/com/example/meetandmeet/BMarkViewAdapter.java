package com.example.meetandmeet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BMarkViewAdapter extends RecyclerView.Adapter<BMarkViewAdapter.Holder> {

    private DatabaseReference mDatabase2;
    Friends friend2;
    private Context context;
    private List<markVO> list1 = new ArrayList<>();
    HashMap result;

    //생성자: 생성자에서 데이터 리스트 객체 전탈 받음
    public BMarkViewAdapter(Context context, List<markVO>list1) {
        this.context = context;
        this.list1 = list1;
        //어뎁터에서 액티비티 액션을 가져올 때 context가 필요, 어댑터는 context가 없음
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
        final markVO mark=list1.get(position);

        //각 위치에 문자열 세팅
        int itemposition = position;
        holder.mark_img.setImageResource(list1.get(itemposition).imgResId);
        holder.mark_name.setText(list1.get(itemposition).name);
        holder.mark_id.setText(list1.get(itemposition).hintId);
//        list1.get(itemposition).markbtn=String.valueOf(holder.markbtn.isChecked());
//        holder.markbtn.setChecked(Boolean.parseBoolean(list1.get(itemposition).markbtn));
//        holder.markbtn.setChecked(holder.markbtn.isChecked());
        Log.v("test11111","test: "+Boolean.parseBoolean(list1.get(itemposition).markbtn));
        Log.v("test211111111","test: "+list1.get(itemposition).markbtn);
        Log.v("test31111111","test: "+holder.markbtn.isChecked());

//        holder.markbtn.setChecked(Boolean.parseBoolean(list1.get(itemposition).markbtn));
//        holder.markbtn.setChecked(false);

        mDatabase2 = FirebaseDatabase.getInstance().getReference(); //DatabaseReference의 인스턴스
        holder.markbtn.setOnCheckedChangeListener(null);
        holder.markbtn.setChecked(mark.getSelected());
        holder.markbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
//                list1.get(itemposition).setSelected(true);
                holder.markbtn.setChecked(Boolean.parseBoolean(list1.get(itemposition).markbtn));
//                mark.markbtn="true";
//                holder.markbtn.setChecked(holder.markbtn.isChecked());

                Log.v("test2222","test: "+Boolean.parseBoolean(list1.get(itemposition).markbtn));
                Log.v("test23333333333","test: "+list1.get(itemposition).markbtn);
                Log.v("test24444444444","test: "+holder.markbtn.isChecked());
//                list1.get(itemposition).markbtn=String.valueOf(holder.markbtn.isChecked());
//                holder.markbtn.setChecked(Boolean.parseBoolean(list1.get(itemposition).markbtn));

//                list1.get(itemposition).markbtn=String.valueOf(holder.markbtn.isChecked());

//                list1.get(position).setSelected(isChecked);
//                list1.set(position, new markVO(R.drawable.blankpot, friend2.name, String.valueOf(position+1), friend2.bmark));

                String strText = String.valueOf(holder.markbtn.isChecked());
//                    String strText = markbtn.getText().toString();
                String getId = holder.mark_id.getText().toString();
                result = new HashMap<>();
                result.put("bmark", strText); //키, 값
                writeFriend(getId,strText);
            }
            private void writeFriend(String Id, String bmark) {
//                    Friends friend = new Friends(bmark);
            //데이터 저장
            mDatabase2.child("Friends").child(Id).updateChildren(result)
                    .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
                        @Override
                        public void onSuccess(Void aVoid) {
                            list1.get(itemposition).setSelected(true);
                            Toast.makeText(context.getApplicationContext(), "즐겨찾기를 추가했습니다.", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context.getApplicationContext(),"실패했습니다" , Toast.LENGTH_LONG).show();
                        }
                    });
        }
        });
//        holder.markbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.markbtn.setChecked(holder.markbtn.isChecked());
//                Log.v("test2222","test: "+Boolean.parseBoolean(list1.get(itemposition).markbtn));
//                Log.v("test23333333333","test: "+list1.get(itemposition).markbtn);
//                Log.v("test24444444444","test: "+holder.markbtn.isChecked());
////                list1.get(itemposition).markbtn=String.valueOf(holder.markbtn.isChecked());
////                holder.markbtn.setChecked(Boolean.parseBoolean(list1.get(itemposition).markbtn));
//
//                list1.get(itemposition).markbtn=String.valueOf(holder.markbtn.isChecked());
//
//                String strText = String.valueOf(holder.markbtn.isChecked());
////                    String strText = markbtn.getText().toString();
//                String getId = holder.mark_id.getText().toString();
//                result = new HashMap<>();
//                result.put("bmark", strText); //키, 값
//                writeFriend(getId,strText);
//            }
//
//            private void writeFriend(String Id, String bmark) {
////                    Friends friend = new Friends(bmark);
//                //데이터 저장
//                mDatabase2.child("Friends").child(Id).updateChildren(result)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() { //데이터베이스에 넘어간 이후 처리
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Toast.makeText(context.getApplicationContext(), "즐겨찾기를 추가했습니다.", Toast.LENGTH_LONG).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(context.getApplicationContext(),"실패했습니다" , Toast.LENGTH_LONG).show();
//                            }
//                        });
//            }
//        });

//        mDatabase2.child("Friends").child(String.valueOf(position+1)).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                friend2 = snapshot.getValue(Friends.class);
//
//                Log.v("test","test: "+friend2.getBMark());
//
//                if(holder.markbtn.isChecked()==true){
//                    holder.markbtn.setChecked(true);
//                }
//                else if(holder.markbtn.isChecked()==false){
//
//                    holder.markbtn.setChecked(false);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        Log.e("BMark","onBindViewHolder"+itemposition);

//        // 먼저 체크박스의 리스너를 null로 초기화한다
//        holder.markbtn.setOnCheckedChangeListener(null);
//        // 모델 클래스의 getter로 체크 상태값을 가져온 다음, setter를 통해 이 값을 아이템 안의 체크박스에 set한다
//        holder.markbtn.setChecked(friend1.bmark);
//
//        // 체크박스의 상태값을 알기 위해 리스너 부착
//        holder.markbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
//            {
//                // 여기의 item은 final 키워드를 붙인 모델 클래스의 객체와 동일하다
//                item.setSelected(isChecked);
//            }
//        });

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
        public TextView mark_id;
        public RadioButton markbtn;

        public Holder(View view) {
            super(view);
            mark_img = (ImageView) view.findViewById(R.id.mark_img);
            mark_name = (TextView) view.findViewById(R.id.mark_name);
            mark_id = (TextView) view.findViewById(R.id.mark_id);
            markbtn = (RadioButton) view.findViewById(R.id.markbtn);

        }
    }

}
