package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_comment;
    private EditText comentarios;
    private String text;
    private static final String KEY_INDEX = "text_comment";
    private static final String KEY_INDEX2 = "btn_comment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comentarios = (EditText) findViewById(R.id.plain_text_input);
        btn_comment = (Button) findViewById(R.id.button);

        // Guardar texto de los comentarios y boton
        if (savedInstanceState != null) {
            text = savedInstanceState.getString(KEY_INDEX);
            comentarios.setText(text);
            btn_comment.setText(savedInstanceState.getString(KEY_INDEX2));
        }

        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Si en el boton pone save cambia el texto y bloquea los comentarios
                if(btn_comment.getText() == "SAVE"){
                    comentarios.setEnabled(false);
                    btn_comment.setText("ADD COMMENT");
                }else{ // Desbloquea los comentarios y cambia el texto del boton
                    comentarios.setEnabled(true);
                    btn_comment.setText("SAVE");
                }
            }
        });

        // Si en el boton NO pone save cambia el texto y bloquea los comentarios
        if(btn_comment.getText() != "SAVE"){
            comentarios.setEnabled(false);
            btn_comment.setText("ADD COMMENT");
        }else{ // Desbloquea los comentarios y cambia el texto del boton
            comentarios.setEnabled(true);
            btn_comment.setText("SAVE");
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Guardar texto de los comentarios
        comentarios = (EditText) findViewById(R.id.plain_text_input);
        savedInstanceState.putString(KEY_INDEX, String.valueOf(comentarios.getText()));

        // Guardar texto del boton
        btn_comment = (Button) findViewById(R.id.button);
        savedInstanceState.putString(KEY_INDEX2, (String) btn_comment.getText());
    }

}