package by.teachmeskills.prototypeExample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class GraduationProject implements Copyable{
    private String authorsName;
    private String projectTheme;
    private int numberOfPages;


    @Override
    public Object copy() {
        GraduationProject copyOfProject = new GraduationProject(authorsName, projectTheme, numberOfPages);
        return copyOfProject;
    }
}
