package com.practice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.practice.common.Contact;
import com.practice.common.DatabaseHandler;

import java.util.List;

public class SqliteDBActivty extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_dbactivty);

        DatabaseHandler db = new DatabaseHandler(this);


        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("krishna","9100000000"));
        db.addContact(new Contact("ram", "9199999999"));
        db.addContact(new Contact("john", "9522222222"));
        db.addContact(new Contact("rehman", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        int totalContacts = db.getContactsCount();
        Log.d("SqliteActivity: ", "totalContacts.."+totalContacts);
    }
}
