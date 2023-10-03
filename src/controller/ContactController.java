package controller;

import dataAccess.ContactDao;
import java.util.ArrayList;
import java.util.List;
import model.Contact;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class ContactController extends Menu<Contact> {

    static String[] mc = {"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"};
    ContactDao dao;
    List<Contact> lc;

    public ContactController() {
        super("Contact Program", mc);
        dao = new ContactDao();
        lc = new ArrayList<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.println("-------- Add a Contact --------");
                dao.addContact(lc, new Contact());
                break;
            case 2:
                System.out.println("------------------------------------------------ Display all Contact -------------------------------------------");
                dao.displayAll(lc);
                break;
            case 3:
                System.out.println("------- Delete a Contact -------");
                dao.deleteContact(lc, new Contact());
                break;
            case 4:
                System.out.println("Exit!");
                System.exit(0);
            default:
                System.out.println("Choose again.");
                break;
        }
    }
}
