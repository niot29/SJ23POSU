package org.CustomerManager.Controller;


import org.CustomerManager.DBService.AddressDBHandler;
import org.CustomerManager.DBService.CustomerDBHandler;
import org.CustomerManager.Model.Address;
import org.CustomerManager.Model.Customer;
import org.CustomerManager.View.MainCustomerView;
import org.CustomerManager.View.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController implements CustomerControllerInterface {

    public Customer createCustomer() {
        Scanner customerInput = new Scanner(System.in);
        Customer customer = new Customer();
        Address address = new Address();
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        AddressDBHandler addressDBHandler = new AddressDBHandler();

        System.out.println("Input Cunstomer first name: ");
        customer.setFirstName(customerInput.next());
        System.out.println("Input Cunstomer last name: ");
        customer.setLastName(customerInput.next());
        System.out.println("Input Cunstomer Birth date: ");
        customer.setBirthDate(customerInput.next());
        System.out.println("Input Cunstomer phone: ");
        customer.setPhoneNumber(customerInput.next());
        System.out.println(customer);

        System.out.println("========================");
        System.out.println("Input Customer address information: ");
        System.out.println("Input street: ");

        address.setStreet(customerInput.next());
        System.out.println("Input street nr: ");
        address.setStreetnr(customerInput.nextInt());
        System.out.println("Input Postcode: ");
        address.setPostcode(customerInput.next());
        System.out.println("Input City: ");
        address.setCity(customerInput.next());

        //int addressId = addressDBHandler.create(address);
        customer.setAddress(address);
        //int customerId = customerDBHandler.create(customer);
        customerDBHandler.create(customer);

        System.out.println(customer);
        System.out.println(address);

        listAllCustomer();
        return customer;
    }

    public void listAllCustomer() {

        String[] maniMenu = {"Create Customer", "List All Customer", "Create New Consert", "List All Consert", "Exit"};

        Scanner customerInput = new Scanner(System.in);
        MainCustomerView mainCustomerView = new MainCustomerView();
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        AddressDBHandler addressDBHandler = new AddressDBHandler();
        //Customer customer = new Customer();
        //Address address = new Address();
        // Get this infor fram dbHandler
        List<Customer> customerList = customerDBHandler.ListCustomer();

        // Send to View
        mainCustomerView.customerScreen(customerList);

        System.out.println("Input customer id for customer address info (Input 0 for quit): ");
        String choiseImput = customerInput.nextLine();
        int selection = Integer.parseInt(choiseImput);

        AdminController mainView = new AdminController();

        if (selection > 0 && selection <= customerList.size()) {
            // System.out.println("zzzz "  + customerList.get(selection - 1));
            // System.out.println(customerList.get(selection - 1).getAddress().getId());

            List<Address> addressList = new ArrayList<Address>();
            addressList.add(customerList.get(selection - 1).getAddress());
            mainCustomerView.addressScreen(addressList);

            String[] menu = {"Update Customer info", "Delete Customer info", "Exit"};
            MainView customerManageView = new MainView();
            customerManageView.mainScreen(menu);

            String choiseInputIntMenu = customerInput.nextLine();
            int selectionInputIntMenu = Integer.parseInt(choiseInputIntMenu);

            if (selectionInputIntMenu >= menu.length || selectionInputIntMenu == 3) {
                mainView.displayMainMenu(maniMenu);
            } else if (selectionInputIntMenu == 1) {
                // call func for update
                updateCustomer(customerList.get(selection - 1));
            } else if (selectionInputIntMenu == 2) {
                // call func for delete
                deleteCustomer(customerList.get(selection - 1));
            } else {
                mainView.displayMainMenu(maniMenu);
            }

        } else {
            mainView.displayMainMenu(maniMenu);

        }


    }

    @Override
    public void updateCustomer(Customer customer) {
        AdminController adminMainView = new AdminController();
        MainView mainView = new MainView();

        while (true) {
            String[] menu = {"FirstName", "LastName", "BirthDay", "Phone", "Save and Exit"};
            String[] maniMenu = {"Create Customer", "List All Customer", "Create New Consert", "List All Consert", "Exit"};
            System.out.println("====================================================");
            System.out.println("Select the information that you would like to change");
            System.out.println("====================================================");
            mainView.mainScreen(menu);

            Scanner customerInput = new Scanner(System.in);
            Scanner customerChangeInput = new Scanner(System.in);


            String choiseImput = customerInput.nextLine();
            int selection = Integer.parseInt(choiseImput);

            if (menu.length <= selection || selection == 5) {
                adminMainView.displayMainMenu(maniMenu);
            }
            switch (selection) {
                case 1:
                    System.out.println("Change value on object " + menu[selection - 1] + " '" + customer.getFirstName() + "'");
                    choiseImput = customerChangeInput.next();
                    customer.setFirstName(choiseImput);
                    break;
                case 2:
                    System.out.println("Change value on object: " + menu[selection - 1] + " '" + customer.getLastName() + "'");
                    choiseImput = customerChangeInput.next();
                    customer.setLastName(choiseImput);
                    break;
                case 3:
                    System.out.println("Change value on object: " + menu[selection - 1] + " '" + customer.getBirthDate() + "'");
                    choiseImput = customerChangeInput.next();
                    customer.setBirthDate(choiseImput);
                    break;
                case 4:
                    System.out.println("Change value on object: " + menu[selection - 1] + " '" + customer.getPhoneNumber() + "'");
                    choiseImput = customerChangeInput.next();
                    customer.setPhoneNumber(choiseImput);
                    break;
                case 5:
                    CustomerDBHandler customerDBHandler = new CustomerDBHandler();
                    customerDBHandler.updateCustomer(customer);

                    String[] menu1 = {"Create Customer", "List All Customer", "Create New Consert", "List All Consert", "Exit"};
                    adminMainView.displayMainMenu(menu1);
                    break;

                default:
                    break;

            }

        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        System.out.println("deleteCustomer");
        System.out.println("====================================================");
        System.out.println(" Remove the following  customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("====================================================");
        CustomerDBHandler customerDBHandler = new CustomerDBHandler();
        //customerDBHandler.deleteCustomerById(customer.getId);
        listAllCustomer();
    }


}