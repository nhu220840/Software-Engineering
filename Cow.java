/**
* @Overview: A cow in the farm?
* @attributes:
*   name   String
*   breed  String
*   age    Integer    int
*
* @object
*   A typical Cow in <n, b, a> where name(n), breed(b), age(a)
*
* @abstract_properties
*   mutable(name) = true /\ optional(name) = false /\ length(name) = 30 /\
*   mutable(breed) = true /\ optional(breed) = false /\ length(breed) = 30 /\
*   mutable(age) = true /\ optional(age) = false /\ min(age) = 1 /\ max(age) = 36
*/
public class Cow {
    @DomainConstraint(type="String", mutable=true, optional=false, length=30)
    private String name;
    
    @DomainConstraint(type="String", mutable=true, optional=false, length=30)
    private String breed;
    
    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1, max=36)
    private int age;

    @DOpt(type=OptType.Observer) @AttrRef("name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    
}