package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UsersManager implements UsersManagerLocal {
    @Resource(lookup = "jdbc/myressource")
    private DataSource dataSource;

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            System.out.println("Schema: " + connection.getSchema());
            System.out.println("Catalog: " + connection.getCatalog());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Boolean active = rs.getBoolean("active");
                users.add(new User(id, firstName, lastName, email, password, active));
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User findByEmail(String mail) {
        User user = new User();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            user.setId(rs.getLong("id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setActive(rs.getBoolean("active"));
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
}
