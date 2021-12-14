
/**
  ДЗ №4. Коллекции
 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов,
 из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи,
 а с помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.
 */

import java.util.*;
class WordsMass {

    public static void main(String[] args) {
        taskOne();
        taskTwo();
    }

    private static void taskOne() {
        Map<String, Integer> hm = new HashMap<>();
        String[] words = {
            "Charles", "OBS", "EPIC", "Android",
            "SoapUI", "GitKraken", "Charles","EPIC",
            "Fiddler", "iOS", "Fiddler", "VSCode",
            "EPIC", "iOS", "GitKraken","Android",
                "SoapUI", "OBS", "Charles", "Postman"
        };

        for (int i = 0; i < words.length; i++) {
            if (hm.containsKey(words[i]))
                hm.put(words[i], hm.get(words[i]) + 1);
            else
                hm.put(words[i], 1);
        }
        System.out.println(hm);
    }

    private static void taskTwo() {
        Direct directory = new Direct();
        
        directory.add("Slava", "8123123123");
        directory.add("Bonjour", "8934564576");
        directory.add("Kotov", "8457656785");
        directory.add("Aristarkh", "86896544356");
        directory.add("Kotov", "82342344234");
        directory.add("Aristarkh", "823423423645");
        directory.add("Slava", "464567456645");
        directory.add("Bonjour", "82342356456");
        directory.add("Kotov", "8234334344");

        System.out.println(directory.get("Slava"));
        System.out.println(directory.get("Bonjour"));
        System.out.println(directory.get("Kotov"));
        System.out.println(directory.get("Aristarkh"));
    }
}

class Direct {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}