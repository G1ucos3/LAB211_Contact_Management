package repository;

import java.util.List;
import model.Contact;

/**
 *
 * @author ASUS
 */
public interface IContact {
    public void addContact(List<Contact> lc, Contact contact);
    
    public void displayAll(List<Contact> lc);
    
    public void deleteContact(List<Contact> lc, Contact contact);
}
