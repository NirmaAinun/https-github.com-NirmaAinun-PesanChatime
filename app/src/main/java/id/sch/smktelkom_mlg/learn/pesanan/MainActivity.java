package id.sch.smktelkom_mlg.learn.pesanan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    Spinner spRasa;
    CheckBox cbS, cbL;
    RadioButton rbB, rbC, rbP, rbR;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        spRasa = (Spinner) findViewById(R.id.spinnerRasa);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        cbL = (CheckBox) findViewById(R.id.checkBoxL);
        rbB = (RadioButton) findViewById(R.id.radioButtonB);
        rbC = (RadioButton) findViewById(R.id.radioButtonC);
        rbP = (RadioButton) findViewById(R.id.radioButtonP);
        rbR = (RadioButton) findViewById(R.id.radioButtonR);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {

        String nama = etNama.getText().toString();
        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else {
            etNama.setText(nama);
        }

        String hasil = "Size                       : \n";
        int startlen = hasil.length();
        if (cbS.isChecked()) hasil += cbS.getText() + "\n";
        if (cbL.isChecked()) hasil += cbL.getText() + "\n";

        String hasil2;
        if (rbB.isChecked()) {
            hasil2 = "Pesanan               : \n" + rbB.getText().toString() + "\n";
        } else if (rbC.isChecked()) {
            hasil2 = "Pesanan              : \n" + rbC.getText().toString() + "\n";
        } else if (rbR.isChecked()) {
            hasil2 = "Pesanan              : \n" + rbR.getText().toString() + "\n";
        } else if (rbP.isChecked()) {
            hasil2 = "Pesanan              : \n" + rbP.getText().toString() + "\n";
        } else {
            hasil2 = "Pesanan               : \nBelum memilih\n";
        }

        String hasil3 = "Harga                      : \n";
        if (cbS.isChecked()) hasil3 += cbS.getText() + " - Rp. 23000\n";
        if (cbL.isChecked()) hasil3 += cbL.getText() + " - Rp. 27000\n";


        tvHasil.setText("Nama Customer  : \n" + nama +
                "\n\nMenu                      : \n" + spRasa.getSelectedItem().toString() +
                "\n\n" + hasil +
                "\n" + hasil2 +
                "\n" + hasil3);
    }
}