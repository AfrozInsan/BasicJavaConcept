package com.java.core.concept;

import com.java.core.concept.validation.User;


import javax.validation.*;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */


public class App 
{
    private static Logger logger;
    static {
        logger = Logger.getLogger(App.class.getName());
    }

    public static void main( String[] args )
    {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        Set<ConstraintViolation<User>> validates = validator.validate(user);


        for(ConstraintViolation<User> violation:validates){
            logger.log(Level.INFO, violation.getMessage());
        }
    }
}
