package progweb3.poa.ifrs.edu.aula8.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import progweb3.poa.ifrs.edu.aula8.model.Buraquinho;

/**
 * Created by 0724122 on 24/04/2018.
 */

public class BuraquinhoDAO extends SQLiteOpenHelper {

    public BuraquinhoDAO(Context context) {
        super(context, "SeuBuraquinho", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCriacao = "CREATE TABLE buraquinho(" +
                "id INTEGER PRIMARY KEY, " +
                "endereco TEXT NOT NULL," +
                "numero INTEGER NOT NULL" +
                "lat TEXT NOT NULL" +
                "lon TEXT NOT NULL" +
                "descricao TEXT" +
                "imagem TEXT);";
        db.execSQL(sqlCriacao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlUpgrade = "DROP TABLE IF EXISTS buraquinho;";
        db.execSQL(sqlUpgrade);
        onCreate(db);
    }

    public void insert(Buraquinho buraquinho) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = carregaDados(buraquinho);
        db.insert("buraquinho", null, dados);
    }

    public List<Buraquinho> listaTodos() {
        String sqlSelect = "SELECT * FROM buraquinho;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sqlSelect, null);

        List<Buraquinho> lista = new ArrayList<Buraquinho>();
        while(c.moveToNext()) {
            Buraquinho buraquinho = new Buraquinho();
            buraquinho.setId(c.getLong(c.getColumnIndex("id")));
            buraquinho.setEndereco(c.getString(c.getColumnIndex("endereco")));
            buraquinho.setNumero(c.getInt(c.getColumnIndex("numero")));
            buraquinho.setLat(c.getString(c.getColumnIndex("lat")));
            buraquinho.setLon(c.getString(c.getColumnIndex("lon")));
            buraquinho.setDescricao(c.getString(c.getColumnIndex("descricao")));
            buraquinho.setImagem(c.getString(c.getColumnIndex("imagem")));

            lista.add(buraquinho);
        }
        c.close();
        return lista;
    }

    @NonNull
    private ContentValues carregaDados(Buraquinho buraquinho) {
        ContentValues dados = new ContentValues();
        dados.put("endereco", buraquinho.getEndereco());
        dados.put("numero", buraquinho.getNumero());
        dados.put("lat", buraquinho.getLat());
        dados.put("lon", buraquinho.getLon());
        dados.put("descricao", buraquinho.getDescricao());
        dados.put("imagem", buraquinho.getImagem());
        return dados;
    }

}
