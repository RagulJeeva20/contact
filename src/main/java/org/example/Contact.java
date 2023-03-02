package org.example;


import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contact
{
    public static void main(String[] args)
    {
        Logger l = Logger.getLogger("tyler");
        Scanner s = new Scanner(System.in);
        LinkedList<Phdirectory> ll = new LinkedList<>();
        int a = 0;
        while (a == 0)
        {
            l.info("enter your choice: \n 1.insert the contact\n 2.Delete a contact \n 3.search the contact \n 4.Display all contact \n others:exit");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    int si = ll.size();
                    l.info("Enter your name:");
                    String name = s.next();
                    l.info("Enter your phone number:");
                    String ph = s.next();
                    l.info("Enter your mail id");
                    String email = s.next();
                    int index = 0;
                    Phdirectory ob = new Phdirectory(name, ph, email);

                    if (si > 0)
                    {
                        for (Phdirectory element : ll)
                        {
                            String phone = element.ph;
                            if (phone.equals(ph))
                            {
                                l.info("phone number should be unique!Tbis number is already entered");
                            }
                            else
                            {
                                index++;
                            }
                        }
                    }

                    if (index==si)
                    {
                        ll.add(ob);
                        l.info("your contact details has been added");
                    }
                    break;
                case 2:
                    if (ll.isEmpty())
                    {
                        l.info("empty directory");
                        break;
                    }
                    else {
                        index = -1;
                        l.info("Enter a phone number to delete");
                        String checknum = s.next();
                        int b = 0;
                        int loop1=0;
                        while (loop==0)
                        {
                            for (Phdirectory element : ll)
                            {
                                index++;
                                if (element.ph.equals(checknum))
                                {
                                    ll.remove(index);
                                    l.info("your contact has been removed");
                                    b++;
                                    loop1++;
                                    break;
                                }
                            }
                            if (b == 0)
                            {
                                l.info("Enter a valid phone number to delete!");
                                break;
                            }

                        }
                    }
                    break;
                case 3:

                    if (ll.isEmpty())
                    {
                        l.info("the phone Directory is empty");
                        break;
                    }
                    else {
                        l.info("Enter the phone number to Search");
                        String searchnum = s.next();
                        int c = 0;
                        int loop=0;
                        while (loop==0)
                        {
                            for (Phdirectory element : ll)
                            {
                                if (element.ph.equals(searchnum))
                                {
                                    l.log(Level.INFO, () -> "Name:" + element.name + "\nPhone Number:" + element.ph + "\nEmail" + element.email);
                                    c++;
                                    loop++;
                                    break;
                                }
                            }
                            if (c == 0) {
                                l.info("Enter the valid number to search!");
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (ll.isEmpty())
                    {
                        l.info("There is no contacts to display");
                    }
                    else
                    {
                        for (Phdirectory element : ll)
                            l.log(Level.INFO, ()->"Name:"+element.name+"\nPhone Number:"+element.ph+"\nEmail:"+element.email);
                    }
                    break;

                default:
                    a++;
                    break;

            }

        }
    }

 
}
