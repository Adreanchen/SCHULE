package at.htl.arrayvslist;

public class Subject {

    // Fields *****************************************************************

    private String name;
    private String teacher;
    private int weeklyHours;

    // Instance creation ******************************************************

    public Subject(String name, String teacher, int weeklyHours) {
        this.name = name;
        this.teacher = teacher;
        this.weeklyHours = weeklyHours;
    }

    // Accessors **************************************************************

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }
}
