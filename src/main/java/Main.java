import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by knnas on 18.01.2017.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("serverIp: ");
        String serverIp  = in.nextLine();
        System.out.print("keyspace: ");
        String keyspace = in.nextLine();
        System.out.print("user: ");
        String user = in.nextLine();
        System.out.print("password: ");
        String password = in.nextLine();
        /*String serverIp = args[0].toString();
        String keyspace = args[1].toString();
        String user = args[2].toString();
        String password = args[3].toString();
        */
        Logic logic = new Logic();
        CassandraConnection cassConnection = new CassandraConnection();
        List<String> result = logic.getList();
        List <DataResult> rows = result.stream().map(Logic::getData).collect(Collectors.toList());
        //rows.stream().filter((p)->p.getInCorrectString()!=null).forEach(p->System.out.println("Ошибка в строке: " +
          //      p.getInCorrectString()));
        //rows.stream().filter((p)->p.getInitialData()!=null).forEach(p->System.out.println(p.getInitialData()));

        //Подключение к кластеру
        Cluster cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .withCredentials(user,password)
                .withPort(9042)
                .build();
        Session session = cluster.connect(keyspace);


        /*Cluster cluster = Cluster.builder()
                .addContactPoints(args[0])
                .withCredentials(args[1],args[2])
                .build();
        Session session = cluster.connect(args[3]);*/

        //Вставка элементов в базу данных
        rows.stream().filter((p)->p.getInitialData()!=null).forEach(p->cassConnection.insertDataToBD(p.getInitialData(),session));

        //Закрытие соединения
        cluster.close();
    }
}
