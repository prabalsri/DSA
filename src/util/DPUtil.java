package util;

import java.util.ArrayList;
import java.util.List;

public class DPUtil {

    public static final Integer DEFAULT_INTEGER = -1;

    public static final Boolean DEFAULT_BOOLEAN = false;

    public static List<?> init(Class<?> itf, Integer row, Integer column, Object... defaultVal) {

        if (row > 1) {
            if (Boolean.class.getSimpleName().equals(itf.getSimpleName())) {
                List<List<Boolean>> twoDDp = new ArrayList<>();
                for (int i = 0; i < row; i++) {
                    List<Boolean> list = new ArrayList<>();
                    for (int j = 0; j < column; j++) {
                        list.add(defaultVal.length > 0 ? (Boolean) defaultVal[0] : DEFAULT_BOOLEAN);
                    }
                    twoDDp.add(list);
                }
                return twoDDp;
            } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
                List<List<Integer>> twoDDp = new ArrayList<>();
                for (int i = 0; i < row; i++) {
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < column; j++) {
                        list.add(defaultVal.length > 0 ? (Integer) defaultVal[0] : DEFAULT_INTEGER);
                    }
                    twoDDp.add(list);
                }
                return twoDDp;
            }
        } else if(row == 1) {
            if (Boolean.class.getSimpleName().equals(itf.getSimpleName())) {
                List<Boolean> oneDDp = new ArrayList<>();
                for (int i = 0; i < column; i++) {
                    oneDDp.add(defaultVal.length > 0 ? (Boolean) defaultVal[0] : DEFAULT_BOOLEAN);
                }
                return oneDDp;
            } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
                List<Integer> oneDDp = new ArrayList<>();
                for (int i = 0; i < column; i++) {
                    oneDDp.add(defaultVal.length > 0 ? (Integer) defaultVal[0] : DEFAULT_INTEGER);
                }
                return oneDDp;
            }
        }
        return null;
    }

    public static List<?> init(Class<?> itf, String defaultVal, Integer... dimensions) {

        if (dimensions.length == 4) {
            if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
                List<List<List<List<Integer>>>> fourDList = new ArrayList<>();
                for (int k = 0; k < dimensions[0]; k++) {
                    List<List<List<Integer>>> threeDList = getLists(Integer.parseInt(defaultVal), dimensions);
                    fourDList.add(threeDList);
                }
                return fourDList;
            }
        }
        return null;
    }

    private static List<List<List<Integer>>> getLists(Integer defaultVal, Integer[] dimensions) {
        List<List<List<Integer>>> threeDList = new ArrayList<>();
        for (int h = 0; h < dimensions[1]; h++) {
            List<List<Integer>> twoDList = new ArrayList<>();
            for (int i = 0; i < dimensions[2]; i++) {
                List<Integer> oneDList = new ArrayList<>();
                for (int j = 0; j < dimensions[3]; j++) {
                    oneDList.add(defaultVal);
                }
                twoDList.add(oneDList);
            }
            threeDList.add(twoDList);
        }
        return threeDList;
    }
}
