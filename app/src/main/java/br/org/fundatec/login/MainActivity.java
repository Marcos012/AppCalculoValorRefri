package br.org.fundatec.login;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class MainActivity extends AppCompatActivity {

    private TextView mEdtUser;
    private TextView mEdtPassward;
    private Button mBtnEnter;
    private ImageView mImage;
    private Button mBtnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtUser = (TextView)findViewById(R.id.edtUser);
        mEdtPassward = (TextView)findViewById(R.id.edtPassword);
        mBtnEnter = (Button)findViewById(R.id.btnEnter);
        mImage = (ImageView)findViewById(R.id.image);
        mBtnNew = (Button) findViewById(R.id.btnNew);
        Picasso.with(this).load("http://leninja.com.br/wp-content/uploads/2014/07/caes-aleatorios-8.jpg")
                        .fit().centerCrop()
                        .transform(new CropCircleTransformation())
                        .into(mImage);

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mEdtUser.getText().toString().isEmpty()){
                    YoYo.with(Techniques.Shake).playOn(mEdtUser);
                    mEdtUser.setError("Campo obrigatorio");
                } else{
                String text = "Clicou no botão!!!! \n Usuario : " +
                mEdtUser.getText() + "\n Senha:" + mEdtPassward.getText();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                mImage.setImageResource(R.drawable.sergio_login);
                startActivity(new Intent(MainActivity.this,DetailActivity.class));
                Log.i("fundatec", "Clicou no botao entrar");
                }
            }
        });

        mBtnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CadastroActivity.class));
                Log.i("fundatec", "Clicou no botao cadastar");
            }
        });


    }
}
