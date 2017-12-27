//Gerard Patrick Gibbons, Junior-Year Computer Science Major
//November 29, 2017
//Fraction Class, Assignment 10
package fraction;

public class Fraction {
    int numerator;
    int denuminator;
    
    Fraction(int n, int d)
    {
        if(d == 0)
        {
            throw new ArithmeticException();
        }else
        {
            this.denuminator = d;
            this.numerator = n;
        }
        this.reduce();
    }
    
    public void setDenum(int d)
    {
        this.denuminator = d;
    }
    public int getDenum()
    {
        return this.denuminator;
    }
    
    public void setNum(int n)
    {
        this.numerator = n;
    }
    public int getNum()
    {
        return this.numerator;
    }
    public int GCD(int num, int denum)
    {
        if(denum == 0){
            return num;
        }
        return GCD(denum, num%denum);
    }
    public void reduce()
    {
        int gcd = GCD(this.numerator, this.denuminator);
        this.numerator = (this.numerator / gcd);
        this.denuminator = (this.denuminator / gcd);
    }
    public String toString()
    {
        return this.numerator  + " / " + this.denuminator;
    }
    public Fraction add(Fraction a)
    {
        Fraction sum = new Fraction(0, 1);
        sum.setNum(a.numerator*this.denuminator +a.denuminator*this.numerator);
        sum.setDenum(a.denuminator*this.denuminator);
        sum.reduce();
        return sum;
    }
    public boolean equals(Fraction a)
    {
        return (this.numerator == a.numerator) && (this.denuminator == a.denuminator);
    }
    public static void main(String[] args) {
        Fraction f = new Fraction (1000 ,5000);
         f.setNum(4000);
        System.out.println("new Numerator: " + f.getNum());
        f.setDenum(2000);
        System.out.println("new Denominator: " + f.getDenum());
       
        f.reduce();
        System.out.println("Reduced Fraction: " + f);
        
        
        Fraction f2 = new Fraction (2000, 5000);
        System.out.println("Fraction 1: " + f.toString());
        System.out.println("Fraction 2: " + f2.toString());
        System.out.println("sum: " + f.add(f2));
        System.out.println("Are they equal? " + f.equals(f2));
    }
    
}
