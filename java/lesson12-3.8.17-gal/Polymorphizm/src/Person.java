public class Person {
    int age;
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "my name is " + name + ", " + super.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Person("Gal"));

        //Aba Ben
        Aba a1 = new Aba(5.9);
        a1.bubu();

        Ben b1 = new Ben(111);
        //b1.bubu();
    }
}


class Aba {
    double rate;

    public Aba(){}

    public Aba(double rate) {
        this.rate = rate;
    }

    public void bubu() {
        System.out.println(rate + " Aba bubu");
    }
}

class Ben extends Aba {
    public Ben(double rate) {
        //super(rate); //Aba constructor

        this.bubu(); //does Ben implementation
        super.bubu(); //does super's implementation
    }

    @Override
    public void bubu() {
        System.out.println(rate + " Ben bubu");
    }
}