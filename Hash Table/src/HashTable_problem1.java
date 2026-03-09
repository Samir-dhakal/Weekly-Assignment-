import java.util.HashMap;

public class HashTable_problem1 {
    static HashMap<String,Integer> userToUserId=new HashMap<>();
    public static void main (String [] args){
        userToUserId.put("ayush panauti",1);
        System.out.println("is ayush panauti there "+ checkAvability("ayush panauti"));

    }
    public static boolean checkAvability(String username){
        return userToUserId.containsKey("ayush panauti");
    }

}
