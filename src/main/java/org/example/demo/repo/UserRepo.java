package org.example.demo.repo;

import org.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    private final JdbcTemplate jdbc;

    public UserRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObj = new User();
            rowObj.setId(r.getInt("u_id"));
            rowObj.setfName(r.getString("fName"));
            rowObj.setlName(r.getString("lName"));
            return rowObj;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user){
        String sql = "INSERT INTO userTable VALUES (?, ?)";
        jdbc.update(sql, user.getfName(), user.getlName());
        return user;
    }


    // HOMEWORK
    public void delete(int id){
        String sql = "DELETE FROM userTable WHERE u_id=?";
        jdbc.update(sql);
    }

    public void update(User user, String fName, String lName){
        String sql = "UPDATE userTable SET fName = ?, lName = ? WHERE u_id=?";
        jdbc.update(sql, fName, lName, user.getId());
    }
}
