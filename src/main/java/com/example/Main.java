package com.example;

import java.util.*;

import static com.example.CandidatosList.candidatosList;

public class Main {
    public static Map<String, String> countriesCodeList = new HashMap<>();

    public static void main(String[] args) {
        // Registramos los candidatos
        initializeCountries();
        registerStudents();
        imprimeCiudadesTop();
        imprimePaisesTop();
        System.out.println("Alumnos dispuestos a trabajar en remoto: " + totalRemotos());
        System.out.println("Alumnos dispuestos a trasladarse: " + totalPosibilidadTraslado());
        System.out.println("Candidatos que quieren trabajar exclusivamente presencial y no están dispuestos a trasladarse: " + totalPresencialSinTraslado());
    }

    public static void imprimeCiudadesTop() {
        HashMap<String, Integer> citiesList = new HashMap<>();
        for(Student student : candidatosList) {
            if(citiesList.containsKey(student.getCity())) {
                Integer currentCount = citiesList.get(student.getCity());
                citiesList.replace(student.getCity(), currentCount, currentCount+1);
            } else {
                citiesList.put(student.getCity(), 1);
            }
        }

        System.out.println("Lista de ciudades ordenada por alumnos: ");

        Map<Integer, String> map = sortByValues(citiesList);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey() + ": ");
            System.out.println(me2.getValue());
        }
        System.out.println("");
    }

    public static void imprimePaisesTop() {
        HashMap<String, Integer> countriesList = new HashMap<>();
        for(Student student : candidatosList) {
            if(countriesList.containsKey(student.getCountry())) {
                Integer currentCount = countriesList.get(student.getCountry());
                countriesList.replace(student.getCountry(), currentCount, currentCount+1);
            } else {
                countriesList.put(student.getCountry(), 1);
            }
        }

        System.out.println("Lista de países ordenada por alumnos: ");
        Map<Integer, String> map = sortByValues(countriesList);
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(countriesCodeList.get(me2.getKey()) + ": ");
            System.out.println(me2.getValue());
        }
    }

    public static int totalRemotos() {
        int total = 0;
        for(Student student : candidatosList) {
            if(student.getWorkType() == WorkType.REMOTE)
                total++;
        }
        return total;
    }

    public static int totalPosibilidadTraslado() {
        int total = 0;
        for(Student student : candidatosList) {
            if(student.getCanMove())
                total++;
        }
        return total;
    }

    public static int totalPresencialSinTraslado() {
        int total = 0;
        for(Student student : candidatosList) {
            if(student.getWorkType() == WorkType.SITE && !student.getCanMove())
                total++;
        }
        return total;
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static void registerStudents() {

        Student dario = new Student(1L, 1L, "Darío Aboy Hidalgo", "dario@gmail.com", "612345678", "ES", "Huelva", false, WorkType.REMOTE, "one.jpg", "one.pdf", "");
        Student luis = new Student(2L, 1L, "Luis Pérez García", "luis@gmail.com", "612355678", "ES", "Madrid", true, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student antonio = new Student(2L, 1L, "Antonio Pérez García", "antonio@gmail.com", "61345678", "ES", "Madrid", true, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student jose = new Student(2L, 1L, "Jose Pérez García", "jose@gmail.com", "612344478", "ES", "Sevilla", true, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student alfredo = new Student(2L, 1L, "Alfredo Pérez García", "alfredo@gmail.com", "612388678", "ES", "Málaga", false, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student lucia = new Student(2L, 1L, "Lucía Pérez García", "lucia@gmail.com", "6124645678", "PE", "Lima", false, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student marta = new Student(2L, 1L, "Marta Pérez García", "marta@gmail.com", "612445678", "CO", "Bogotá", true, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student laura = new Student(2L, 1L, "Laura Pérez García", "laura@gmail.com", "612885678", "AR", "Córdoba", true, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student guillermo = new Student(2L, 1L, "Guillermo Pérez García", "guillermo@gmail.com", "612345668", "ES", "Toledo", false, WorkType.REMOTE, "two.jpg", "two.pdf", "");
        Student maria = new Student(2L, 1L, "María Pérez García", "maria@gmail.com", "612995678", "ES", "Sevilla", true, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student maia = new Student(2L, 1L, "Maia Pérez García", "maia@gmail.com", "612425678", "ES", "Ciudad Real", true, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student manuel = new Student(2L, 1L, "Manuel Pérez García", "manuel@gmail.com", "644345678", "ES", "Sevilla", false, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student ricardo = new Student(2L, 1L, "Ricardo Pérez García", "ricardo@gmail.com", "612366668", "ES", "Madrid", true, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student francisco = new Student(2L, 1L, "Francisco Pérez García", "francisco@gmail.com", "612342278", "ES", "Málaga", false, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student david = new Student(2L, 1L, "David Pérez García", "david@gmail.com", "612300678", "MX", "Ciudad de México", true, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student ana = new Student(2L, 1L, "Ana Pérez García", "ana@gmail.com", "612340278", "ES", "Sevilla", false, WorkType.SITE, "two.jpg", "two.pdf", "");
        Student mario = new Student(2L, 1L, "Mario Pérez García", "mario@gmail.com", "610645678", "CO", "Bogotá", true, WorkType.SITE, "two.jpg", "two.pdf", "");

        CandidatosList.add(dario);
        CandidatosList.add(luis);
        CandidatosList.add(antonio);
        CandidatosList.add(jose);
        CandidatosList.add(alfredo);
        CandidatosList.add(lucia);
        CandidatosList.add(marta);
        CandidatosList.add(laura);
        CandidatosList.add(guillermo);
        CandidatosList.add(maria);
        CandidatosList.add(maia);
        CandidatosList.add(manuel);
        CandidatosList.add(ricardo);
        CandidatosList.add(francisco);
        CandidatosList.add(david);
        CandidatosList.add(ana);
        CandidatosList.add(mario);
    }

    public static void initializeCountries() {
        countriesCodeList.put("ES", "España");
        countriesCodeList.put("CO", "Colombia");
        countriesCodeList.put("AR", "Argentina");
        countriesCodeList.put("MX", "México");
        countriesCodeList.put("PE", "Perú");
    }
}
