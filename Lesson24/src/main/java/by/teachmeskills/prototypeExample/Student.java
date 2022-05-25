package by.teachmeskills.prototypeExample;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Student {

    private GraduationProject graduationProject;

    public GraduationProject cloneProject() {
        return (GraduationProject) graduationProject.copy();
    }
}
