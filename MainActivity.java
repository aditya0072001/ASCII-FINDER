package tripathi.aditya.asciifinder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView value;
    Button ok;
    char ch;
    String h;
    int[] ascii=new int[]{0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        input=(EditText) findViewById(R.id.input);
        ok=(Button)findViewById(R.id.ok);
        value=(TextView)findViewById(R.id.value);

       /* input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_ENTER:
                            InputMethodManager imm =(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            if(imm.isAcceptingText()){
                                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                            }
                    }
                }
                return false;
            }
        });
        */

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h=input.getText().toString();
                if(h.isEmpty()){
                    Toast.makeText(MainActivity.this,"Enter character", Toast.LENGTH_SHORT).show();
                }else{
                    ascii[0]=(int) h.charAt(0);

                    value.setText("ASCII value :"+Arrays.toString(ascii));
                    input.setText("");
                }

            }
        });

    }

}
