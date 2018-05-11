package other;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

class Fraction{
    private int num;
    private int denom;

    public Fraction(int n, int d){
        this.num = n;
        this.denom = d;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num &&
                denom == fraction.denom;
    }

    @Override
    public int hashCode() {

        return Objects.hash(num, denom);
    }

    @Override
    public String toString() {
        return num + "/"+ denom;
    }
}

public class FractionAddition {

    public Fraction add(Fraction a, Fraction b){
        Fraction a0;
        Fraction b0;
        if(a.getDenom() != b.getDenom()){
            a0 = new Fraction(a.getNum()*b.getDenom(), a.getDenom()*b.getDenom());
            b0 = new Fraction(b.getNum()*a.getDenom(), a.getDenom()*b.getDenom());
        } else {
            a0 = a;
            b0 = b;
        }

        return new Fraction(a0.getNum()+b0.getNum(), a0.getDenom());
    }

    @Test
    public void testExample1(){
        FractionAddition f = new FractionAddition();
        Assert.assertEquals(f.add(new Fraction(1,3), new Fraction(1,2)), new Fraction(5,6));
    }

    @Test
    public void testExample2(){
        FractionAddition f = new FractionAddition();
        Assert.assertEquals(f.add(new Fraction(1,2), new Fraction(1,2)), new Fraction(2,2));
    }
    @Test
    public void testExample3(){
        FractionAddition f = new FractionAddition();
        Assert.assertEquals(f.add(new Fraction(1,2), new Fraction(1,2)), new Fraction(2,2));
    }
    @Test
    public void testExample4(){
        FractionAddition f = new FractionAddition();
        Assert.assertEquals(f.add(new Fraction(1,5), new Fraction(1,2)), new Fraction(7,10));
    }
    @Test
    public void testExample5(){
        FractionAddition f = new FractionAddition();
        Assert.assertEquals(f.add(new Fraction(1,5), new Fraction(3,5)), new Fraction(4,5));
    }

    public Fraction reduce(Fraction f){
        int max = f.getDenom() > f.getNum()?  f.getNum(): f.getDenom();
        for(int i = max; i>=2; i--){
            if(f.getDenom()%i == 0&& f.getNum()%i ==0){
                return new Fraction(f.getNum()/i, f.getDenom()/i);
            }
        }
        return f;
    }

    @Test
    public void testReduce1(){
        FractionAddition f = new FractionAddition();
        Fraction n = new Fraction(1,2);
        Assert.assertEquals(f.reduce(n), n);
    }
    @Test
    public void testReduce2(){
        FractionAddition f = new FractionAddition();
        Fraction n = new Fraction(2,6);
        Assert.assertEquals(f.reduce(n), new Fraction(1,3));
    }
    @Test
    public void testReduce3(){
        FractionAddition f = new FractionAddition();
        Fraction n = new Fraction(7,21);
        Assert.assertEquals(f.reduce(n), new Fraction(1,3));
    }
    @Test
    public void testReduce4(){
        FractionAddition f = new FractionAddition();
        Fraction n = new Fraction(21, 7);
        Assert.assertEquals(f.reduce(n), new Fraction(3,1));
    }
}
