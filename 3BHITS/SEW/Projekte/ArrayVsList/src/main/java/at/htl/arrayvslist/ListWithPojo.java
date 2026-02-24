package at.htl.arrayvslist;

import java.util.ArrayList;

public class ListWithPojo {

    ArrayList<Subject> subjectList;

    public ListWithPojo() {

        subjectList = new ArrayList<Subject>();
        fillList();

        // Check weekly hours
        int totalWeeklyHours = 0;
        for (Subject subject : subjectList) {
            totalWeeklyHours = totalWeeklyHours + subject.getWeeklyHours();
        }
        System.out.println("Total weekly hours: " + totalWeeklyHours);
    }

    private void fillList(){
        // Monday
        subjectList.add(new Subject("INSY", "HOH", 2));
        subjectList.add(new Subject("AM", "PRM", 2));
        subjectList.add(new Subject("BESP", "WEF", 2));
        subjectList.add(new Subject("GGP", "PAUL", 1));
        subjectList.add(new Subject("NWT1", "FIR, LIDL", 1));
        subjectList.add(new Subject("ITSI_1", "FIR, LIDL", 1));

        // Tuesday
        subjectList.add(new Subject("NW", "SWA", 1));
        subjectList.add(new Subject("D", "NEUB", 1));
        subjectList.add(new Subject("SEW", "GEI", 2));
        subjectList.add(new Subject("D", "NEUB", 1));
        subjectList.add(new Subject("GGP", "PAUL", 1));
        subjectList.add(new Subject("MEDT", "FICI, GRU", 2));

        // Wednesday
        subjectList.add(new Subject("ITSI_1", "EBE", 1));
        subjectList.add(new Subject("NWT1", "LIDL", 1));
        subjectList.add(new Subject("E", "GOLL", 1));
        subjectList.add(new Subject("SYT", "ZOG", 1));
        subjectList.add(new Subject("RK", "SCHM", 2));

        // Thursday
        subjectList.add(new Subject("ITP", "RAH", 4));
        subjectList.add(new Subject("INSY1", "HOH, STO", 1));

        // Friday
        subjectList.add(new Subject("NW", "SWA", 1));
        subjectList.add(new Subject("AM", "PRM", 1));
        subjectList.add(new Subject("SEW1", "GEI", 1));
        subjectList.add(new Subject("E", "GOLL", 1));
        subjectList.add(new Subject("NWT1", "LIDL", 1));
        subjectList.add(new Subject("ITP1", "RAH", 1));
        subjectList.add(new Subject("SYT_U", "FIMI, HOH", 2));
        subjectList.add(new Subject("SYT", "HOH", 1));
    }

    public static void main(String[] args) {
        new ListWithPojo();
    }
}
