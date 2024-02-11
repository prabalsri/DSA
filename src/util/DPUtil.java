package util;

import java.util.ArrayList;
import java.util.List;

public class DPUtil {

    public static List<?> init(Class<?> itf, Integer row, Integer column, Object... defaultVal) {

        if (Boolean.class.getSimpleName().equals(itf.getSimpleName())) {
            List<List<Boolean>> twoDDp = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                List<Boolean> list = new ArrayList<>();
                for (int j = 0; j < column; j++) {
                    list.add(defaultVal.length > 0 ? (Boolean) defaultVal[0] : false);
                }
                twoDDp.add(list);
            }
            return twoDDp;
        } else if (Integer.class.getSimpleName().equals(itf.getSimpleName())) {
            List<List<Integer>> twoDDp = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < column; j++) {
                    list.add(defaultVal.length > 0 ? (Integer) defaultVal[0] : 0);
                }
                twoDDp.add(list);
            }
            return twoDDp;
        }
        return null;
    }
}
