package hashtable;

import list.Employee;

public class ArrayHashtable {

    private StoredEmployee[] hashtable;

    private ArrayHashtable() {
        // Give it capacity of 10.
        hashtable = new StoredEmployee[10];
    }

    /**
     * Returns an integer from hashed value of key.
     * @param key: To hashed.
     * @return : integer value of key.
     */
    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee) throws ElementAlreadyExistException {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null) {
            // No handling collision.
            throw new ElementAlreadyExistException("The element you are trying to insert is alredy exist");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    /**
     * This method handles the collision with LinearProbing method.
     * @param key : To get the hashvalue.
     * @param employee: to put in array.
     * @throws :  ElementAlreadyExistException
     */
    private void putHashed(String key, Employee employee) throws ElementAlreadyExistException {
        int hashedKey = hashKey(key);
        if (ifAlreadyExist(hashedKey)) {
            // Start looking for the next place.
            int stopIndex = hashedKey;

            if (stopIndex == hashtable.length - 1) {
                hashedKey = 0; // Reached to end of the array.
            } else {
                // Otherwise increment the hashed in linear fashion.
                hashedKey ++;
            }

            while (ifAlreadyExist(hashedKey) && hashedKey != stopIndex) {
                hashedKey =  (hashedKey + 1) % hashtable.length;
            }
        }
        if (hashtable[hashedKey] != null) {
            // No handling collision.
            throw new ElementAlreadyExistException("The element you are trying to insert is already exist");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    private boolean ifAlreadyExist(int index) {
        return hashtable[index] != null;
    }

    private Employee get(String key) {
        // In Constant time.
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        } else {
           return hashtable[hashedKey].employee;
        }
    }

    private Employee remove(String key) throws ElementAlreadyExistException {
        int hashedKey = findKey(key);
        if (hashedKey ==  -1) {
            // No element found with this key.
            return null;
        }
        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] =  null; // This will cause the issue in findKey().
        // To solve the issue in findKey() ,instead of setting the value to null
        // We will solve using Rehashing them.
        StoredEmployee[] oldHashtable = hashtable;
        hashtable = new StoredEmployee[oldHashtable.length];
        for (int i = 0; i< oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                putHashed(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }

        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
            // found the key at the index.
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey ++;
        }

        while (hashedKey != stopIndex
                && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key)) {
            // Dropout to the loop when hashtable[hashedKey] == null.
            // There is a reason that will be using rehashing.
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (stopIndex == hashedKey) {
            return  -1;
        } else {
            return hashedKey;
        }
    }

    private void printHashTable() {
        for (StoredEmployee employee : hashtable) {
            if (employee == null) {
                System.out.println("Empty...");
            } else {
                System.out.println(employee.employee);
            }
        }
    }

    public static void main(String[] args) throws ElementAlreadyExistException {
        Employee employee1 = new Employee("Shubham1", "Pandey1");
        Employee employee2 = new Employee("Shubham12", "Pandey2");
        Employee employee3 = new Employee("Shubham12", "Pandey3");
        ArrayHashtable arrayHashtable = new ArrayHashtable();
        arrayHashtable.putHashed(employee1.getFirstName(), employee1);
        arrayHashtable.putHashed(employee2.getFirstName(), employee2);
        arrayHashtable.putHashed(employee3.getFirstName(), employee3);
        arrayHashtable.printHashTable();
        System.out.println("Removing item ============ :"  +arrayHashtable.remove(employee1.getFirstName()));
        arrayHashtable.printHashTable();
        System.out.println("Item found is : " + arrayHashtable.get(employee3.getFirstName()));
    }
}
