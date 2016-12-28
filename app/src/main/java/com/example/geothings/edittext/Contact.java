package com.example.geothings.edittext;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeoThings on 2016/12/28.
 */

public class Contact {
    private String name;
    private int image;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Contact> generateSampleList(){
        List<Contact> list = new ArrayList<>();
        for(int i=0; i < 30; i++){
            Contact contact = new Contact();
            contact.setName("Name - " + i);
            list.add(contact);
        }
        return list;
    }

    public static List<Contact> getListName(){
        List<Contact> list = new ArrayList<>();
        int[] images = {R.drawable.a1,R.drawable.a2
        };
        for (int i = 0;i<2;i++){
            Contact contact = new Contact();
            contact.setName("aaa"+i);
            contact.setImage(images[i]);
            list.add(contact);
        }
        return list;
    }
}
