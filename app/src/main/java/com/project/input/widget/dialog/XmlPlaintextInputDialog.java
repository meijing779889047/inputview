package com.project.input.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
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
public class XmlPlaintextInputDialog extends DialogFragment   implements View.OnClickListener,InputView.OnTextFinishListener {



    private Activity mActivity;
    private InputView mInputView;
    private TextView  tvSure;
    private String    result;

    public   static XmlPlaintextInputDialog getInstance(){
        XmlPlaintextInputDialog dialog=new XmlPlaintextInputDialog();
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
        View view=View.inflate(mActivity,R.layout.dialog_xml_plaintext_input_layout,null);
        initView(view);
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    private void initView(View view) {
        mInputView= (InputView) view.findViewById(R.id.input);
        mInputView.setOnTextFinishListener(this);
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
        Log.i("mm","1111111111111"+str);
    }
    //输入完成
    @Override
    public void onFinish(String str) {
           result=str;
        Log.i("mm","2222222222222222222"+str);
    }
}
