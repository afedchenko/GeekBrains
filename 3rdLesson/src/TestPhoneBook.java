public class TestPhoneBook {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.addUser("Димон", "89008887766");
        book.addUser("Фокин", "89997578844");
        book.addUser("Абрамов", "89997778844");
        book.addUser("Самсонов", "89997345844");
        book.addUser("Матвеев", "89997367844");
        book.addUser("Миронов", "89123478844");
        book.addUser("Миронов", "89128778844");


        //System.out.println(book.getSurname("89128778844"));
        System.out.println(book.getPhoneNumbers("Миронов"));
    }
}
