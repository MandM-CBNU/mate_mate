package com.example.meetandmeet;
/// 코드 작성자 2020039085 서민정 ///
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

public class EditDialogFragment extends DialogFragment {

    private static final String TAG = "EditDialogFragment";

    public static void newInstance(View.OnClickListener onClickListener) {
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
    public void show(FragmentManager supportFragmentManager, String editDialogFragment) {
    }

    public interface OnInputSelected{
        void sendInput(String input);
    }
    public OnInputSelected mOnInputSelected;

    //widgets
    private EditText dlgEdit1;
    private TextView action_save, action_cancel;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_dialog, container, false);
        action_save = view.findViewById(R.id.action_save);
        action_cancel = view.findViewById(R.id.action_cancel);
        dlgEdit1 = view.findViewById(R.id.dlgEdit1);

        action_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        action_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capturing input.");

                String input = dlgEdit1.getText().toString();
                if(!input.equals("")){
                    mOnInputSelected.sendInput(input);
                }
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }
}