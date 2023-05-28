package homework2_15;

import homework2_15.exception.MyIndexOutOfBoundsException;
import homework2_15.service.IntegerList;
import homework2_15.service.IntegerListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static homework2_15.IntegerListImplConstants.*;

public class IntegerListImplTest {
    private final IntegerList integerList = new IntegerListImpl();

    @BeforeEach
    public void addElements() {
        integerList.add(VALUE_1);
        integerList.add(VALUE_2);
        integerList.add(VALUE_3);
        integerList.add(VALUE_4);
    }

    @Test
    public void addValue() {
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {VALUE_1, VALUE_2, VALUE_3, VALUE_4} );
    }

    @Test
    public void addValueByIndexPositive() {
        integerList.add(2, VALUE_5);
        integerList.add(2, VALUE_1);
        integerList.add(2, VALUE_3);
        integerList.add(2, VALUE_5);

        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {VALUE_1, VALUE_2, VALUE_5, VALUE_3, VALUE_1, VALUE_5, VALUE_3, VALUE_4} );
    }

    @Test
    public void addValueByIndexNegative() {
        assertThatExceptionOfType(MyIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.add(8, VALUE_5))
                .withMessage(ERROR_MESSAGE_NOT_CORRECT_INDEX);
    }

    @Test
    public void addValueNegative() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> integerList.add(null))
                .withMessage("Значение не должно быть равно null");

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> integerList.add(1, null))
                .withMessage("Значение не должно быть равно null");
    }

    @Test
    public void setValuePositive() {
        integerList.set(3, VALUE_1);

        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {VALUE_1, VALUE_2, VALUE_3, VALUE_1});
    }

    @Test
    public void setValueNegative() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> integerList.set(1, null))
                .withMessage("Значение не должно быть равно null");

        assertThatExceptionOfType(MyIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.set(5, VALUE_1))
                .withMessage("Такого элемента не существует");

        assertThatExceptionOfType(MyIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.set(300, VALUE_1))
                .withMessage("Превышен размер внутреннего массива");
    }

    @Test
    public void removeValueByIndex() {
        integerList.remove(1);
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {VALUE_1, VALUE_3, VALUE_4} );
    }

    @Test
    public void removeValueByItemPositive() {
        integerList.remove(VALUE_3);
        assertThat(integerList.toArray())
                .isEqualTo(new Integer[] {VALUE_1, VALUE_2, VALUE_4} );
    }

    @Test
    public void removeValueByItemNegative() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> integerList.remove(null))
                .withMessage("Значение не должно быть равно null");

        assertThatExceptionOfType(MyIndexOutOfBoundsException.class)
                .isThrownBy(() -> integerList.remove(VALUE_NON_ELEMENT));
    }

    @Test
    public void containsValueInArray() {
        integerList.add(0, VALUE_84);
        integerList.add(2, VALUE_51);
        integerList.add(2, VALUE_45);
        integerList.add(2, VALUE_51);
        integerList.add(2, VALUE_90);
        System.out.println("Arrays.toString(integerList.toArray()) = " + Arrays.toString(integerList.toArray()));

        assertThat(integerList.contains(VALUE_4))
                .isTrue();

        assertThat(integerList.contains(VALUE_NON_ELEMENT))
                .isFalse();

        assertThat(integerList.contains(VALUE_72))
                .isFalse();
    }

    @Test
    public void lastIndexOf() {
        assertThat(integerList.lastIndexOf(VALUE_3))
                .isEqualTo(2);

        assertThat(integerList.lastIndexOf(VALUE_NON_ELEMENT))
                .isEqualTo(-1);
    }

    @Test
    public void getValue() {
        assertThat(integerList.get(1))
                .isEqualTo(VALUE_2);
    }

    @Test
    public void equalsArrays() {
        IntegerList integerListSecond = new IntegerListImpl();
        integerListSecond.add(VALUE_1);
        integerListSecond.add(VALUE_2);
        integerListSecond.add(VALUE_3);

        assertThat(integerList.equals(integerListSecond))
                .isFalse();

        integerListSecond.add(VALUE_4);

        assertThat(integerList.equals(integerListSecond))
                .isTrue();

        integerListSecond.set(2, VALUE_1);
        assertThat(integerList.equals(integerListSecond))
                .isFalse();
    }

    @Test
    public void sizeArray() {
        assertThat(integerList.size())
                .isEqualTo(4);
    }

    @Test
    public void isEmptyAndClearArray() {
        assertThat(integerList.isEmpty())
                .isFalse();
        integerList.clear();
        assertThat(integerList.isEmpty())
                .isTrue();
    }

    @Test
    public void bubbleSort() {
        integerList.add(0, VALUE_5);
        integerList.add(2, VALUE_4);
        int[] actual = new int[] {1, 2, 3, 4, 5, 5};
        assertThat(integerList.toArray().equals(actual));
        System.out.println("integerList.toArray() = " + integerList.toArray());
        System.out.println("actual = " + actual);
    }

}
