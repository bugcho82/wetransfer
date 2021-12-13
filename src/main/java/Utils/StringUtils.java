package Utils;

public class StringUtils {

    public static String insertStringInToPosition(String str, String ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    public static String insertStringBeforeCharacter(String str, String strToInsert, char ch){
        return insertStringInToPosition(str,strToInsert, str.indexOf(ch));

    }



}
