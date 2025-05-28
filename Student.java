import utils.*;

/**
 * @overview A student in a class
 * 
 * @attribute
 *  dateOfBirth     String
 * 
 * @objective A typical Student in <dob> where dob (dateOfBirth)
 *  
 * @abstract_properties
 *  mutable(dateOfBirth) = false /\ optional(dateOfBirth) = false /\ length(dateOfBirth) = 10 /\  dateOfBirth.matches("dd/mm/yyyy")
 * 
*/

public class Student {
    @DomainConstraint(type = "String", mutable = false, optional = false, length = 10)
    private String dateOfBirth;

    /**
     * @effects
     *  if dob is valid
     *      return true
     *  else 
     *      return false
    */
    @DOpt(type = OptType.Helper)
    @AttrRef("dateOfBirth")
    boolean validateDateOfBirth(String dob){
        if(dateOfBirth == null || !(dateOfBirth.matches("\\d{2}/\\d{2}/\\d{4}")){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * @effects
     *  if dob is valid
     *      set this.dateOfBirth = dob
     *      return true
     *  else
     *      return false
    */
    @DOpt(type = OptType.Mutator)
    @AttrRef("dateOfBirth")
    public boolean setDateOfBirth(String dob){
        if(!(validateDateOfBirth(dob))){
            this.dateOfBirth = dob;
            return true;
        }
        else return false;
    }
}
