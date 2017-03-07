package salim3dd.com.popupmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.pop_menu, popup.getMenu());

               /* Menu m = popup.getMenu();
                m.removeItem(R.id.menu_pop_copy);*/

                MenuPopupHelper menuHelper = new MenuPopupHelper(MainActivity.this, (MenuBuilder) popup.getMenu(), view);
                menuHelper.setForceShowIcon(true);
                menuHelper.show();

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                        if (id==R.id.menu_pop_Save){
                            Toast.makeText(MainActivity.this, "Save", Toast.LENGTH_SHORT).show();
                        }

                        if (id==R.id.menu_pop_copy){
                            Toast.makeText(MainActivity.this, "Copy", Toast.LENGTH_SHORT).show();
                        }

                        if (id==R.id.menu_pop_share){
                            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        }


                        return false;
                    }
                });


            }
        });

    }
}
