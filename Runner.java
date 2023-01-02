public class Runner {
    public static void main(String[] args) {
        CircularSinglyLinkedListImplementation csll = new CircularSinglyLinkedListImplementation();
        csll.addAtBeginning(10);
        csll.append(20);
        csll.addAtPosition(3, 25);
        csll.append(30);
        csll.display();
        System.out.println("Length of the linked list is " + csll.length());
        csll.display();
        csll.reverse();
        csll.display();
    }
}