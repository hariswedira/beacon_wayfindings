package com.company;

import java.util.ArrayList;

public class Main {

//    static String[] beacon01 = {"beacon01", "beacon02", "kantin", "dapur", "g1", "g5", "g6", "g7","lol"};
//    static String[] beacon02 = {"beacon02", "beacon01", "beacon03", "mpmart", "laboran", "lol"};
//    static String[] beacon03 = {"beacon03", "beacon02", "g9", "beacon04"};
//    static String[] beacon04 = {"beacon04", "beacon03", "beacon05", "lobby", "g9"};
//    static String[] beacon05 = {"beacon05", "beacon04", "beacon06", "beacon07", "g11", "lak"};
//    static String[] beacon06 = {"beacon06", "beacon05", "g8", "g2", "g3", "g4"};
//    static String[] beacon07 = {"beacon07", "beacon05", "beacon08", "lift", "admin", "dosen lb", "g12"};
//    static String[] beacon08 = {"beacon08", "beacon07", "toilet", "exit"};
//    static String[][] beacon = {beacon01, beacon02, beacon03, beacon04, beacon05, beacon06, beacon07, beacon08};
//    static String[][] beacon = {beacon01, beacon02, beacon03};

    static ArrayList<String> rute;
    static ArrayList<String> visited;
    static ArrayList<String[]> neightboar;
    private static String start;

    static ArrayList<ArrayList<String>> neightboars;
    static ArrayList<String> unvisited;
    static ArrayList<String> beacon01;
    static ArrayList<String> beacon02;
    static ArrayList<String> beacon03;
    static ArrayList<ArrayList<String>> beacon;
    static ArrayList<String> rutes;
    static ArrayList<String> s;
    static String end;

    public static void main(String[] args) {
//        start = beacon01[0];
//        String end = beacon02[3];

//        rute = new ArrayList<>();
//        visited = new ArrayList<>();
//        neightboar = new ArrayList<>();

//        visited.add("beacon01");
//        findPath(start, end);
//        findWay(start, end);

        neightboars = new ArrayList<>();
        unvisited = new ArrayList<>();
        beacon01 = new ArrayList<>();
        beacon02 = new ArrayList<>();
        beacon03 = new ArrayList<>();
        beacon = new ArrayList<>();
        rutes = new ArrayList<>();
        s = new ArrayList<>();

        initDataAllBeacon();
        s = beacon01;
        end = "g9";
        uhuy(s, end);

        System.out.println("\nRute : ");
        for (int i = 0; i < rutes.size(); i++) {
            System.out.println(rutes.get(i));
        }

    }

    private static void initDataAllBeacon() {
        beacon01.add("beacon01");
        beacon01.add("beacon02");
        beacon01.add("kantin");
        beacon01.add("kitchen");
        beacon01.add("g1");
        beacon01.add("g5");
        beacon01.add("g6");
        beacon01.add("g7");

        beacon02.add("beacon02");
        beacon02.add("mpmart");
        beacon02.add("gate");
        beacon02.add("beacon01");
        beacon02.add("laboran");
        beacon02.add("beacon03");

        beacon03.add("beacon03");
        beacon03.add("beacon02");
        beacon03.add("g9");
        beacon03.add("beacon04");

        beacon.add(beacon01);
        beacon.add(beacon02);
        beacon.add(beacon03);
        unvisited.add("beacon01");
        unvisited.add("beacon02");
        unvisited.add("beacon03");
    }

    private static void uhuy(ArrayList<String> starts, String end) {
        boolean meet = false;
        boolean beaconExist = false;

        while (!meet) {
            // Periksa dulu start udah divisit belum
            for (int u = 0; u < unvisited.size(); u++) {
                // Kalo belum
                if (starts.get(0).equalsIgnoreCase(unvisited.get(u))) {
                    unvisited.remove(u);
                    // Periksa tetangga start
                    for (int i = 0; i < starts.size(); i++) {
                        // Kalo ketemu end
                        if (starts.get(i).equalsIgnoreCase(end)) {
                            // Ketemu! keluar dari while
                            rutes.add(starts.get(0));
                            rutes.add(end);
                            meet = true;
                        }
                        // Kalo ketemu tetangga yang id:beacon
                        else if (starts.get(i).equalsIgnoreCase(starts.get(starts.size()-1))){
                            for (String start1 : starts) {
                                for (ArrayList<String> aBeacon : beacon) {
                                    if (start1.equalsIgnoreCase(aBeacon.get(0)) &&
                                            !starts.get(0).equalsIgnoreCase(aBeacon.get(0))) {
                                        // Masukin tetangga ke neighboar, buat diperiksa nanti
                                        neightboars.add(aBeacon);
                                        System.out.println("tetangga " + starts.get(0) + " : " + aBeacon.get(0));
                                        // Ada tetangga dengan id:beacon
                                        beaconExist = true;
                                    }
                                }
                            }
                        }
                    }

                    // Kalo ada tetangga id:beacon
//                    if (beaconExist) {
//                        // Masukin start ke rute
//                        rutes.add(starts.get(0));
//                        // Pindahin posisi start ke tetangga pertama
//                        starts = neightboars.get(0);
//                        // Hapus tetangga yg jadi target pindah
//                        neightboars.remove(0);
//                    }
                }
            }
//TODO : PROBLEM -> Periksa kalo neightboars sudah divist maka tidak perlu di cek kemabali
            if (beaconExist) {
                // Masukin start ke rute
                if (!meet){
                    rutes.add(starts.get(0));
                }
                // Pindahin posisi start ke tetangga pertama
                starts = neightboars.get(0);
                // Hapus tetangga yg jadi target pindah
                neightboars.remove(0);
            }
        }

    }

//    private static void findPath(String[] starts, String end) {
//        String pos[] = starts;
//        boolean meet = false;
//        boolean way = false;
//        boolean isBeaconExist = false;
//
//        while (!meet) {
//            // Menambahkan beacon saat ini ke visited dan rute
//            visited.add(pos[0]);
////            rute.add(pos[0]);
//            if (neightboar.isEmpty()) {
//                // Perulangan pencarian
//                for (int i = 0; i < pos.length; i++) {
//                    // Jika tetangga sama dengan tujuan akhir
//                    if (pos[i].equalsIgnoreCase(end)) {
//                        rute.add(pos[0]);
//                        rute.add(end);
//                        way = true;
//                        meet = true;
//                    }
//                    // Jika tetangga tidak sama dengan tujuan akhir
//                    // Perulangan sampai index terakhir
//                    else if (pos[i].equalsIgnoreCase(pos[pos.length - 1])) {
//                        // Perulangan mencari tetangga beacon
//                        for (int j = 0; j < pos.length; j++) {
//                            for (int k = 0; k < beacon.length; k++) {
//                                // Jika ada tetangga beacon
//                                if (pos[j].equalsIgnoreCase(beacon[k][0])) {
//                                    // Periksa apakah visited kososng atau tidak
//                                    if (visited.isEmpty()) {
////                                        System.out.println(beacon[k][0]);
//                                    }
//                                    // Jika visisted tidak kososng
//                                    else {
//                                        // Perulangan periksa visited
//                                        for (int l = 0; l < visited.size(); l++) {
//                                            // Jika tetangga beacon sudah divisit
//                                            if (beacon[k][0].equalsIgnoreCase(visited.get(l))) {
//                                                // Skip
//                                                continue;
//                                            }
//                                            // Jika belum divisit
//                                            else {
//                                                // Masukan beacon tetangga ke neightboar
//                                                neightboar.add(beacon[k]);
//                                                isBeaconExist = true;
//                                            }
//                                        }
//                                    }
//                                }
//                                // Jika tidak ada tetangga beacon
//                                else {
//                                    isBeaconExist = false;
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if (isBeaconExist) {
//                    rute.add(pos[0]);
//                }
//
//                pos = neightboar.get(0);
//                neightboar.remove(0);
//            } else {
//                // Jika tetangga sama dengan tujuan akhir
//                for (int i = 0; i < pos.length; i++) {
//                    if (pos[i].equalsIgnoreCase(end)) {
//                        rute.add(pos[0]);
//                        rute.add(end);
//                        way = true;
//                    }
//                }
//                // Jika tetangga tidak sama dengan tujuan akhir
////                System.out.println(neightboar.get(0)[0]);
//                pos = neightboar.get(0);
//                neightboar.remove(0);
//                meet = true;
//            }
//        }
//
//        if (way) {
//            showPath(start, end);
//        } else {
//            findPath(pos, end);
//        }
//    }

//    private static void showPath(String[] start, String end) {
//
//        for (int i = 0; i < beacon.length; i++) {
//            if (rute.get(rute.size()-1).equalsIgnoreCase(beacon[i][0])){
//                rute.remove(rute.size()-1);
//            }
//        }
//
//        System.out.print("Visisted\t : ");
//        for (int i = 0; i < visited.size(); i++) {
//            if (i == visited.size() - 1) {
//                System.out.print(visited.get(i) + ".");
//            } else {
//                System.out.print(visited.get(i) + " -> ");
//            }
//        }
//
//        System.out.println("\n\n------------------------");
//        System.out.print("\n" + "Start\t: " + start[0] + "\n" + "End\t\t: " + end + "\n" + "Rute\t: ");
//        for (int i = 0; i < rute.size(); i++) {
//            if (i == rute.size() - 1) {
//                System.out.print(rute.get(i) + ".");
//            } else {
//                System.out.print(rute.get(i) + " -> ");
//            }
//        }
//    }
//
//    private static void findWay(String starts, String end) {
//
//        for (int p = 0; p <beacon.length ; p++) {
//            if (starts.equalsIgnoreCase(beacon[p][0])){
//                String pos[] = beacon[p];
//                boolean meet = false;
//                boolean way = false;
//                boolean beaconExist = false;
//
//                if (visited.isEmpty()){
//                    visited.add(pos[0]);
//                }else {
//                    for (int i = 0; i < visited.size(); i++) {
//                        if (!pos[0].matches(visited.get(i))){
//                            visited.add(pos[0]);
//                        }
//                    }
//                }
//
//                while (!meet) {
//                    if (neightboar.isEmpty()) {
//                        // Perulangan pencarian
//                        for (int i = 0; i < pos.length; i++) {
//                            // Jika tetangga sama dengan tujuan akhir
//                            if (pos[i].equalsIgnoreCase(end)) {
//                                rute.add(pos[0]);
//                                rute.add(end);
//                                way = true;
//                                meet = true;
//                            }
//                            // Periksa adakah tetangga beacon
//                            else if (pos[i].equalsIgnoreCase(pos[pos.length - 1])) {
//                                // Perulangan mencari tetangga beacon
//                                for (int j = 0; j < pos.length; j++) {
//                                    for (int k = 0; k < beacon.length; k++) {
//                                        // Jika ada tetangga beacon
//                                        if (pos[j].equalsIgnoreCase(beacon[k][0])) {
//                                            for (int l = 0; l < visited.size(); l++) {
//                                                if (!pos[j].matches(visited.get(l))){
//                                                    neightboar.add(beacon[k]);
//                                                    beaconExist = true;
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//
//                        if (beaconExist) {
//                            rute.add(pos[0]);
//                            pos = neightboar.get(0);
//                            neightboar.remove(0);
//                        }
//
////                meet = true;
//                    }
//                    else {
//                        // Jika tetangga sama dengan tujuan akhir
//                        for (String po : pos) {
//                            if (po.equalsIgnoreCase(end)) {
//                                rute.add(pos[0]);
//                                rute.add(end);
//                                way = true;
//                                meet = true;
//                            }
//                        }
//                        // Jika tetangga tidak sama dengan tujuan akhir
//                        pos = neightboar.get(0);
//                        neightboar.remove(0);
////                meet = true;
//                    }
//                }
//
//                if (meet) {
//                    showPath(beacon[p], end);
//                } else {
//                    findWay(pos[0], end);
//                }
//            }
//        }
//    }
}
