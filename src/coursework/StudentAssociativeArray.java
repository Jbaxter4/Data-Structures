/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author James
 */
public class StudentAssociativeArray implements IStudentAssociativeArray {

    Student[] array;
    int arraySize;
    int studentsInArray = 0;
    float loadFactor;
    HashSet<Student> studentSet = new HashSet<>();
    HashSet<String> keySet = new HashSet<>();

    StudentAssociativeArray(int s) {
        array = new Student[s];
        arraySize = s;
    }

    /*This function converts the string into an int by converting the string 
    into its ascii values. It then calculates a position within the array by 
    getting the modulus of the number divided by the array length.*/
    public int HashFunction(String surname, Student[] array) {
        String LCsurname = surname.toLowerCase();
        int asciiS = 0;
        for (int i = 0; i < LCsurname.length(); i++) {
            asciiS = asciiS + (int) LCsurname.charAt(i);
        }
        System.out.println("Hash Value : " + asciiS);
        int pos = asciiS % arraySize;
        int temp = pos;
        while (array[pos] != null) {
            System.out.println("Trying position " + pos);
            pos = (pos + doubleHash(asciiS)) % arraySize;
            if (pos == temp) {
                asciiS++;
            }
        }
        return pos;
    }

    /*This function takes the ascii value calculated and runs a second hash 
    function to itterate through the array.*/
    public int doubleHash(int asciiS) {
        int hash = (arraySize - (asciiS % arraySize));
        return hash;
    }

    /*This function simply returns the load factor.*/
    public float getLoadFactor() {
        loadFactor = (float) studentsInArray / arraySize;
        return loadFactor;
    }

    //This is a function to calculate if an inputed number is a prime.
    public boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int a = 0; a < arraySize; a++) {
            array[a] = null;
        }
        studentsInArray = 0;
    }

    @Override
    public boolean containsSurname(String surname) {
        return getStudent(surname) != null;
    }

    @Override
    public boolean containsValue(Student student) {
        return getStudent(student.getSurname()) != null;
    }

    @Override
    public Student getStudent(String surname) {
        int count = 0;
        System.out.println("Getting " + surname);
        String LCsurname = surname.toLowerCase();
        int asciiS = 0;
        for (int i = 0; i < LCsurname.length(); i++) {
            asciiS = asciiS + (int) LCsurname.charAt(i);
        }
        System.out.println("Hash Value : " + asciiS);
        int pos = asciiS % arraySize;
        while (((array[pos] == null) || (!array[pos].getSurname().equals(surname))) && (count <= arraySize)) {
            System.out.println("Trying position " + pos);
            pos = (pos + doubleHash(asciiS)) % arraySize;
            count++;
        }
        if (array[pos].getSurname().equals(surname)) {
            System.out.println("Trying position " + pos);
            System.out.println("Student found");
            return array[pos];
        } else {
            System.out.println("Student couldn't be found");
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return (studentsInArray == 0);
    }

    @Override
    public Set<String> keySet() {
        for (int i = 0; i < arraySize; i++) {
            if ((array[i]) != null) {
                keySet.add(array[i].surname);
            }
        }
        keySet.forEach((s) -> {
            if (s != null) {
                System.out.println(s);
            }
        });
        return keySet;
    }

    @Override
    public Student put(Student student) {
        System.out.println("Adding " + student.getSurname());
        int position = HashFunction(student.getSurname(), array);
        //System.out.println("Trying position " + position);
        array[position] = student;
        studentsInArray++;
        System.out.println("Student placed");
        if (studentsInArray >= (0.75 * arraySize)) {
            System.out.println("Array resizing");
            System.out.println("Current capacity : " + arraySize);
            arraySize = arraySize * 2;
            while (!isPrime(arraySize)) {
                arraySize++;
            }
            array = Arrays.copyOf(array, arraySize);
            System.out.println("New capacity : " + arraySize);
        }
        return student;
    }

    @Override
    public Student remove(String surname) {
        if (getStudent(surname) == null) {
            return null;
        } else {
            int count = 0;
            System.out.println("Removing " + surname);
            String LCsurname = surname.toLowerCase();
            int asciiS = 0;
            for (int i = 0; i < LCsurname.length(); i++) {
                asciiS = asciiS + (int) LCsurname.charAt(i);
            }
            //System.out.println("Hash Value : " + asciiS);
            int pos = asciiS % arraySize;
            while (((array[pos] == null) || (!array[pos].getSurname().equals(surname))) && (count <= arraySize)) {
                //System.out.println("Trying position " + pos);
                pos = (pos + doubleHash(asciiS)) % arraySize;
                count++;
            }
            if (array[pos].getSurname().equals(surname)) {
                //System.out.println("Trying position " + pos);
                System.out.println("Student removed");
                Student temp = array[pos];
                array[pos] = null;
                studentsInArray--;
                return temp;
            } else {
                System.out.println("Student couldn't be found");
                return null;
            }
        }
    }

    @Override
    public int size() {
        return studentsInArray;
    }

    @Override
    public Set<Student> getStudents() {
        Collections.addAll(studentSet, array);
        studentSet.forEach((s) -> {
            if (s != null) {
                System.out.println(s.getSurname() + " " + s.getStudentID());
            }
        });
        return studentSet;
    }
}
