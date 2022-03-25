package com.example.freemoneynoscam.services;

public class ValidateEmailService {
    public boolean isEmailValid(String email){

        boolean validEmail = false;

        if (email.contains("@")){
            try {
                String[] emailSplit = email.split("@");

                if ((emailSplit[0].length() > 0) && (emailSplit[1].length() > 4) && (emailSplit[1].contains("."))){
                    validEmail = true;
                }
            } catch (Exception e){
                System.out.println("email couldn't be split");
                return validEmail;
            }

        }

        return validEmail;
    }
}
