public class Tester {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //append - add to end of string
        //insert
        //replace
        //delete

        //all StringBuilder methods that relative to manupilating string returns itself

        //example 1:
        sb.append("hello"); //return StringBuilder
        sb.append(" ");
        sb.append("world");

        System.out.println(sb); //calls toString()

        sb.toString(); //return string - hello world


        //example 2:
        sb.delete(0, sb.length()); //clear the string
        sb.append("my").append(" name").append(" is").append(" Gal");

        //another way to write
        sb.append("my")
                .append(" name")
                .append(" is")
                .append(" Gal");



        Person p = new Person();


        Person.PersonBuilder pb = new Person.PersonBuilder();
        Person newP = pb.setAge(0).setName("Gal").setSpouse(null).getPerson();
    }
}