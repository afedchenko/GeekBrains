import java.util.*;

public class PhoneBook {

    HashMap<String, String> phoneBKmap = new HashMap<>();

    public void addUser(String name, String number) {
        phoneBKmap.put(number, name);
    }

    public String getSurname(String number){
        return phoneBKmap.get(number);
    }

    public List<String> getPhoneNumbers(String surname){
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, String > i : phoneBKmap.entrySet()) {
            if (surname.equals(i.getValue())){
                result.add(i.getKey());
            }
        }
        return result;
    }
}
