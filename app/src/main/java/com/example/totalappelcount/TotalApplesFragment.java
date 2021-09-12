package com.example.totalappelcount;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {
    private Button mBtnBuy;
    private TextView mTvAppleAvailable;
    private EditText mEtAppleAvailable;
    private FragmentManager fragmentManager;

    private int remainingApple;
    private int totalApple;
    private int boughtApple;
CommunicationListner communicationListner;

    public TotalApplesFragment() {
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);
        this.communicationListner = (CommunicationListner) context;
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    if (getArguments()!=null){
        this.boughtApple = getArguments().getInt("appleToBuy");
        this.totalApple = getArguments().getInt("totalApple");
        remainingApple = this.totalApple -this.boughtApple;

    }
    else{

    }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
    mBtnBuy = view.findViewById(R.id.btnBuyApple);
    mTvAppleAvailable = view.findViewById(R.id.tvAppleAvailable);
    mEtAppleAvailable = view.findViewById(R.id.etEnterApple);

    mTvAppleAvailable.setText(remainingApple+"");
    mTvAppleAvailable.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
         mTvAppleAvailable.setText(s);
         String str = mTvAppleAvailable.getText().toString();
        totalApple = Integer.parseInt(str);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }

    });
    mBtnBuy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
Bundle bundle = new Bundle();
bundle.putInt("totalApple",totalApple);
if (communicationListner!=null && mEtAppleAvailable.getText().toString()!=null ){
    communicationListner.LaunchBuyApplesFragment(bundle);
}
        }
    });
    }


}