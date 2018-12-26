package database;
import java.sql.*;
import java.util.Calendar;


public class Database {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    
    public static void main(String[] args) throws SQLException 
    {
        
        try {
            
            String pass_root = "qGZH26#J}mu2$v!b>X";
            String pass_julle = "W*E;N4%ia2,X9i[jTw";
            //Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=test" + "&password=" + "1234" + "&serverTimezone=UTC");

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());        
            String query = " insert into database1.user (username, email, password, create_time, ID)" + " values (?, ?, ?, ?, ?)";

            
            
            //statement = connect.createStatement();
            //statement.executeUpdate(query);
           

            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, "Christian");
            preparedStatement.setString(2, "test@test.com");
            preparedStatement.setString(3, "lololol");
            preparedStatement.setDate(4, startDate);
            preparedStatement.setString(5, "2");
            preparedStatement.execute();


           connect.close();
           System.out.println("Success");

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Fejl");
        }
        

    }
    
}
