package org.izv.omc.concesionario.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.izv.omc.concesionario.R;
import org.izv.omc.concesionario.databinding.ActivityMainBinding;
import org.izv.omc.concesionario.model.Coche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    //Aqui iran todos los coches guardados en la app tras la consulta a la BD
    public static ArrayList<Coche> coches = new ArrayList<>();


    //Tratamos la conexion
    public Connection conexionDB(){
        Connection cnn=null;
        try{
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            //Asignamos los datos de la BD
            cnn = DriverManager.getConnection("jdbc:mysql://146.59.237.189:3306/dam208_omcconcesionario","dam208_omc","dam208omc");


        }catch(Exception e){
            //Mostramos error sí lo hubiese
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return cnn;

    }
    public void obtenerCoches(){
        try{
            //Hacemos la conexion
            Statement stm = conexionDB().createStatement();
            //Obtenemos todos los datos de todos los coches con la consulta SQL
            ResultSet rs = stm.executeQuery("SELECT * FROM coches");

            //Mientras haya siguiente
            while(rs.next()){
                //Creamos un objeto coche
                Coche coche = new Coche();
                //Asignamos todos los campos al objeto poniendo la columna correpsondiente y lo guardamos en un array de coches para tenerlo almacenado
                coche.setRef(Integer.parseInt(rs.getString(1)));
                coche.setTitulo(rs.getString(2));
                coche.setCombustible(rs.getString(3));
                coche.setKm(Integer.parseInt(rs.getString(4)));
                coche.setCambio(rs.getString(5));
                coche.setPotencia(Integer.parseInt(rs.getString(6)));
                coche.setNpuertas(Integer.parseInt(rs.getString(7)));
                coche.setColor(rs.getString(8));
                coche.setYear(Integer.parseInt(rs.getString(9)));
                coche.setUrl(rs.getString(10));
                coche.setImagenPrincipal(obtenerImagenes(rs.getString(11))[0]);
                coche.setPrecio(Integer.parseInt(rs.getString(12)));
                coche.setLugar(rs.getString(13));
                coche.setDescr(rs.getString(14));
                coche.setImagenes(obtenerImagenes(rs.getString(11)));

                //Añadimos al array de coche el coche
                coches.add(coche);

                //Lo mostramos con Log.v para comprobar que lo hemos hecho bien
                Log.v("xyzyz", coche.toString());

                //Limpiamos el objeto despues de añadirlo al array por si el siguiente tiene algun
                //campo nulo salga nulo y no el valor del coche anterior
                coche = null;
            }
            //Lo mostramos con Log.v para comprobar que lo hemos hecho bien
            //Log.v("xyzyz", "Array de coches completo: " + coches.toString());
        }catch(Exception e){
            //En caso de error nos lo muestra
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private String[] obtenerImagenes(String imagenes) {
        //Creamos el array
        String[] imagenesSeparadas;

        //Si es nulo o longitud corta
        if(imagenes.isEmpty() || imagenes.length() <=7){
            return new String[]{"https://static.turbosquid.com/Preview/2014/12/25__23_33_08/01.jpgc343e688-6e75-4628-90e0-b3331493f667Zoom.jpg"};
        }

        //Separamos el String de todas las fotos separadas con ';'
        imagenesSeparadas = imagenes.split(";");

        //Devolvemos solo la primera en este caso
        return imagenesSeparadas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //Cambiamos el titulo de la barra
        //getSupportActionBar().setTitle("Concesionario de PMDM");

        obtenerCoches();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nosotros) {
            Intent i = new Intent(this, NosotrosActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}