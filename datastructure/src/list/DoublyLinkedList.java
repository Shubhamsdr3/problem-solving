package list;

public class DoublyLinkedList {

    private EmployeeNode head;

    private EmployeeNode tail;

    private int size;

    private void addToFront(Employee employee) {
        EmployeeNode employeeNode = new EmployeeNode(employee);
        //This will set to null the added element as there won't be any element.
        employeeNode.setNext(head);
        if (head ==  null) {
            // If list is empty.
            tail =  employeeNode;
        } else {
            head.setPrevious(employeeNode);
        }
        head =  employeeNode;
        size ++;
    }

    /**
     * Add the node to the end of the linked list.
     * @param employee : Node to add.
     */
    private void addToEnd(Employee employee){
        EmployeeNode employeeNode = new EmployeeNode(employee);
        // if list is empty
        if (tail == null) {
            tail = employeeNode;
        }else {
            tail.setNext(employeeNode);
            employeeNode.setPrevious(tail);
        }
        // Now new node become the tail.
        tail = employeeNode;
        size ++;
    }

    private EmployeeNode removeFromFront() {
        if (isEmpty()){
            return null;
        }
        //Store the node to be removed(in this case head.)
        EmployeeNode removedNode = head;
        if (head.getNext() == null) {
            //There was single element that we are removing.
            tail = null;
        } else {
            //there are more than one element.
            head.getNext().setPrevious(null); // i.e set head to null.
        }
        //Head will now the next to head element.
        head = head.getNext();
        size --;
        removedNode.setNext(null); // let GC do it's job.
        return removedNode;
    }

    private EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode  removedNode = tail;
        if (tail.getPrevious() == null){
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getNext();
        size --;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        // return true if you were able to successfully add the employee
        // into the list before the existing employee. Return false
        // if the existing employee doesn't exist in the list

        if (isEmpty()){
            return false;
        }
        //Find the existing employee.
        EmployeeNode current = head;
        while (current != null && !current.getEmployee().equals(existingEmployee)) {
            // Traversing...
            current = current.getNext();
        }
        if (current == null) {
            return false; // We did not found the existing employee.
        }

        EmployeeNode newNode = new EmployeeNode(newEmployee);
        newNode.setPrevious(current.getPrevious());
        newNode.setNext(current);
        current.setPrevious(newNode);

        // If the existing employee is at the head.
        if (head == current) {
            // So now new node would become the head.
            head =  newNode;
        } else {
            newNode.getPrevious().setNext(newNode);
        }
        size ++;
        return true;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void printList() {
        EmployeeNode current  = head;
        System.out.print("Head ->");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Shubham1", "Pandey1");
        Employee e2 = new Employee("Shubham2", "Pandey2");
        Employee e3 = new Employee("Shubham3", "Pandey3");
        Employee e4 = new Employee("Shubham4", "Pandey4");
        Employee e5 = new Employee("Shubham5", "Pandey5");

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addToFront(e1);
        linkedList.addToFront(e2);
        linkedList.addToFront(e3);
        linkedList.addToFront(e4);
        linkedList.printList();
        System.out.println("---------------------------------");
        System.out.println("Removing from to the front..");
        linkedList.printList();
        System.out.println("Removing from to the End..");
        linkedList.printList();
        System.out.println(linkedList.size);

        System.out.println("Adding new node before the -> " + e4);
        linkedList.addBefore(e5, e4);
        linkedList.printList();
    }
}
