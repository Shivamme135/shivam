import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HotelReservationProject {

    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "Itsme@#2345";


    public static void main(String[] args) throws ClassNotFoundException , SQLException
    {
//       HERE WE ARE LOADING ALL THE DRIVER (JO BHI HAMARE KAAM AYEGA JO KI COM.MYSQL PACKAGE ME HAI)
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

//        HERE WE USE CONNECETION FROM DATABASE AND USSE CONNECTION KE TIME PE  SQLEXCEPTION AAT HAI
//        DRIVERMANAGER CLASS HAI JISKE ANDR GETCONNECTION method hai which take 3 argumnet
//        is conncetion ko hold krke rkhne ke liye connnection name ka interface aata hai

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while(true)
            {
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                Scanner sc = new Scanner(System.in);
                System.out.println("1. RESERVE A ROOM");
                System.out.println("2. VIEW RESERVATIONS");
                System.out.println("3. GET ROOM NUMBER");
                System.out.println("4. UPDATE RESERVATION");
                System.out.println("5. DELETE RESERVATION");
                System.out.println("0. EXIT");

                System.out.println("select any option:");

                int choice = sc.nextInt();
                switch (choice)
                {
                    case 1:
                        reserveRoom(connection , sc);
                        break;
                    case 2:
                        viewReservations(connection);
                        break;
                    case 3:
                        getRoomNumber(connection , sc);
                        break;
                    case 4:
                        updateReservation(connection , sc);
                        break;
                    case 5:
                        deleteReservation(connection , sc);
                        break;
                    case 0:
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("invalid input ");
                }
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }catch (InterruptedException e)
        {
//            ye isliye kyuki hum simple statement ko bhi explicitly throw kr sakte hai
           throw new RuntimeException(e);
        }
    }
//    =============================================================================================
//    =============================================================================================

    private static void  reserveRoom(Connection connection, Scanner sc )
    {
        try{
            System.out.println("name kya hai aap ka");
            String guestName = sc.next();
            sc.nextLine();
            System.out.println("room number");
            int roomNumber = sc.nextInt();
            System.out.println("contact number kya hai ");
            String contactNumber = sc.next();

            String sql = "INSERT INTO reservations (guest_name , room_number , contact_number)" +
                          "VALUES ('" + guestName+ "' , " + roomNumber +" , '" + contactNumber +"')";

            try( Statement statement = connection.createStatement())
            {
//                isko integer me isliye store kiya kyuki ye kewal batata hai ki kitni rows effect hui hai
                int affectRows =  statement.executeUpdate(sql);

                if(affectRows > 0)
                {
                    System.out.println("Reservation Successful");
                }
                else {
                    System.out.println("Reservation failed");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

     private static void viewReservations(Connection connection) throws SQLException
     {
         String sql = "SELECT reservation_id , guest_name , room_number , contact_number , reservation_date FROM reservations";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql))
        {
            System.out.println("current reservation");

            while (resultSet.next())
            {
                int reservationId = resultSet.getInt("reservation_id");
                String guestName = resultSet.getString("guest_name");
                int roomNumber = resultSet.getInt("room_number");
                String contactNumber = resultSet.getString("contact_number");
                String reservationDate = resultSet.getTimestamp("reservation_date").toString();


            }
        }
     }

     private static void getRoomNumber (Connection connection , Scanner sc)
     {
         try{
             System.out.println("ENTER RESERVATION ID");
             int reservationId = sc.nextInt();
             System.out.println("ENTER GUEST NAME");
             String guestName = sc.next();

             String sql = "SELECT room_number FROM reservations" +
                     "WHERE reservation_id = " + reservationId +
                     "AND guest_name = '" + guestName + "'";


             try(Statement statement = connection.createStatement();
                  ResultSet resultSet = statement.executeQuery(sql)){

                 if(resultSet.next())
                 {
                     int roomNumber = resultSet.getInt("room_number");
                     System.out.println("room number for reservation id " + reservationId + " and guest " +
                             guestName + "is" + roomNumber);
                 }
                 else {
                     System.out.println("Reservation not found for the given id and name");
                 }
             }
         }catch (SQLException e)
         {
             e.printStackTrace();
         }
     }

     private static void updateReservation(Connection connection, Scanner sc)
     {
         try{
             System.out.println("Enter id to update");
             int reservationId = sc.nextInt();
             sc.nextLine();

             if(!reservationExists(connection,reservationId))
             {
                 System.out.println("reservation not found for the given id");
                 return;
             }
             System.out.println("enter guest name");
             String newGuestName = sc.nextLine();
             System.out.println("enter room number");
             int newRoomNumber = sc.nextInt();
             System.out.println("enter new contact number");
             String newContactNumber = sc.next();

             String sql = "UPDATE reservations Set guest_name = '" + newGuestName + "' ," +
             "room_number = " + newRoomNumber + " , " + "contact_number = " + newContactNumber +
             "'" + "WHERE reservation_id = " + reservationId;

            try(Statement statement = connection.createStatement())
            {
                int affectedRoom = statement.executeUpdate(sql);

                if(affectedRoom > 0)
                {
                    System.out.println("reservation update sucessfully");
                }
                else{
                    System.out.println("not updated");
                }
            }
         }catch (SQLException e)
         {
             e.printStackTrace();
         }
     }

    private static void deleteReservation(Connection connection, Scanner sc)
    {
        try{
            System.out.println("Enter reservation id to delete");
            int reservationId = sc.nextInt();


            if(!reservationExists(connection,reservationId))
            {
                System.out.println("reservation not found for the given id");
                return;
            }


           String sql = "DELETE FROM reservations WHERE reservation_id = " + reservationId;

            try(Statement statement = connection.createStatement())
            {
                int affectedRoom = statement.executeUpdate(sql);

                if(affectedRoom > 0)
                {
                    System.out.println("reservation deleted sucessfully");
                }
                else{
                    System.out.println("not deleted");
                }
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static boolean reservationExists(Connection connection , int reservationId)
    {
        try{
            String sql = "SELECT reservation_id FROM reservations WHERE reservation_id = " + reservationId;

            try(Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql))
            {
                return resultSet.next();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;  // handled database error as needed
        }
    }

    public static void exit() throws InterruptedException
    {
        System.out.println("EXITINF SYSTEM");
        int i=5;
        while(i!=0)
        {
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("THANKU FOR USING HOTEL RESERVATION SYSTEM");
    }


}