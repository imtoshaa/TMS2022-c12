package by.teachmeskills.prototypeExample;

public class Run {
    public static void main(String[] args) {
        GraduationProject projectFromInternet = new GraduationProject("Vadim",
                "Печать керамическими фотополимерными смолами", 140);
        System.out.println(projectFromInternet);

        System.out.println("===============================");

        Student student = new Student(projectFromInternet);
        GraduationProject newProject = student.cloneProject();
        System.out.println(newProject);
    }
}
