import com.example.Feline;
import com.example.Lion;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Spy
    Feline feline;

    public LionTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][] {
                { "Самец" },
                { "Самка" },

        };
    }

    @Test
    public void doesHaveMane_success() throws Exception {
        Lion lion = new Lion(sex, feline);

        boolean hasMane = lion.doesHaveMane();

        if(sex.equals("Самец")) {
            Assert.assertTrue("Ожидается true для " + sex,hasMane);
        } else {
            Assert.assertFalse("Ожидается false для " + sex, hasMane);
        }

    }

    @Test
    public void getFood_success() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getKittens_success() throws Exception {
        Lion lion = new Lion(sex, feline);
        int kittensNumber = lion.getKittens();
        Assert.assertEquals(1, kittensNumber);
    }

    @Test
    public void lion_exception() {
        Exception exception = Assert.assertThrows(Exception.class,
                () -> new Lion("сам", feline)
        );
        Assert.assertEquals("Неверный текст исключения",
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

}
