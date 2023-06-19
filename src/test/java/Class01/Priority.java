package Class01;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 4, groups = "smoke")
    public void Atest(){
        System.out.println("I am test A.");
    }
    @Test(priority = 3)
    public void Btest(){
        System.out.println("I am test B.");
    }
    @Test(priority = 2)
    public void Ctest(){
        System.out.println("I am test C.");
    }
    @Test(priority = 1)
    public void Dtest(){
        System.out.println("I am test D.");
    }
    @Test
    public void ABtest() {
        System.out.println("I am test D.");
    } //No priority mentioned means 0, highest priority.
}
