package repository;

import dataAccess.ContactDao;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author ASUS
 */
public class ContactRepository implements IContact{
    private List<Contact> lc;
    
    public ContactRepository(){
        this.lc = new ArrayList<>();
    }

    @Override
    public void addContact(List<Contact> lc, Contact contact) {
        ContactDao.Instance().addContact(lc, contact);
    }

    @Override
    public void displayAll(List<Contact> lc) {
        ContactDao.Instance().displayAll(lc);
    }

    @Override
    public void deleteContact(List<Contact> lc, Contact contact) {
        ContactDao.Instance().deleteContact(lc, contact);
    }
    
}
