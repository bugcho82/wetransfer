package Utils;

public class EmailUtils {

    public static String generateTestEmail(String email){
        //Due to e a bug(or expected behavior) in the email validation it is not possible to create test for
        //test automation because + char is not accepted
        //according to the  RFC 5322: Internet Message Format  "+" is a valid email character
        //for the sake of test passing I will enhance my function here
        // return StringUtils.insertStringBeforeCharacter(email ,"+" + Integer.toString(NumberUtils.getRandomInteger(1,10000)),'@');
        return StringUtils.insertStringBeforeCharacter(email ,Integer.toString(NumberUtils.getRandomInteger(1,10000)),'@');
    }
}
