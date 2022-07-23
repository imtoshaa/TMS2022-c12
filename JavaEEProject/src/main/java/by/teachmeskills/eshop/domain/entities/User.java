package by.teachmeskills.eshop.domain.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static by.teachmeskills.eshop.RequestParamsEnum.USERNAME;

@Getter
@Setter
@ToString
@SuperBuilder
public class User extends BaseEntity {
    private String username;
    private String name;
    private String surname;
    private String password;
    private String img;
    private String info;
    private String email;
    private String birthday;

    public User(int id, String username, String name, String surname, String password, String img, String info, String email, String birthday) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.info = info;
        this.email = email;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Builder() {
        }

        public User buildUserFromResultSet(ResultSet rs) throws SQLException {
            User user = null;
            if (rs.next()) {
                int id = rs.getInt("id");
                String log = rs.getString(USERNAME.getValue());
                String name = rs.getString("name");
                String password = rs.getString("password");
                String surname = rs.getString("surname");
                String img = rs.getString("img");
                String info = rs.getString("info");
                String email = rs.getString("email");
                String birthday = rs.getString("birthday");
                user = new User(id, log, name, surname, password, img, info, email, birthday);
            }
            return user;
        }
    }
}
