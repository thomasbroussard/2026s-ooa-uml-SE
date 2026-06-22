package fr.epita.bank.scenarios;

import fr.epita.bank.datamodel.Customer;

public class TestScenario {


    public static void main(String[] args) {
        System.out.println("test");

        Customer customer = new Customer();
        customer.setName("Thomas");

        //1. put name = "Thomas", adress = "paris"
        //2. initialize savings account with 500,0€ balance
        //3. set the interest rate to 10% (0.10)
        //4. compute the gain in cas we have reached the "gain" calculation moment.

    }
}
