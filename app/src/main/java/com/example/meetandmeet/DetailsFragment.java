package com.example.meetandmeet;
/// 코드 작성자 2020039085 서민정 ///
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.meetandmeet.databinding.FragmentDetailsBinding;
import com.google.android.gms.common.annotation.NonNullApi;
import com.example.meetandmeet.databinding.FragmentDetailsBinding;
import com.iammert.tileprogressview.TiledProgressView;
import com.skyhope.materialtagview.TagView;

public class DetailsFragment extends Fragment implements EditDialogFragment.OnInputSelected{
    private FragmentDetailsBinding binding;
    Context context;
    TextView nameText,birthText,telText;
    ImageButton modify;
    TiledProgressView pgb; //progress bar
    private static final String TAG = "Flower_DetailFragment";
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);
        //textView에 표시
        nameText  .setText(input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            binding.nameTv.setText(item.getName());
            binding.birthdayTV.setText(item.getBirthday());
            binding.phoneTv.setText(item.getPhone());
            binding.flowerpotIv.setImageResource(item.getImage());
            binding.progressBar.setProgress(item.getPrograssBar());

            TagView tagView1 = (TagView) view.findViewById(R.id.tag_rem);
            TagView tagView2 = (TagView) view.findViewById(R.id.tag_like);
            TagView tagView3 = (TagView) view.findViewById(R.id.tag_hate);
            TagView tagView4 = (TagView) view.findViewById(R.id.tag_ect);

            tagView1.setHint("이 분에 대해 기억해야 될 것은 무엇인가요?");
            tagView2.setHint("이 분이 좋아하시는 것은 무엇인가요?");
            tagView3.setHint("이 분이 싫어하시는 것은 무엇인가요?");
            tagView4.setHint("그 밖에 여러가지 입력해보세요");

            tagView1.addTagLimit(10);
            tagView2.addTagLimit(10);
            tagView3.addTagLimit(10);
            tagView4.addTagLimit(10);

            String[] tagList1 = new String[]{"돼정이", "과일러버", "7/3 동탄"};
            tagView1.setTagList(tagList1);
            String[] tagList2 = new String[]{"떡볶이", "체리", "곱창"};
            tagView2.setTagList(tagList2);
            String[] tagList3 = new String[]{"우유", "비계", "화내기"};
            tagView3.setTagList(tagList3);
            String[] tagList4 = new String[]{"양양여행", "술찌", "코딩"};
            tagView4.setTagList(tagList4);

            /*
            modify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: opening dialog");
//                new EditDialogFragment().show(
//                        getChildFragmentManager(), Flower_DetailFragment.TAG);
                    EditDialogFragment dialog = new EditDialogFragment();
//                dialog.setTargetFragment();
                    dialog.show(getActivity().getSupportFragmentManager(), "EditDialogFragment");
                }
            });

*/

        });
    }
}