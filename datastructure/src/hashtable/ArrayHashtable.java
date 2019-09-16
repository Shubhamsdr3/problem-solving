package hashtable;

import list.Employee;

public class ArrayHashtable {

    private StoredEmployee[] hashtable;

    public ArrayHashtable() {
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
    public void putHashed(String key, Employee employee) throws ElementAlreadyExistException {
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
            throw new ElementAlreadyExistException("The element you are trying to insert is alredy exist");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public boolean ifAlreadyExist(int index) {
        return hashtable[index] != null;
    }

    public Employee get(String key) {
        // In Constant time.
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        } else {
           return hashtable[hashedKey].employee;
        }
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
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (stopIndex == hashedKey) {
            return  -1;
        } else {
            return hashedKey;
        }
    }

    public void printHashTable() {
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
        System.out.println(arrayHashtable.get(employee1.getFirstName()));
    }
}
