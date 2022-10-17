package com.siva.my_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.siva.my_library.BookRecViewAdapter;
import com.siva.my_library.Utils;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;   // Initializing Recycler View
    private BookRecViewAdapter adapter;  // Initializing Adapter for the Recycler View(to fetch data)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        adapter = new BookRecViewAdapter(this,"allBooks");
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
//        booksRecView.setLayoutManager(new GridLayoutManager(this, 2)); // spanCount is the number of columns
        booksRecView.setLayoutManager(new LinearLayoutManager(this)); // spanCount is the number of columns

        // Setting the data
//        ArrayList<Book> books = new ArrayList<>();
//        books.add(new Book(1, "Think Like A Monk", "Jay Shetty", 328, "https://images-na.ssl-images-amazon.com/images/I/81s6DUyQCZL.jpg",
//                "Train Your Mind for Peace & Purpose Everyday", "Long Description"));
//        books.add(new Book(2, "You Can Win", "Shiv Khera", 299, "https://smartbaroda.com/wp-content/uploads/2020/05/YOU_CAN_WIN_Shiv_Khera_Revised-Edition_cover-1.png",
//                "Winners don't do different things. They do things differently", "Long Description"));
//        books.add(new Book(3, "Light From Many Lamps", "Lillian Eichler Watson", 352, "https://images-na.ssl-images-amazon.com/images/I/41A3loOh4dL._SX324_BO1,204,203,200_.jpg",
//                "A Treasure of Inspiration", "Long Description"));

        adapter.setBooks(Utils.getInstance(this).getAllBooks());
    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
//    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}