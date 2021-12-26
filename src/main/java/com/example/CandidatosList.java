package com.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CandidatosList {
    public static ArrayList<Student> candidatosList = new ArrayList<>();

    public static ArrayList<Student> filtrarCiudad(String ciudad) {
        return (ArrayList<Student>) candidatosList.stream().filter(student -> student.getCity().equals(ciudad)).collect(Collectors.toList());
    }
    public static ArrayList<Student> filtrarPresencial(String presencialidad) {
        if(presencialidad.equals("REMOTO"))
            return (ArrayList<Student>) candidatosList.stream().filter(student -> student.getWorkType() == WorkType.REMOTE).collect(Collectors.toList());
        else
            return (ArrayList<Student>) candidatosList.stream().filter(student -> student.getWorkType() == WorkType.SITE).collect(Collectors.toList());
    }
    public static ArrayList<Student> filtrarTraslado(boolean tipoTraslado) {
        return (ArrayList<Student>) candidatosList.stream().filter(student -> student.getCanMove() == tipoTraslado).collect(Collectors.toList());
    }
    public static ArrayList<Student> filtrar(String ciudad, String presencialidad, boolean tipoTraslado) {
        ArrayList<Student> students = new ArrayList<>();
        for(Student student : candidatosList) {
            if(student.getCity().equals(ciudad) || (tipoTraslado == student.getCanMove()))
                students.add(student);
        }
        return students;
    }
    public static Student buscarEmail(String email) {
        return candidatosList.stream().filter(student -> student.getEmail().equals(email)).findFirst().get();
    }
    public static Student buscarTelefono(String telefono) {
        return candidatosList.stream().filter(student -> student.getPhone().equals(telefono)).findFirst().get();
    }

    public static void add(Student student) {
        candidatosList.add(student);
    }

    public static void remove(Student student) {
        candidatosList.remove(student);
    }
}
