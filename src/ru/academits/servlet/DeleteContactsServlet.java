package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.coverter.ContactsDeletionConverter;
import ru.academits.coverter.ContactsIdsListConverter;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;
import ru.academits.service.ContactsDeletion;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteContactsServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactsIdsListConverter contactsIdsListConverter = PhoneBook.contactsIdsListConverter;
    private ContactsDeletionConverter contactsDeletionConverter = PhoneBook.contactsDeletionConverter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (OutputStream responseStream = resp.getOutputStream()) {
            String contactsIdListJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            List<Integer> contactsIds = contactsIdsListConverter.convertFromJson(contactsIdListJson);
            ContactsDeletion contactsDeletion = phoneBookService.deleteContacts(contactsIds);
            String contactsDeletionJson = contactsDeletionConverter.convertToJson(contactsDeletion);

            responseStream.write(contactsDeletionJson.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
            System.out.println("error in DeleteContactsServlet POST: ");
            e.printStackTrace();
        }
    }
}
