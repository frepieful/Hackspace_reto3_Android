package proyecto.pokemon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import proyecto.pokemon.entity.PokemonEntity;
import proyecto.pokemon.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends Activity {
    private EditText edUsuario;
    private EditText edClave;
    ArrayList<PokemonEntity> listaPokemon;
    private Button btnIngresar;
    boolean ban_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ban_login=false;
        edUsuario=(EditText) findViewById(R.id.edUsuario);
        edClave=(EditText) findViewById(R.id.edClave);
        ApiImplementation.getService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> lista, Response response) {
                listaPokemon=lista;

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i("respuesta","error aqui");
            }
        });
    }

    public void ingresar(View view){
        String usuario, clave;
        usuario=edUsuario.getText().toString();
        clave=edClave.getText().toString();
        for(PokemonEntity p: listaPokemon){
            if(usuario.equals(p.getNombre()) && clave.equals(p.getTipo())){
                ban_login=true;
            }
        }

        if(ban_login==true) {
            //ingresar al sistema
            Intent objIntent=new Intent(this, MainActivity.class);
            objIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(objIntent);
            finish();
        }else{
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        // your code.
        this.finish();
    }
}
