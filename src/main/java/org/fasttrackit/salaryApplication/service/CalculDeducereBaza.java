package org.fasttrackit.salaryApplication.service;

public class CalculDeducereBaza {
    public static final Integer SALARIU_MINIM = 3300;

    public static Double procentDeducereFaraPersIntretinere(Integer venitBrut) {
        if ((venitBrut - SALARIU_MINIM) <= 0) {
            return 20.00;
        }
        if ((venitBrut - SALARIU_MINIM > 0) && (venitBrut - SALARIU_MINIM <= 50)) {
            return 19.50;
        }
        if ((venitBrut - SALARIU_MINIM > 50) && (venitBrut - SALARIU_MINIM <= 100)) {
            return 19.00;
        }
        if ((venitBrut - SALARIU_MINIM > 100) && (venitBrut - SALARIU_MINIM <= 150)) {
            return 18.50;
        }
        if ((venitBrut - SALARIU_MINIM > 150) && (venitBrut - SALARIU_MINIM <= 200)) {
            return 18.00;
        }
        if ((venitBrut - SALARIU_MINIM > 200) && (venitBrut - SALARIU_MINIM <= 250)) {
            return 17.50;
        }
        if ((venitBrut - SALARIU_MINIM > 250) && (venitBrut - SALARIU_MINIM <= 300)) {
            return 17.00;
        }
        if ((venitBrut - SALARIU_MINIM > 300) && (venitBrut - SALARIU_MINIM <= 350)) {
            return 16.50;
        }
        if ((venitBrut - SALARIU_MINIM > 350) && (venitBrut - SALARIU_MINIM <= 400)) {
            return 16.00;
        }
        if ((venitBrut - SALARIU_MINIM > 400) && (venitBrut - SALARIU_MINIM <= 450)) {
            return 15.50;
        }
        if ((venitBrut - SALARIU_MINIM > 450) && (venitBrut - SALARIU_MINIM <= 500)) {
            return 15.00;
        }
        if ((venitBrut - SALARIU_MINIM > 500) && (venitBrut - SALARIU_MINIM <= 550)) {
            return 14.50;
        }
        if ((venitBrut - SALARIU_MINIM > 550) && (venitBrut - SALARIU_MINIM <= 600)) {
            return 14.00;
        }
        if ((venitBrut - SALARIU_MINIM > 600) && (venitBrut - SALARIU_MINIM <= 650)) {
            return 13.50;
        }
        if ((venitBrut - SALARIU_MINIM > 650) && (venitBrut - SALARIU_MINIM <= 700)) {
            return 13.00;
        }
        if ((venitBrut - SALARIU_MINIM > 700) && (venitBrut - SALARIU_MINIM <= 750)) {
            return 12.50;
        }
        if ((venitBrut - SALARIU_MINIM > 750) && (venitBrut - SALARIU_MINIM <= 800)) {
            return 12.00;
        }
        if ((venitBrut - SALARIU_MINIM > 800) && (venitBrut - SALARIU_MINIM <= 850)) {
            return 11.50;
        }
        if ((venitBrut - SALARIU_MINIM > 850) && (venitBrut - SALARIU_MINIM <= 900)) {
            return 11.00;
        }
        if ((venitBrut - SALARIU_MINIM > 900) && (venitBrut - SALARIU_MINIM <= 950)) {
            return 10.50;
        }
        if ((venitBrut - SALARIU_MINIM > 950) && (venitBrut - SALARIU_MINIM <= 1000)) {
            return 10.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1000) && (venitBrut - SALARIU_MINIM <= 1050)) {
            return 9.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1050) && (venitBrut - SALARIU_MINIM <= 1100)) {
            return 9.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1100) && (venitBrut - SALARIU_MINIM <= 1150)) {
            return 8.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1150) && (venitBrut - SALARIU_MINIM <= 1200)) {
            return 8.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1200) && (venitBrut - SALARIU_MINIM <= 1250)) {
            return 7.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1250) && (venitBrut - SALARIU_MINIM <= 1300)) {
            return 7.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1300) && (venitBrut - SALARIU_MINIM <= 1350)) {
            return 6.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1350) && (venitBrut - SALARIU_MINIM <= 1400)) {
            return 6.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1400) && (venitBrut - SALARIU_MINIM <= 1450)) {
            return 5.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1450) && (venitBrut - SALARIU_MINIM <= 1500)) {
            return 5.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1500) && (venitBrut - SALARIU_MINIM <= 1550)) {
            return 4.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1550) && (venitBrut - SALARIU_MINIM <= 1600)) {
            return 4.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1600) && (venitBrut - SALARIU_MINIM <= 1650)) {
            return 3.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1650) && (venitBrut - SALARIU_MINIM <= 1700)) {
            return 3.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1700) && (venitBrut - SALARIU_MINIM <= 1750)) {
            return 2.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1750) && (venitBrut - SALARIU_MINIM <= 1800)) {
            return 2.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1800) && (venitBrut - SALARIU_MINIM <= 1850)) {
            return 1.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1850) && (venitBrut - SALARIU_MINIM <= 1900)) {
            return 1.00;
        }
        if ((venitBrut - SALARIU_MINIM > 1900) && (venitBrut - SALARIU_MINIM <= 1950)) {
            return 0.50;
        }
        if ((venitBrut - SALARIU_MINIM > 1950) && (venitBrut - SALARIU_MINIM <= 2000)) {
            return 0.00;
        }

        return 0.00;
    }


}


