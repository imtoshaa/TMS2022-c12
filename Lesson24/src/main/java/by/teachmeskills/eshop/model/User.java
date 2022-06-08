package by.teachmeskills.eshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class User {
    private int id;
    private String login;
    private String name;
    private String surname;
    private String password;
    private String img;
    private String info;
    private Cart cart;
    private String email;
    private String birthday;

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

        private int id;
        private String login;
        private String name;
        private String surname;
        private String password;
        private String img;
        private String info;

        private Builder(){}

        public User buildUserFromResultSet(ResultSet rs) throws SQLException {
            User user = null;
            if (rs.next()) {
                int id = rs.getInt("id");
                String log = rs.getString("login");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String surname = rs.getString("surname");
                String img = rs.getString("img");
                String info = rs.getString("info");
                String email = rs.getString("email");
                String birthday = rs.getString("birthday");
                user = User.builder()
                        .id(id)
                        .login(log)
                        .name(name)
                        .surname(surname)
                        .password(password)
                        .img(img)
                        .info(info)
                        .cart(new Cart())
                        .email(email)
                        .birthday(birthday)
                        .build();
            }
            return user;
        }
    }
}
