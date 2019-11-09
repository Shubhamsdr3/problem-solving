package hashtable;

import list.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class follows the chaining
 * method of hashing function.
 */
public class ChainingHashTable {

    /**
     * An array of linked list.
     */
    private LinkedList<StoredEmployee>[] hashtable;

    private ChainingHashTable() {
        // Creating hashtable for chaining.
        hashtable = new LinkedList[10];
        for (int i=0; i< hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredEmployee>(); // We will store a linked list in array.
        }
    }

    private void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    private Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee storedEmployee = null;
        while (listIterator.hasNext()) {
            storedEmployee = listIterator.next();
            if (storedEmployee.key.equals(key)) {
                return storedEmployee.employee;
            }
        }
        // We did not find the key.
        return null;
    }

    private Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> listIterator = hashtable[hashedKey].listIterator();
        StoredEmployee storedEmployee = null;
        int index = -1; // Bcz after first iteration index will be at 0.
        while (listIterator.hasNext()) {
            storedEmployee = listIterator.next();
            index ++;
            if (storedEmployee.key.equals(key)) {
                break;
            }
        }
        // Either we have found the element with given or not.
        if (storedEmployee == null || ! storedEmployee.key.equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return storedEmployee.employee;
        }
    }

    private void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i].isEmpty()) {
                System.out.println("Empty linked list...");
            } else {
                ListIterator<StoredEmployee> listIterator = hashtable[i].listIterator();
                while (listIterator.hasNext()) {
                    System.out.print(listIterator.next().employee);
                    System.out.print("->");
                }
                System.out.println("null");
            }
        }
    }

    private int hashKey(String key) {
//        return key.length() % hashtable.length;

        return Math.abs(key.hashCode()) % hashtable.length; // Dividing by length gives the valid array index.
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Shubham1", "Pandey1");
        Employee employee2 = new Employee("Shubham12", "Pandey2");
        Employee employee3 = new Employee("Shubham12", "Pandey3");
        ChainingHashTable chainingHashTable = new ChainingHashTable();
        chainingHashTable.put(employee1.getFirstName(), employee1);
        chainingHashTable.put(employee2.getFirstName(), employee2);
        chainingHashTable.put(employee3.getFirstName(), employee3);
        chainingHashTable.printHashtable();
        System.out.println("Removing item ============ :"  +chainingHashTable.remove(employee3.getFirstName()));
        chainingHashTable.printHashtable();
        System.out.println("Item found is : " + chainingHashTable.get(employee2.getFirstName()));
    }
}
