public @interface DomainConstraint {
    public String type() default "null";
    public boolean mutable() default true;
    public boolean optional() default true;
    public int length() default -1;
    public int min() default -1;
    public int max() default -1;
}
