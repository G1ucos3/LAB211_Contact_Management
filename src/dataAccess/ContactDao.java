package dataAccess;

import common.Validate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Contact;
import repository.IContact;

/**
 *
 * @author ASUS
 */
public class ContactDao implements Comparator<Contact> {

    private static ContactDao instance = null;
    private Validate validate = new Validate();

    public static ContactDao Instance() {
        if (instance == null) {
            synchronized (ContactDao.class) {
                if (instance == null) {
                    instance = new ContactDao();
                }

            }
        }
        return instance;
    }

    public void addContact(List<Contact> lc, Contact contact) {
        contact.setID(findID(lc));
        contact.setFullname(validate.checkName("Enter Name"));
        String name = contact.getFullname();
        contact.setFirstname(name);
        contact.setLastname(name);
        contact.setGroup(validate.checkString("Enter Group"));
        contact.setAddress(validate.checkString("Enter Address"));
        contact.setPhone(validate.checkPhone("Enter Phone"));
        lc.add(contact);
        System.out.println("Successful.");
    }

    public void displayAll(List<Contact> lc) {
        if (lc.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        System.out.printf("%-5s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name",
                            "First Name", "Last Name",
                            "Group", "Address", "Phone");
        Collections.sort(lc, new ContactDao());
        for (Contact contact : lc) {
            System.out.println(contact.toString());
        }
    }

    public void deleteContact(List<Contact> lc, Contact contact) {
        if (lc.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        int ID = validate.checkID();
        for (int i = 0; i < lc.size(); i++) {
            if (lc.get(i).getID()== ID) {
                lc.remove(i);
                System.out.println("Successful");
                return;
            }
        }
        System.out.println("Not found!");
    }
    
    private int findID(List<Contact> lc) {
        for (int i = 0; i < lc.size(); i++) {
            if (lc.get(i).getID()!= i + 1) {
                return i + 1;
            }
        }
        return lc.size() + 1;
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        if(o1.getID() > o2.getID()) return 1;
        if(o1.getID() < o2.getID()) return -1;
        return 0;
    }

}
