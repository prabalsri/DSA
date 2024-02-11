package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUtil {

    public static List<?> getListInput(Class<?> itf, String message) {

        Integer size = (Integer) getInput(Integer.class, String.format("Enter the size (Upcoming: %s): ", message.trim()));
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (String.class.getSimpleName().equals(itf.getSimpleName())) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(scanner.next());
            }
            return list;
        } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(scanner.nextInt());
            }
            return list;
        }
        return null;
    }

    public static List<?> getListOfListInput(Class<?> itf, String message) {

        Integer row = (Integer) getInput(Integer.class, String.format("Enter the row (Upcoming: %s): ", message.trim()));
        Integer col = (Integer) getInput(Integer.class, String.format("Enter the column (Upcoming: %s): ", message.trim()));

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (String.class.getSimpleName().equals(itf.getSimpleName())) {
            List<List<String>> listOfList = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < col; j++) {
                    list.add(scanner.next());
                }
                listOfList.add(list);
            }
            return listOfList;
        } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
            List<List<Integer>> listOfList = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < col; j++) {
                    list.add(scanner.nextInt());
                }
                listOfList.add(list);
            }
            return listOfList;
        }
        return null;
    }

    public static Object getInput(Class<?> itf, String message) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        if (String.class.getSimpleName().equals(itf.getSimpleName())) {
            return scanner.next();
        } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
            return scanner.nextInt();
        }
        return null;
    }
}
