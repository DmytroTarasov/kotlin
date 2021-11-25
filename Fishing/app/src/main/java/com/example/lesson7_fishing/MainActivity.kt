package com.example.lesson7_fishing

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var navView: NavigationView? = null
    private var rcView: RecyclerView ?= null
    private var adapter: MyAdapter ?= null
    private var drawerLayout: DrawerLayout ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)
        rcView = findViewById(R.id.rcView)
        drawerLayout = findViewById(R.id.drawerLayout)

        navView?.setNavigationItemSelectedListener(this) // говорим, что данный navigation view
        // будет использовать item selected listener, this - это текущий класс, именно в нем есть
        // метод onNavigationItemSelected(...)

        var list = ArrayList<ListItem>()

//        list.add(ListItem(R.drawable.som, "Сом", "Описание1"))
//        list.add(ListItem(R.drawable.nalim, "Налим", "Описание2"))
//        list.add(ListItem(R.drawable.shuca, "Щука", "Описание3"))
//        list.add(ListItem(R.drawable.caras, "Карась", "Описание4"))

        list.addAll(fillArrays(resources.getStringArray(R.array.fish), resources.getStringArray(R.array.fish_content),
            getImageId(R.array.fish_image_array))) // сначала массив данных заполняем рыбами
            // (по умолчанию)

        rcView?.hasFixedSize()
        rcView?.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(list, this)

        rcView?.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.id_fish -> {
                Toast.makeText(this, "Id fish", Toast.LENGTH_SHORT).show() //
                // обычный показ сообщения
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish), resources.getStringArray(R.array.fish_content),
                    getImageId(R.array.fish_image_array)))
            }

            R.id.id_na -> {
                Toast.makeText(this, "Id na", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.bait), resources.getStringArray(R.array.bait_content),
                    getImageId(R.array.bait_image_array)))
            }
            R.id.id_sna ->
                Toast.makeText(this, "Id sna", Toast.LENGTH_SHORT).show()
            R.id.id_history ->
                Toast.makeText(this, "Id history", Toast.LENGTH_SHORT).show()
        }

        drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }

    // функция для того, чтобы сформировать массив данных (который хранится в ресурсах)
    fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()

        for (n in titleArray.indices) {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem) // добавляем в массив данных один элемент,
                                        // идем далее по циклу
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray { // images in the xml-file (array.xml) are specified as an images
        // but in program we work with identifiers, so here, in this function, we must get an image id
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        var count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()

        return ids
    }
}