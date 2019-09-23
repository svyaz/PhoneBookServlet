package ru.academits.dao;

import ru.academits.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by Anna on 17.06.2017.
 */
public class ContactDao {
    private List<Contact> contactList = new ArrayList<>();
    private AtomicInteger idSequence = new AtomicInteger(0);

    public ContactDao() {
        Contact contact = new Contact();
        contact.setId(getNewId());
        contact.setFirstName("Иван");
        contact.setLastName("Иванов");
        contact.setPhone("9123456789");
        contactList.add(contact);
    }

    private int getNewId() {
        return idSequence.addAndGet(1);
    }

    public List<Contact> getAllContacts() {
        return contactList;
    }

    public List<Contact> getFilteredContacts(String filterString) {
        return contactList
                .stream()
                .filter(c -> (c.getFirstName().contains(filterString) ||
                        c.getLastName().contains(filterString) ||
                        c.getPhone().contains(filterString)))
                .collect(Collectors.toList());
        //TODO сделать регистронезависимую фильтрацию
    }

    public void add(Contact contact) {
        contact.setId(getNewId());
        contactList.add(contact);
    }

    /**
     * Deletes all contacts in contactList which id contains in specified idsList.
     *
     * @param idsList list of contacts identifier to delete.
     * @return number of deleted contacts.
     */
    public int deleteContacts(List<Integer> idsList) {
        int sizeBefore = contactList.size();

        contactList = contactList.stream()
                .filter(c -> !idsList.contains(c.getId()))
                .collect(Collectors.toList());
        return sizeBefore - contactList.size();
    }
}
