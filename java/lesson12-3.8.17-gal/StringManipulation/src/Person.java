public class Person {

    private String name;
    private int age;
    private boolean isAlive;
    private Person spouse;

    private Person() {
        isAlive = true;
    }

    public String getName() {
        return name;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getAge() {
        return age;

    }

    public Person getSpouse() {
        return spouse;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public static class PersonBuilder {

        private Person p;

        public PersonBuilder() {
            p = new Person();
        }

        //public methods to manipulate our person object
        public PersonBuilder setName(String name) {
            p.setName(name);

            return this;
        }

        public PersonBuilder setAge(int age) {
            p.setAge(age);

            return this;
        }

        public PersonBuilder setSpouse(Person spouse) {
            p.setSpouse(spouse);

            return this;
        }

        public Person getPerson() {
            return p;
        }
    }
}
