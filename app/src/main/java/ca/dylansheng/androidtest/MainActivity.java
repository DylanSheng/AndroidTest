package ca.dylansheng.androidtest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button button1 = (Button) findViewById(R.id.button_1);

/*        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                startActivity(intent);
            }
        });*/

        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", "The Da Vinci Code");
        values.put("author", "Dan Brown");
        values.put("pages", 454);
        values.put("price", 16.96);
        db.insert("book", null, values);
    }
}
