package by.teachmeskills.eshop.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static by.teachmeskills.eshop.utils.EshopConstants.BIRTHDAY;
import static by.teachmeskills.eshop.utils.EshopConstants.EMAIL;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.IMG;
import static by.teachmeskills.eshop.utils.EshopConstants.INFO;
import static by.teachmeskills.eshop.utils.EshopConstants.NAME;
import static by.teachmeskills.eshop.utils.EshopConstants.PASSWORD;
import static by.teachmeskills.eshop.utils.EshopConstants.SURNAME;
import static by.teachmeskills.eshop.utils.EshopConstants.USERNAME;


@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String birthday;
    private String email;
    private String info;
    private String img;

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
                int id = rs.getInt(ID);
                String log = rs.getString(USERNAME);
                String name = rs.getString(NAME);
                String password = rs.getString(PASSWORD);
                String surname = rs.getString(SURNAME);
                String img = rs.getString(IMG);
                String info = rs.getString(INFO);
                String email = rs.getString(EMAIL);
                String birthday = rs.getString(BIRTHDAY);
                user = new User(id, log, name, surname, password, img, info, email, birthday);
            }
            return user;
        }
    }
}
