package br.org.fundatec.login;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mEdtUser;
    private TextView mEdtPassward;
    private Button mBtnEnter;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtUser = (TextView)findViewById(R.id.edtUser);
        mEdtPassward = (TextView)findViewById(R.id.edtPassword);
        mBtnEnter = (Button)findViewById(R.id.btnEnter);
        mImage = (ImageView)findViewById(R.id.image);

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Clicou no botão!!!! \n Usuario : " +
                mEdtUser.getText() + "\n Senha:" + mEdtPassward.getText();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                mImage.setImageResource(R.drawable.sergio_login);
                startActivity(new Intent(MainActivity.this,DetailActivity.class));
            }
        });


    }
}
