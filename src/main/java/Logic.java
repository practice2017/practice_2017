import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by knnas on 18.01.2017.
 */
public class Logic {
    //Чтение данных
    public static List<String> getList() throws IOException {
        List<String> result;
        result = Files.readAllLines(Paths.get("data.csv"), Charset.forName("windows-1251"));
        return result;
    }

    //Создание экземпляра класса
    public static DataResult getData(String result) {
        List<String> str = new ArrayList<String>();
        str = partitionString(result);
        if (str.size() == 14) {
            InitialData obj = new InitialData(str.get(0), str.get(1), str.get(2), str.get(3),
                    str.get(4), str.get(5), str.get(6), str.get(7), str.get(8),
                    str.get(9), str.get(10), str.get(11), str.get(12), str.get(13).substring(0, str.get(13).length() - 1));
            return new DataResult(obj,null);
        }
        return new DataResult(null,result);
    }

    //Обработка входной строки
    public static List<String> partitionString(String initialString) {
        List<String> str = new ArrayList<String>();
        if (correctString(initialString) && (initialString.charAt(0)) != '#') {
            List<String> s = new ArrayList<String>(Arrays.asList(initialString.split("\\|", 14)));
            str = s;
        }
        return str;
    }

    //Проверка на корректность входной строки
    public static boolean correctString(String initialDataString) {
        int amountOfSymbol = 0;
        boolean flag = false;
        for (int i = 0; i < initialDataString.length(); i++) {
            if (initialDataString.charAt(i) == '|')
                amountOfSymbol++;
        }
        if (amountOfSymbol == 14)
            flag = true;
        return flag;
    }

}
