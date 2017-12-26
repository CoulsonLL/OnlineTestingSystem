package util;

import java.util.Arrays;
import java.util.Random;

public class Algorithm
{
    public static int[] buildRandomSequence(int length)
    {
        Random r = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = i;
        }
        int x = 0, tmp = 0;
        for (int i = array.length - 1; i > 0; i--)
        {
            x = r.nextInt(i + 1);
            tmp = array[i];
            array[i] = array[x];
            array[x] = tmp;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
