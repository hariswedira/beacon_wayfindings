package com.company;

import java.util.ArrayList;

public class Main {

    static String[] beacon01 = {"beacon01","mp","gate","beacon02","laboran","beacon03"};
    static String[] beacon02 = {"beacon02","beacon01","kantin","dapur","g1","g6","g7"};
    static String[] beacon03 = {"beacon03","beacon01","g10","beacon04"};
    static String[] beacon04 = {"beacon04","beacon03","lobby","beacon05","g9"};
    static String[] beacon05 = {"beacon05","beacon04","g11"};
    static String[][] beacon = {beacon01,beacon02,beacon03,beacon04,beacon05};

    static ArrayList<String> rute;
    static ArrayList<String> visited;
    static ArrayList<String []> neightboar;
    private static String[] start;


    public static void main(String[] args) {
        start = beacon01;
        String end = beacon03[2];

        rute = new ArrayList<>();
        visited = new ArrayList<>();
        neightboar = new ArrayList<>();

        findPath(start, end);
    }

    private static void findPath(String[] starts, String end) {
        String pos[] = starts;
        boolean meet = false;
        boolean way = false;
        boolean isBeaconExist = false;

        while (!meet){
            // Menambahkan beacon saat ini ke visited dan rute
            visited.add(pos[0]);
//            rute.add(pos[0]);
            if (neightboar.isEmpty()){
                // Perulangan pencarian
                for (int i = 0; i < pos.length; i++) {
                    // Jika tetangga sama dengan tujuan akhir
                    if (pos[i].equalsIgnoreCase(end)){
                        rute.add(pos[0]);
                        rute.add(end);
                        way = true;
                        meet = true;
                    }
                    // Jika tetangga tidak sama dengan tujuan akhir
                    // Perulangan sampai index terakhir
                    else if (pos[i].equalsIgnoreCase(pos[pos.length-1])){
                        // Perulangan mencari tetangga beacon
                        for (int j = 0; j < pos.length; j++) {
                            for (int k = 0; k < beacon.length ; k++) {
                                // Jika ada tetangga beacon
                                if (pos[j].equalsIgnoreCase(beacon[k][0])){
                                    // Periksa apakah visited kososng atau tidak
                                    if (visited.isEmpty()){
//                                        System.out.println(beacon[k][0]);
                                    }
                                    // Jika visisted tidak kososng
                                    else {
                                        // Perulangan periksa visited
                                        for (int l = 0; l < visited.size() ; l++) {
                                            // Jika tetangga beacon sudah divisit
                                            if (beacon[k][0].equalsIgnoreCase(visited.get(l))){
                                                // Skip
                                                continue;
                                            }
                                            // Jika belum divisit
                                            else {
                                                // Masukan beacon tetangga ke neightboar
                                                neightboar.add(beacon[k]);
                                                isBeaconExist = true;
                                            }
                                        }
                                    }
                                }
                                // Jika tidak ada tetangga beacon
                                else {

                                }
                            }
                        }
                    }
                }

                if (isBeaconExist){
                    rute.add(pos[0]);
                }

                pos = neightboar.get(0);
                neightboar.remove(0);
            }
            else {
                // Jika tetangga sama dengan tujuan akhir
                for (int i = 0; i < pos.length; i++) {
                    if (pos[i].equalsIgnoreCase(end)){
                        rute.add(pos[0]);
                        rute.add(end);
                        way = true;
                    }
                }
                // Jika tetangga tidak sama dengan tujuan akhir
//                System.out.println(neightboar.get(0)[0]);
                pos = neightboar.get(0);
                neightboar.remove(0);
                meet = true;
            }
        }

        if (way){
            showPath(start,end);
        }else {
            findPath(pos, end);
        }
    }

    private static void showPath(String[] start, String end) {
        System.out.print("Visisted\t : ");
        for (int i = 0; i < visited.size(); i++) {
            if (i == visited.size()-1){
                System.out.print(visited.get(i)+".");
            }else {
                System.out.print(visited.get(i)+" -> ");
            }
        }
        System.out.println("\n\n------------------------");
        System.out.print("\n" + "Start\t: " +start[0]+"\n" + "End\t\t: "+end+"\n" + "Rute\t: ");
        for (int i = 0; i < rute.size(); i++) {
            if (i == rute.size()-1){
                System.out.print(rute.get(i)+".");
            }else {
                System.out.print(rute.get(i)+" -> ");
            }
        }
    }
}
