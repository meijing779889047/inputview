package com.project.input;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.project.input.widget.dialog.PassInputDialog;
import com.project.input.widget.dialog.XmlPlaintextInputDialog;
import com.project.input.widget.dialog.PlaintextInputDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.btn_ciphertext)
    Button btnCiphertext;
    @Bind(R.id.btn_plaintext)
    Button btnPlaintext;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    @Bind(R.id.btn_attr)
    Button btnAttr;

    private PassInputDialog mPassInputDialog;

    private PlaintextInputDialog mPlaintextInputDialog;

    private XmlPlaintextInputDialog mPlaintextInput1Dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_ciphertext, R.id.btn_plaintext,R.id.btn_attr})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ciphertext://密文密码设置
                mPassInputDialog = PassInputDialog.getInstance();
                mPassInputDialog.show(getSupportFragmentManager(), "ciphertext");
                break;
            case R.id.btn_plaintext://明文编码输入
                mPlaintextInputDialog = PlaintextInputDialog.getInstance();
                mPlaintextInputDialog.show(getSupportFragmentManager(), "Plaintext");
                break;
            case R.id.btn_attr://通过布局文件设置属性
                mPlaintextInput1Dialog = XmlPlaintextInputDialog.getInstance();
                mPlaintextInput1Dialog.show(getSupportFragmentManager(), "XmlPlaintextInputDialog");
                break;
        }
    }


}
