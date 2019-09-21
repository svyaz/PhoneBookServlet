package ru.academits.coverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.academits.service.ContactsDeletion;

public class ContactsDeletionConverter {
    private Gson gson = new GsonBuilder().create();

    public String convertToJson(ContactsDeletion contactsDeletion) {
        return gson.toJson(contactsDeletion);
    }
}
