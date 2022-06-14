package com.example.meetandmeet;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.meetandmeet.databinding.TaskListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Item> list;
    private OnItemClickListener listener;
    private Intent intent1;
    private final String packageName = "com.kakao.talk";
    int add=0;
    Context context;



    public interface OnItemClickListener{
        void onClick(View view, int position);
    }


    public RecyclerViewAdapter(ArrayList<Item> list){
        this.list =list;
    }
    public void setListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public Item getItemAt(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskListItemBinding binding = DataBindingUtil.inflate(inflater,R.layout.task_list_item,parent,false);
        context = parent.getContext();

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.binding.nameTv.setText(list.get(position).getName());
        holder.binding.birthdayTV.setText(list.get(position).getBirthday());
        holder.binding.phoneTv.setText(list.get(position).getPhone());
        holder.binding.progressBar.setProgress(list.get(position).getPrograssBar());
        holder.binding.flowerpotIv.setImageResource(list.get(position).getImage());
        holder.binding.waterpotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //한번하고 사라지네 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
                intent1 = context.getPackageManager().getLaunchIntentForPackage(packageName);
                if(position == 0) {
                    add+=5;
                     ((MainActivity)context).startActivity(intent1);
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "1번이 작동중", Toast.LENGTH_SHORT).show();
                    if(holder.binding.progressBar.getProgress() >= 1 && holder.binding.progressBar.getProgress() < 20){
                        holder.binding.flowerpotIv.setImageResource(R.drawable.firstpot);}
                    else if(holder.binding.progressBar.getProgress() >=20  && holder.binding.progressBar.getProgress() < 40){
                        holder.binding.flowerpotIv.setImageResource(R.drawable.secondpot);
                    }
                    else if(holder.binding.progressBar.getProgress() >=40  && holder.binding.progressBar.getProgress() < 60){
                        holder.binding.flowerpotIv.setImageResource(R.drawable.secondpot);
                    }
                    else if(holder.binding.progressBar.getProgress() >=60  && holder.binding.progressBar.getProgress() < 80){
                        holder.binding.flowerpotIv.setImageResource(R.drawable.thirdpot);
                    }
                    else if(holder.binding.progressBar.getProgress() >=80  && holder.binding.progressBar.getProgress() < 100){
                        holder.binding.flowerpotIv.setImageResource(R.drawable.forth_1monthpot);
                    }
                }
                else if(position == 1){
                    add+=5;
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);

                    Toast.makeText(v.getContext(), "2번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==2){
                    add+=5;
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);

                    Toast.makeText(v.getContext(), "3번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==3){
                    add+=5;
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "4번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==4){
                    add+=5;
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "5번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==5){
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "6번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==6){
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "7번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==7){
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "8번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==8){
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "9번이 작동중", Toast.LENGTH_SHORT).show();
                }
                else if(position ==9){
                    holder.binding.progressBar.setProgress(list.get(position).getPrograssBar()+add);
                    Toast.makeText(v.getContext(), "9번이 작동중", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TaskListItemBinding binding;

        public ViewHolder(@NonNull TaskListItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }

}