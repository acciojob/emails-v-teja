package com.driver;

public class Email {

    private String emailId;

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(getPassword())){
            int n = newPassword.length();
            if(n<8){
                return;
            }
            int upperLength = 0;
            int lowerLength = 0;
            int noDigit = 0;
            int specialLength = 0;
            for(int i=0;i<n;i++){
                char temp = newPassword.charAt(i);
                if(Character.isUpperCase(temp)){
                    upperLength++;
                }else if(Character.isLowerCase(temp)) {
                    lowerLength++;
                }else if(Character.isDigit(temp)){
                    noDigit++;
                }else{
                    specialLength++;
                }
            }
            if(n>=8 && upperLength>=1 && lowerLength>=1 && noDigit>=1 && specialLength>=1){
                setPassword(newPassword);
            }
        }

    }
}
