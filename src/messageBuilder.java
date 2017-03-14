/**
 * Created by forestnewark on 3/14/17.
 */
public class messageBuilder {


    public static String buildMessage(){
        StringBuilder builder = new StringBuilder();
        builder.append("Dear " + Person.getFirstName() + " " + Person.getLastName());
        builder.append("\n");
        builder.append("Here is a carefully thought out message with lots of parts");
        builder.append("\n");
        builder.append("Respectfully,");
        builder.append("\n");
        builder.append("Forest Newark");
        return builder.toString();
    }
}
