

import java.util.LinkedList;

import java.util.Scanner;

public class docimple implements DocServiceInterface {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String BLUE="\u001B[34m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";

    Validator validator=new Validator();

    LinkedList<doctor>docs=new LinkedList<>();

    @Override
    public void addDoctor() {

        String id = validator.validateId();
        String degree = validator.validateDegree("Degree");
        String name = validator.validateDoctorName("Name");
        String year = validator.validatePassoutYear();
        doctor dc = new doctor(id, degree, name, year, "Available");
        docs.add(dc);
        System.out.println(GREEN + "Entry Added Successfully !!!" + RESET);

    }
    @Override
    public void showAllDoct() {
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","DEGREE","NAME","  IN SERVICE FROM","STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (doctor dc:docs){
            System.out.format("%s%15s%15s%15s%15s",dc.getId(),dc.getName(),dc.getDegree(),dc.getPassoutyear(),dc.getStatus());
            System.out.println();
            flag=true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no Doctor In Hospital"+RESET);
    }

    @Override
    public void showAllAvailableDoct(){
        boolean flag=false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","DEGREE","NAME","IN SERVICE FROM","STATUS"+RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if(docs.size()>0){
            for (doctor dc:docs){
                if(dc.getStatus()=="Available"){
                    System.out.format("%s%15s%15s%15s%15s",dc.getId(),dc.getName(),dc.getDegree(),dc.getPassoutyear(),dc.getStatus());
                    System.out.println();
                    flag=true;
                }
            }
        }
        else{
            System.out.println(RED+"No Doctor Available in the Hospital"+RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if(flag==false)
            System.out.println(RED+"There are no DOCTORS with status Available"+RESET);

    }
    @Override
    public void bookappointment(){
        String bookid= validator.validateId();
        boolean flag=false;
        for(doctor dc:docs){
            if(dc.getId().equals(bookid) && dc.getStatus().equals("Available")){
                flag=true;
                System.out.println(GREEN+"Booked Successfully !!!"+RESET);
                dc.setStatus("Not Available");
                System.out.println(" Booking Details: "+dc);
            }
        }
        if(flag==false)
            System.out.println(RED+"This DOCTOR is not available to BOOK"+RESET);


    }

    public void returnBook(){
        boolean flag=false;
        String bookid= validator.validateId();
        for(doctor dc:docs){
            if(dc.getId().equals(bookid) && dc.getStatus().equals("Not Available")){
                flag=true;
                System.out.println(GREEN+"BOOKING CANCEL SUCEESFULLY !!!"+RESET);
                dc.setStatus("Available");
                System.out.println("CANCEL APPOINTMENT Details: "+dc);
            }

        }
        if(flag==false)
            System.out.println(RED+"SORRY,WE CANT BOOK APPOINTMENT FOR DOCTOR"+RESET);

    }


}

