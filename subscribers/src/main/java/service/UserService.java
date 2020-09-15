package service;

import db.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from info");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString(2);
            String email = resultSet.getString("email");
            long mob = resultSet.getLong(4);
            User user = new User(name, email, mob);
            users.add(user);
        }
        return users;
    }

    public static User findUserById(int id) throws SQLException {
        User user = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from info where id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString(2);
            String email = resultSet.getString("email");
            long mob = resultSet.getLong(4);
            user = new User(name, email, mob);
            return user;
        }
        return user;
    }

    public static int removeUserById(int id) throws SQLException {

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from info where id = ?");
        preparedStatement.setInt(1, id);
        int ans = preparedStatement.executeUpdate();
        return ans;
    }

    public static int addUser(User user) throws SQLException {

        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into info(Name, Email, Mobile) values(?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setLong(3, user.getMob());
        int ans = preparedStatement.executeUpdate();
        return ans;
    }

    public static int updateUserById(User user, int id) throws SQLException{
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update info set Name = ?, Email=?, Mobile=? where id = ?");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setLong(3, user.getMob());
        preparedStatement.setInt(4, id);

        int ans = preparedStatement.executeUpdate();
        return ans;
    }
}
