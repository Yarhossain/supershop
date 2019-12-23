package com.akash.supershop.ui.ShopOwner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqliteHelper extends SQLiteOpenHelper {
    private final String TABLE1="tbl_shopkeper";
    private final String TABLE1_COL1="product_id";
    private final String TABLE1_COL2="product_name";
    private final String TABLE1_COL3="product_category";
    private final String TABLE1_COL4="product_description";
    private final String TABLE1_COL5="product_price";
    public SqliteHelper(@Nullable Context context) {
        super(context, "shopkeeperdb",null, 1);
    }



    public void save(int pro_id,String name, String category, String description, String price){
        ContentValues values = new ContentValues();
        values.put(TABLE1_COL2,name);
        values.put(TABLE1_COL3,category);
        values.put(TABLE1_COL4,description);
        values.put(TABLE1_COL4,price);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE1,null,values);


    }
    public List<Product> getAllStudent()
    {
        List<Product> students=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE1+" ORDER BY "+TABLE1_COL1+" DESC";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while (cursor.moveToNext())
            {
                String id=cursor.getString(cursor.getColumnIndex(TABLE1_COL1));
                String name=cursor.getString(cursor.getColumnIndex(TABLE1_COL2));
                String category=cursor.getString(cursor.getColumnIndex(TABLE1_COL3));
                String description=cursor.getString(cursor.getColumnIndex(TABLE1_COL4));
                String price=cursor.getString(cursor.getColumnIndex(TABLE1_COL5));
                try {
                    Product strings = new Product(Integer.parseInt(id), name, category, description, 600);
                    students.add(strings);
                }catch (Exception e)
                {

                }
            }
        }
        return students;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE "+TABLE1+"("+TABLE1_COL1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+TABLE1_COL2+" VARCHAR(50),"+TABLE1_COL3+" VARCHAR(50),"+TABLE1_COL4+" VARCHAR(50), "+TABLE1_COL5+" INTEGER ) ";
        db.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropqueiry = "DROP TABLE IF EXISTS "+TABLE1;
        db.execSQL(dropqueiry);
        onCreate(db);

    }

    public void delete(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE1,""+TABLE1_COL1+" = ?",new String[]{""+id});
    }
}
