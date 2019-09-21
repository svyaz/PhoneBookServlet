package ru.academits.coverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ContactsIdsListConverter {
    private Gson gson = new GsonBuilder().create();

    public List<Integer> convertFromJson(String contactsIdsJson) {
        Type type = new TypeToken<List<Integer>>() {}.getType();
        return gson.fromJson(contactsIdsJson, type);
    }
}
