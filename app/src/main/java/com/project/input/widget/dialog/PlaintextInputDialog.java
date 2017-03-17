package com.project.input.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.input.R;
import com.project.input.widget.InputView;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：InputView
 * 类描述：明文输入框
 * 创建人：Administrator
 * 创建时间：2017/3/17 11:24
 * 修改人：Administrator
 * 修改时间：2017/3/17 11:24
 * 修改备注：
 * Version:  1.0.0
 */
public class PlaintextInputDialog extends DialogFragment   implements View.OnClickListener,InputView.OnTextFinishListener {



    private Activity mActivity;
    private InputView mInputView;
    private TextView  tvSure;
    private String    result;

    public   static   PlaintextInputDialog  getInstance(){
        PlaintextInputDialog  dialog=new PlaintextInputDialog();
        return   dialog;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog  dialog=new Dialog(mActivity, R.style.dialog_style);
        View view=View.inflate(mActivity,R.layout.dialog_plaintext_input_layout,null);
        initView(view);
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    private void initView(View view) {
        mInputView= (InputView) view.findViewById(R.id.input);
        mInputView.setViewLength(7);//设置输入框的长度
        mInputView.segment_line_style(3,R.color.colorPrimary);//设置分割线
        mInputView.isShowText(true);//设置是否明文显示
        mInputView.setBgColor(R.drawable.shape_black_line_white_bg_recentage);//设置输入框的背景色
        mInputView.setTextColor(R.color.black);//设置字体的颜色
        mInputView.setTextSize(12);//设置字体大小
        mInputView.setOnTextFinishListener(this);//设置监听
        tvSure= (TextView) view.findViewById(R.id.submit);
        tvSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                if(TextUtils.isEmpty(result)){
                    Toast.makeText(mActivity, "输入长度不够", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mActivity, "输入的内容："+result, Toast.LENGTH_SHORT).show();
                    dismiss();
                }
                break;
        }
    }
    //输入中
    @Override
    public void inputing(String str) {
           result="";
    }
    //输入完成
    @Override
    public void onFinish(String str) {
           result=str;
    }
}
