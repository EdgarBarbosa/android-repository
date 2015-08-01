package br.com.edgar.android.layouts;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);
        
        final EditText nomeEditText = (EditText)findViewById (R.id.nome_edit_label );
    	Button botaoMsg = (Button)findViewById(R.id.botao_ver_msg);
    	final TextView mostraMsg=(TextView)	findViewById (R.id.mostrar_msg);
    	botaoMsg.setOnClickListener(new OnClickListener() {
				
    	public void onClick(View v){
    			String nome = nomeEditText.getEditableText().toString();
    			mostraMsg.setText(getString(R.string.hello_message,nome));
    			mostraMsg.setVisibility(View.VISIBLE);}
    	});		
    }

    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
