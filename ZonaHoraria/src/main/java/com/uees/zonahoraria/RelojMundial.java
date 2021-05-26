/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uees.zonahoraria;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class RelojMundial {

    public static void main(String[] args) throws ParseException {
        
        String[] timezones = {
    "Samoa (GMT-11)",
    "Hawaii (GMT-10)",
    "Anchorage, Juneau (GMT-09)",
    "Seattle, San Francisco, Los Angeles (GMT-08)",
    "Edmonton, Denver, Phoenix (GMT-07)",
    "Winnipeg, Chicago, Houston, Mexico, Tegucigalpa, Managua, San Jose (GMT-06)",
    "New York, Miami, La Habana, Puerto Principe, Panama, Bogota, Quito, Lima (GMT-05)",
    "Halifax, Santo Domingo, Caracas, Georgetown, Manaus, La Paz, Asuncion, Santiago de Chile (GMT-04)",
    "Brasilia, Rio De Janeiro, Montevideo, Buenos Aires (GMT-03)",
    "Recife (GMT-02)",
    "Azores (GMT-01)",
    "Londres, Dublín, Lisboa, Casablanca, Dakar, Accra (UTC)",
    "Paris, Madrid, Roma, Berlín, Praga, Belgrado, Varsovia, Estocolmo, Oslo, Argel, Lagos, Brazzaville, Luanda (GMT+01)",
    "Helsinki, Minks, Bucarest, Estambul, Atenas, Beirut, Cairo, Tripoli, Harare, Ciudad del Cabo (GMT+02)",
    "San Petersburgo, Moscow, Bagdad, Riad, Addis Abeba, Kampala, Nairobi, Mogadisco (GMT+03)",
    "Samara, Baku, Tbilisi, Dubai (GMT+04)",
    "Sheliabinsk, Karachi, Islamabad (GMT+05)",
    "Omsk, Tashkent, Dacca (GMT+06)",
    "Novosibirsk, Bangkok, Hanoi, Yakarta (GMT+07)",
    "Irkutsk, Lhasa, Beijing, Hong Kong, Kuala Lumpur, Singapur, Manila, Perth (GMT+08)",
    "Tokyo, Seul (GMT+09)",
    "Vladivostok, Sydney, Melbourne (GMT+10)",
    "Noumea, Magaban (GMT+11)",
    "Wellington (Nueva Zelanda) (GMT+12)"};
        
        Scanner sc = new Scanner(System.in);
        System.out.println("****************RELOJ MUNDIAL****************");
        String time;
        int horas = 0, minutos = 0, timezone = 0;
        boolean flag = true;
        
        while(flag){
            
            try {
                System.out.println("Ingrese la hora que desea convertir con el siguiente formato 24 horas y separado por ':' :");
                time = sc.next();
                if(!time.split(":")[0].isEmpty() && !time.split(":")[1].isEmpty() ){
                    
                    horas = Integer.parseInt(time.split(":")[0]);
                    minutos = Integer.parseInt(time.split(":")[1]);
                    
                    if(horas < 24 && horas >= 0 && minutos < 60 && minutos >= 0){
                        break;
                    }
                    
                }
            } catch (Exception e) {
                flag = true;
            }
            
        }
        
        System.out.println("**********************************");
            for (int i = 0; i < timezones.length; i++) {
                System.out.println((i+1) + ". " + timezones[i]);
            }
        
        flag = true;
        while(flag){
            System.out.println("Ingrese el numero correspondiente a la zona horaria a la que desea convertir la hora ingresada");
            timezone = sc.nextInt();
            if(timezone < 25 && timezone > 0){
                break;
            }
        }
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String fecha = format.format(date);
        fecha = fecha.split(" ")[0];
        
        date = format.parse(fecha + " " + horas + ":" + minutos + ":00");
        
        DateFormat df = new SimpleDateFormat("hh:mm");

        String huso = timezones[timezone - 1 ].substring( timezones[timezone - 1 ].length() - 7, (timezones[timezone - 1 ].length() - 1 ) );
        
        df.setTimeZone(TimeZone.getTimeZone(huso));
        
        System.out.println("Hora en " + timezones[timezone - 1] + ": " + df.format(date));
    }
    
}