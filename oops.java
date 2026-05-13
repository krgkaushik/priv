import java.sql.*;
import java.util.Scanner;

public class Students{
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in);
         Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/studentdb","root","Kaushik@123")){

         int choice;
         do{
            System.out.println(" Enter choice 1.add , 2.view , 3.update, 4.delete , 5.exits ");
            choice = sc.nextInt();

            if( choice == 1){
                PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?)");
                System.out.print("Enter student details");
                ps.setInt(1,sc.nextInt());
                  ps.setString(2,sc.next());
                    ps.setString(3,sc.next());
                      ps.setInt(4,sc.nextInt());
                      ps.executeUpdate();
                       System.out.println("student added successfully");


            }
            else if ( choice == 2 ){
                ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");
                System.out.println("id   name  course marks");
                while( rs.next()){
                    System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3) +" "+ rs.getInt(4));
                } 

            }
            else if ( choice == 3 ){
                PreparedStatement ps = con.prepareStatement("UPDATE students SET name = ? WHERE id = ?");
                System.out.println("Enter first student id then name");
                int id = sc.nextInt();
                ps.setString(1,sc.next());
                ps.setInt(2,id);
                  ps.executeUpdate();
                       System.out.println("student update succeessfully");
                


            }
            else if ( choice == 4 ){
                 PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id = ?");
                System.out.println("Enter first student id ");
                
                 ps.setInt(1,sc.nextInt());
                  ps.executeUpdate();
            System.out.println("student delete succeessfully");

            }
         } while( choice != 5);
         } catch(Exception e){
            System.out.print(e);
         }
    }
}
