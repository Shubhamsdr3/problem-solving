package list;

public class EmployeeLinkedList  {

    private EmployeeNode head;

    private int size;

     private void addToFront(Employee employee){
        EmployeeNode node =  new EmployeeNode(employee);
        node.setNext(head);
        head =  node;
        size ++;
    }

    private int getSize(){
         return size;
    }

    private boolean isEmpty(){
         return size == 0;
         // head == null;
     }

     private void removeFromFront() {
         if (isEmpty()) {
             return;
         }

         EmployeeNode removedNode = head;
         head = head.getNext();
         size --;
         removedNode.setNext(null); // let GC to do their job.
     }

     private void removeAll() {
         if (isEmpty()) {
             throw new IndexOutOfBoundsException("Bhai list hi empty hai , kya remove karu?");
         }
         for (int i =0; i < size; i++) {
             EmployeeNode removedNode = head;
             head = head.getNext();
             size --;
             removedNode.setNext(null); // let GC to do their job.
         }
     }

    private void printList() {
        EmployeeNode current  = head;
        System.out.print("Head ->");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        Employee e1 = new Employee("Shubham1", "Pandey1");
        Employee e2 = new Employee("Shubham2", "Pandey2");
        Employee e3 = new Employee("Shubham3", "Pandey3");
        Employee e4 = new Employee("Shubham4", "Pandey4");
        Employee e5 = new Employee("Shubham5", "Pandey5");

        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        linkedList.addToFront(e1);
        linkedList.addToFront(e2);
        linkedList.addToFront(e3);
        linkedList.addToFront(e4);
        linkedList.addToFront(e5);
        linkedList.printList();

        linkedList.removeFromFront();
        System.out.println(linkedList.getSize());
        linkedList.removeAll();
        if (linkedList.isEmpty()){
            throw new IllegalStateException("Mujhe ni pta kya ho rha hai");
        }
    }
}
