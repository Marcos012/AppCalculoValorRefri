package br.org.fundatec.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class CadastroActivity extends AppCompatActivity {

    private Button mBtnSave;
    private EditText mEdtUser;
    private EditText mEdtPassword;
    private EditText mEdtName;
    private EditText mEdtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mBtnSave = (Button)findViewById(R.id.btnSave);
        mEdtUser = (EditText)findViewById(R.id.edtUser);
        mEdtPassword = (EditText)findViewById(R.id.edtSenha);
        mEdtName = (EditText)findViewById(R.id.edtNome);
        mEdtEmail = (EditText)findViewById(R.id.edtEmail);

     mBtnSave.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if( mEdtUser.getText().toString().isEmpty()){
                 YoYo.with(Techniques.Shake).playOn(mEdtUser);
                 mEdtUser.setError("Campo obrigatorio");
             } else if( mEdtPassword.getText().toString().isEmpty()){
                 YoYo.with(Techniques.Shake).playOn(mEdtPassword);
                 mEdtPassword.setError("Campo obrigatorio");
             } else if(mEdtEmail.getText().toString().isEmpty()){
                 YoYo.with(Techniques.Shake).playOn(mEdtEmail);
                 mEdtEmail.setError("Campo obrigatorio");
             } else if(mEdtName.getText().toString().isEmpty()){
                 YoYo.with(Techniques.Shake).playOn(mEdtName);
                 mEdtName.setError("Campo obrigatorio");
             } else {
                 String text = "Cadastro Efetuado!";
                 Toast.makeText(CadastroActivity.this, text, Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(CadastroActivity.this, DetailActivity.class));
                 Log.i("fundatec", "Clicou no botao salvar");
             }
         }
     });
    }
}
