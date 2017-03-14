/**
 * Created by forestnewark on 3/14/17.
 */
public class Person {
    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        lastName = lastName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        firstName = firstName;
    }

    private static String firstName = "John";
    private static String lastName = "Newark";
}
