import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    @Test
    public void eatMeat_success() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamily_success() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittens_noArgs_success() {
        Feline feline = new Feline();
        int kittensNumber = feline.getKittens();
        Assert.assertEquals(1, kittensNumber);
    }

    @Test
    public void getKittens_withArgs_success() {
        int expect = 5;

        Feline feline = new Feline();
        int kittensNumber = feline.getKittens(expect);
        Assert.assertEquals(expect, kittensNumber);
    }
}
