package com.project.input.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.project.input.R;
import com.project.input.widget.InputView;

/**
 * Copyright (C) 2017,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：InputView
 * 类描述： 密码 密文输入框
 * 创建人：Administrator
 * 创建时间：2017/3/17 10:48
 * 修改人：Administrator
 * 修改时间：2017/3/17 10:48
 * 修改备注：
 * Version:  1.0.0
 */
public class PassInputDialog   extends DialogFragment   implements  InputView.OnTextFinishListener{


    private Activity   mActivity;
    private InputView  mInputView;
    private TextView   tvTitle;
    //用于标识是否第一次密码设置完成
    private boolean    isSetPayPasswordSuccess=false;
    //第一次输入的密码
    private String     firstPass="";

    public   static   PassInputDialog  getInstance(){
           PassInputDialog  dialog=new PassInputDialog();
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
        View  view=View.inflate(mActivity,R.layout.dialog_pass_input_layout,null);
        initView(view);
        dialog.setContentView(view);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    /**
     * 初始化组件
     * @param view
     */
    private void initView(View view) {
        mInputView= (InputView) view.findViewById(R.id.input);
        mInputView.setOnTextFinishListener(this);
        tvTitle= (TextView) view.findViewById(R.id.title);
    }

    //输入中
    @Override
    public void inputing(String str) {

    }
    //输入完成
    @Override
    public void onFinish(String str) {
          if(mInputView!=null) {
              if (isSetPayPasswordSuccess) {
                  if(str.equals(firstPass)) {
                      Toast.makeText(mActivity, "设置支付密码为：" + str, Toast.LENGTH_SHORT).show();
                      dismiss();
                  }else{
                      Toast.makeText(mActivity, "两次密码输入不一致，请重新输入确认密码", Toast.LENGTH_SHORT).show();
                      mInputView.clearText();
                  }
              } else {
                  tvTitle.setText("请再次输入支付密码");
                  mInputView.clearText();
                  isSetPayPasswordSuccess=true;
                  firstPass=str;
              }
          }

    }
}
