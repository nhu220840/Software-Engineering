import utils.*;

/**
 * @overview An entity in a game
 * 
 * @attribute
 *  hitPoint    Integer     int
 *  damage      Integer     int
 *  armor       Integer     int
 *  price       Integer     int
 * 
 * @object
 *  A typical Tank in <hp, d, a, p> where hitPoint(hp), damage(d), armor(a), price(p)
 * 
 * @abstract_properties
 *  mutable(hitPoint) = true /\ optional(hitPoint) = false /\ min(hitPoint) = 1 /\
 *  mutable(damage) = true /\ optional(damage) = false /\ min(damage) = 1 /\
 *  mutable(armor) = true /\ optional(armor) = false /\ min(armor) = 0 /\
 *  mutable(price) = true /\ optional(price) = false /\ min(price) = 1
 */

public class Tank {
    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int hitPoint;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int damage;
    
    @DomainConstraint(type="Integer", mutable=true, optional=false, min=0)
    private int armor;
    
    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int price;

    
    /**
     * @effects
     *  if hp is valid
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Helper)
    @AttrRef("hitPoint")
    public boolean validateHitPoint(int hp){
        return hp >= 1;
    }
    
    /**
     * @effects
     *  if damage is valid
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Helper)
    @AttrRef("damage")
    public boolean validateDamage(int damage){
        return damage >= 1;
    }
    
    /**
     * @effects
     *  if armor is valid
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Helper)
    @AttrRef("armor")
    public boolean validateArmor(int armor){
        return armor >= 0;
    }
    
    /**
     * @effects
     *  if price is valid
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Helper)
    @AttrRef("price")
    public boolean validatePrice(int price){
        return price >= 1;
    }
    

    /**
     * @effects
     *  if hp, d, a, p are valid
     *      initialized this as <hp, d, a, p>
     *  else
     *      throw NotPossibleException
     */
    public Tank(@AttrRef("hitPoint") int hitPoint, @AttrRef("damage") int damage,
                @AttrRef("armor") int armor, @AttrRef("price") int price) throws NotPossibleException{
        if(!validateHitPoint(hitPoint)){
            throw new NotPossibleException("Invalid value for HP");
        }
        if(!validateDamage(damage)){
            throw new NotPossibleException("Invalid value for damage");
        }
        if(!validateArmor(armor)){
            throw new NotPossibleException("Invalid value for armor");
        }
        if(!validatePrice(price)){
            throw new NotPossibleException("Invalid value for price");
        }
        this.hitPoint = hitPoint;
        this.damage = damage;
        this.armor = armor;
        this.price = price;
    }
    
    /**
     * @effects
     *  return hitPoint
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("hitPoint")
    public int getHitPoint(){
        return this.hitPoint;
    }
    
    /**
     * @effects
     *  return damage
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("damage")
    public int getDamage(){
        return this.damage;
    }

    /**
     * @effects
     *  return armor
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("armor")
    public int getArmor(){
        return this.armor;
    }

    /**
     * @effects
     *  return price
     */
    @DOpt(type=OptType.Observer)
    @AttrRef("price")
    public int getPrice(){
        return this.price;
    }

    /**
     * @effects
     *  if hitPoint is valid
     *      set this.hitPoint = hitPoint
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("hitPoint")
    public boolean setHitPoint(int hp){
        if(validateHitPoint(hp)){
            this.hitPoint = hp;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @effects
     *  if damage is valid
     *      set this.damage = damage
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("damage")
    public boolean setDamage(int d){
        if(validateDamage(d)){
            this.damage = d;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @effects
     *  if armor is valid
     *      set this.armor = armor
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("armor")
    public boolean setArmor(int a){
        if(validateArmor(a)){
            this.armor = a;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @effects
     *  if price is valid
     *      set this.price = price
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("price")
    public boolean setPrice(int p){
        if(validatePrice(p)){
            this.price = p;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return String.format("Tank: <%d, %d, %d, %d>", this.hitPoint, this.damage, this.armor, this.price);
    }

    /**
     * @effects
     *  if this satisfies abstraction properties
     *      return true
     *  else
     *      return false
     */
    public boolean repOK(){
        return (validateHitPoint(hitPoint) && validateDamage(damage) && validateArmor(armor) && validatePrice(price));
    }
}