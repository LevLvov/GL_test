import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.Optional;

public class RefactoringTask {

    //before
        public ArrayList<Operation> Process(LinkedList<Customer> customers, Optional<Integer> factorOptional) {
            if (customers.size() > 0) {
                ArrayList<Operation> result = new ArrayList<>();

                for (Customer custom: customers)
                {
                    Integer factor = customers.size() * factorOptional.get();
                    Operation operation = new Operation(custom, factor);
                }

                return result;
            } else return null;
        }

        //after
        public ArrayList<Operation> process(LinkedList<Customer> customers, Optional<Integer> factorOptional) {
            ArrayList<Operation> result = null;
            if (customers.size() > 0) {
                result = new ArrayList<>();
        // ми завжди повертаємо пустий ліст? яке відношення він має до циклу?
                modifyCustomers(customers, factorOptional);
            }
            return result;
        }

    private void modifyCustomers(LinkedList<Customer> customers, Optional<Integer> factorOptional) {
        for (Customer custom: customers)
        {
            Integer factor = customers.size() * factorOptional.get();
            new Operation(custom, factor);
        }
    }
}

    }

