import NotPossibleException;
import DomainConstraint;
import DOpt;

/**
 * @Overview: An armored vehicle in game
 * 
 * @attributes
 *  hitPoint    Integer    int
 *  damage      Integer    int
 *  armor       Integer    int
 *  price       Integer    int
 * 
 * @object
 *  A typical Tank in <hp, d, a, p> where hitPoint(hp), damage(d), armor(a), price(p)
 * 
 * @abstract_properties
 *  mutable(hitPoint) = true /\ optional(hitPoint) = false /\ min(hitPoint) = 1 /\
 *  mutable(damage) = true /\ optional(damage) = false /\ min(damage) = 1 /\
 *  mutable(armor) = true /\ optional(armor) = false /\ min(armor) = 1 /\ 
 *  mutable(price) = false /\ optional(armor) = false /\ min(armor) = 0
*/

public class Tank {
    // ===============================ATTRIBUTES==============================

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int hitPoint;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int damage;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=0)
    private int armor;

    @DomainConstraint(type="Integer", mutable=false, optional=false, min=1)
    private int price;

    // ===============================ATTRIBUTES==============================

    // ===============================CONSTRUCTOR==============================
    public Tank(@AttrRef("hitPoint") int hitPoint, @AttrRef("damage") int damage, 
                @AttrRef("armor") int armor, @AttrRef("price") int price){
        this.hitPoint = hitPoint;
        this.damage = damage;
        this.armor = armor;
        this.price = price;
    }

    // ===============================CONSTRUCTOR==============================


    // =================================GETTER=================================

    /**
     * @effects <pre>
     *      return hitPoint
     * </pre>
    */
    @DOpt(type=OptType.Observer) @AttrRef("hitPoint")
    public int getHitPoint(){
        return this.hitPoint;
    }
    
    /**
     * @effects <pre>
     *      return damage
     * </pre>
    */
    @DOpt(type=OptType.Observer) @AttrRef("damage")
    public int getDamage(){
        return this.damage;
    }

    /**
     * @effects <pre>
     *      return armor
     * </pre>
    */
    @DOpt(type=OptType.Observer) @AttrRef("armor")
    public int getArmor(){
        return this.armor;
    }

    /**
     * @effects <pre>
     *      return price
     * </pre>
    */
    @DOpt(type=OptType.Observer) @AttrRef("price")
    public int getPrice(){
        return this.price;
    }

    // =================================GETTER=================================

    // =================================SETTER=================================

    /**
     * @effects <pre>
     *      if hitPoint is valid
     *          set this.hitPoint = hp
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("hitPoint")
    public void setHitPoint(int hp){
        this.hitPoint = hp;
    }

    /**
     * @effects <pre>
     *      if hitPoint is valid
     *          set this.damage = d
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("damage")
    public void setDamage(int d){
        this.damage = d;
    }

    /**
     * @effects <pre>
     *      if hitPoint is valid
     *          set this.armor = a
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("armor")
    public void setArmor(int a){
        this.armor = a;
    }

    /**
     * @effects <pre>
     *      if hitPoint is valid
     *          set this.price = p
     *          return true
     *      else
     *          return false
     *  </pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("price")
    public void setPrice(int p){
        this.price = p;
    }

    // =================================SETTER=================================

    @Override
    public String toString(){
        //return "Tank: "<" + hp + ", " + d + ", " + a + ", " + p + ">";
        return String.format("Tank: <%d, %d, %d, %d>", hp, d, a, p);
    }

    /**
     * @effects <pre>
     *      if this satisfies abstract properties
     *          return true
     *      else
     *          return false
     *  </pre>
    */
    public boolean repOK(){
        return validateHitPoint(hitPoint) && validateDamage(damage) && validateArmor(armor) && validatePrice(price);
    }

    
}