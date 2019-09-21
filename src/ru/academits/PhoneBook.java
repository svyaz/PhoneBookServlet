package ru.academits;

import ru.academits.coverter.ContactConverter;
import ru.academits.coverter.ContactValidationConverter;
import ru.academits.coverter.ContactsDeletionConverter;
import ru.academits.coverter.ContactsIdsListConverter;
import ru.academits.dao.ContactDao;
import ru.academits.service.ContactService;

/**
 * Created by Anna on 14.06.2017.
 */
public class PhoneBook {

    public static ContactDao contactDao = new ContactDao();

    public static ContactService phoneBookService = new ContactService();

    public static ContactConverter contactConverter = new ContactConverter();

    public static ContactValidationConverter contactValidationConverter = new ContactValidationConverter();

    public static ContactsIdsListConverter contactsIdsListConverter = new ContactsIdsListConverter();

    public static ContactsDeletionConverter contactsDeletionConverter = new ContactsDeletionConverter();
}
