package mx.edu.utng.orders;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.orders.adapters.EnglishAdapter;
import mx.edu.utng.orders.model.English;
import mx.edu.utng.orders.sqlite.DBOperations;

public class EnglishActivity extends AppCompatActivity {
    private EditText etValue;
    private EditText etAbbreviation;
    private EditText etSpelling;
    private Button btSave;
    private DBOperations operations;
    private English english = new English();
    private RecyclerView rvEnglish;
    private List<English> englishes =new ArrayList<English>();
    private EnglishAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        //iniciacion de la isntancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        english.setIdEnglish("");


        initComponents();
    }
    private void initComponents(){
        rvEnglish=(RecyclerView)findViewById(R.id.rv_english_list);
        rvEnglish.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvEnglish.setLayoutManager(layoutManeger);
        //
        getEnglish();
        adapter=new EnglishAdapter(englishes);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_delete_english:
                        operations.deleteEnglish(englishes.get(rvEnglish.getChildPosition((View)v.getParent().getParent())).getIdEnglish());
                        getEnglish();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.bt_edit_english:

                        Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_SHORT).show();
                        Cursor c = operations.getEnglishById(englishes.get(
                                rvEnglish.getChildPosition(
                                        (View)v.getParent().getParent())).getIdEnglish());
                        if (c!=null){
                            if (c.moveToFirst()){
                                english = new English(c.getString(1),c.getString(2),c.getString(3),c.getString(4));
                            }
                            etValue.setText(english.getValue());
                            etAbbreviation.setText(english.getAbbreviation());
                            etSpelling.setText(english.getSpelling());
                        }else{
                            Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
        rvEnglish.setAdapter(adapter);

        etValue=(EditText)findViewById(R.id.et_value);
        etAbbreviation=(EditText)findViewById(R.id.et_abbreviation);
        etSpelling=(EditText)findViewById(R.id.et_spelling);

        btSave=(Button)findViewById(R.id.bt_save_english);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!english.getIdEnglish().equals("")){
                    english.setValue(etValue.getText().toString());
                    english.setAbbreviation(etAbbreviation.getText().toString());
                    english.setSpelling(etSpelling.getText().toString());
                    operations.updateEnglish(english);

                }else {
                    english = new English("", etValue.getText().toString(), etAbbreviation.getText().toString(),etSpelling.getText().toString());
                    operations.insertEnglish(english);
                }
                getEnglish();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getEnglish(){
        Cursor c =operations.getEnglish();
        englishes.clear();
        if(c!=null){
            while (c.moveToNext()){
                englishes.add(new English(c.getString(1),c.getString(2),c.getString(3), c.getString(4)));
            }
        }

    }

    private void clearData(){
        etValue.setText("");
        etAbbreviation.setText("");
        etSpelling.setText("");
        english=null;
        english= new English();
        english.setIdEnglish("");
    }
}
