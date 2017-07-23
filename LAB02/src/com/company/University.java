package com.company;

import java.util.*;

public class University {
    List<Student> students;
    List<Activity> activities;

    public void addStudent(String name, String surname, StudentType type) {
        students.add(new Student(name, surname, type));
    }

    public void addActivity(String name) {
        activities.add(new Activity(name));
    }

    public void assignStudentToActivity(Student student, Activity activity) {
        activity.assignedStudents.add(student);
    }

    //TODO remove student from activies -> works?
    public void removeStudent(Student student) {
        student.setActivities(null);
        students.remove(student);
    }

    //TODO remove student from activies -> works?
    public void removeStudentWithID(int id) {
        students.get(id).setActivities(null);
        students.remove(students.indexOf(id));
    }

    public void removeAllStudentsFromActivity(Activity activity) {
        activity.assignedStudents.clear();
    }

    public boolean checkStudentInActivity(Student student, Activity activity) {
        if (activity.assignedStudents.contains(student))
            return true;
        return false;
    }

    public Queue<Student> studentsWithoutAnyActivity() {
        Queue<Student> studentQueue = new LinkedList<>();
        for (Student s : students)
            if (!s.getActivities().isEmpty())
                studentQueue.add(s);
        return studentQueue;
    }

    public Stack<Student> studentsWithGivenActivitiesNumber(int numberOfActivites) {
        Stack<Student> studentStack = new Stack<>();
        for (Student s : students)
            if (s.getActivities().size() == numberOfActivites)
                studentStack.push(s);
        return studentStack;
    }

    public Student studentWithMaxActivities() {
        /*
        //Implementacja typowa - klasa anonimowa
        Student student = Collections.max(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getActivities().size(), o2.getActivities().size());
            }
        });
        */

        //Implementacja nowoczesna - wyrażenie lambda
        Student student = Collections.max(students, ((o1, o2) -> {
            return Integer.compare(o1.getActivities().size(), o2.getActivities().size());
        }));

        return student;
    }

    public HashMap<StudentType, Integer> numberOfGivenTypeOfStudents() {
        HashMap<StudentType, Integer> studentHashMap = new HashMap<>();
        int stationary = 0, nonstationary = 0, postgraduate = 0;
        for (Student s : students) {
            if (s.getType().equals(StudentType.STATIONARY.toString())) {
                stationary++;
                studentHashMap.put(StudentType.STATIONARY, stationary);
            }
            if (s.getType().equals(StudentType.NONSTATIONARY.toString())) {
                nonstationary++;
                studentHashMap.put(StudentType.NONSTATIONARY, nonstationary);
            }
            if (s.getType().equals(StudentType.POSTGRADUATE.toString())) {
                postgraduate++;
                studentHashMap.put(StudentType.POSTGRADUATE, postgraduate);
            }
        }
        return studentHashMap;
    }

    public void printSortedStudents() {
        Collections.sort(students, (a, b) -> b.compareTo(a));
        students.forEach(System.out::println);
    }

    public boolean checkStudentsInTwoSameActivities(Activity activity1, Activity activity2) {
        if (!Collections.disjoint(activity1.assignedStudents, activity2.assignedStudents))
            return true;
        return false;
    }
}
