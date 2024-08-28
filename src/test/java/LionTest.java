import com.example.Feline;
import com.example.Lion;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoJUnit;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
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
    public void doesHaveManeSuccess() throws Exception {
        Lion lion = new Lion(sex, feline);

        boolean hasMane = lion.doesHaveMane();

        if(sex.equals("Самец")) {
            Assert.assertTrue("Ожидается true для " + sex,hasMane);
        } else {
            Assert.assertFalse("Ожидается false для " + sex, hasMane);
        }

    }

    @Test
    public void getFoodSuccess() throws Exception {
        List <String> testFood = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(testFood);
        List<String> food = lion.getFood();
        Assert.assertEquals(testFood, food);
    }

    @Test
    public void getKittensSuccess() throws Exception {
        int testKittensNumber = 2;
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(testKittensNumber);
        int kittensNumber = lion.getKittens();
        Assert.assertEquals(testKittensNumber, kittensNumber);
    }

}
