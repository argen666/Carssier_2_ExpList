package ru.sibek.carssier_2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity {

    // названия компаний (групп)
    String[] groups = new String[] {"Балансировка", "Монтаж колес", "Перебортовка", "Ремонт камер", "Ремонт шин"};

    // названия телефонов (элементов)
    String[] itemsBal = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] itemsMon = new String[] {"Монтаж колеса, 4 шпильки", "Монтаж колеса, 6 шпилек", "Монтаж колеса, джип", "Монтаж колеса, м/автобус", "Мойка колеса"};
    String[] itemsPer = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};
    String[] itemsRemK = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};
    String[] itemsRemS = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};
    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem;

    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>

    // список аттрибутов группы или элемента
    Map<String, String> m;

    ExpandableListView elvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------
        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список аттрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put("groupName", group); // имя компании
            groupData.add(m);
        }

        // список аттрибутов групп для чтения
        String groupFrom[] = new String[] {"groupName"};
        // список ID view-элементов, в которые будет помещены аттрибуты групп
        int groupTo[] = new int[] {R.id.text1};


        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список аттрибутов для каждого элемента
        for (String phone : itemsBal) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone); // название телефона
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : itemsMon) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // создаем коллекцию элементов для третьей группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : itemsPer) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // создаем коллекцию элементов для 4 группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : itemsRemK) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // создаем коллекцию элементов для 5 группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : itemsRemS) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }
        childData.add(childDataItem);

        // список аттрибутов элементов для чтения
        String childFrom[] = new String[] {"phoneName"};
        // список ID view-элементов, в которые будет помещены аттрибуты элементов
        int childTo[] = new int[] {android.R.id.text1};

        DoubleExpandableListAdapter adapter = new DoubleExpandableListAdapter(
                this,
                groupData,
                R.layout.list_item,
                groupFrom,
                groupTo,
                childData,
                R.layout.list_subitem,
                childFrom,
                childTo);
        //--------------------


        // находим список
         elvMain = (ExpandableListView) findViewById(R.id.lvMain);

       /* String[] names = { "Заказы", "Расчеты", "Склад", "Персонал", "Справочники", "Отчеты",
                "Настройки"};
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item,
                R.id.text1, names);*/



        // присваиваем адаптер списку
        elvMain.setAdapter(adapter);

    }

    public void onMyButtonClick(View view) {

                Toast.makeText(MainActivity.this,
                        "Option Button is clicked!", Toast.LENGTH_SHORT).show();

       /* imageButton = (ImageButton) findViewById(R.id.drawer_item_icon2);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(MainActivity.this,
                        "Order In Work Button is clicked!", Toast.LENGTH_SHORT).show();

            }

        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
