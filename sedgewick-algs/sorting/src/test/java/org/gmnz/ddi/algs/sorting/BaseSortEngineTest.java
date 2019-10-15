package org.gmnz.ddi.algs.sorting;


import org.junit.Test;

import java.util.Random;

import org.junit.Assert;


/**
 * BaseSortEngineTest
 */
public class BaseSortEngineTest {

    private RandomNonNegativeIntPairProducer indexGenerator = (x) -> {
        Random rnd = new Random();
        int[] result = new int[2];
        result[0] = rnd.nextInt(x);
        int n = rnd.nextInt(x);
        while (n == result[0]) {
            n = rnd.nextInt(x);
        }
        result[1] = n;
        return result;
    };

    @Test
    public void swap() {
        BaseSortEngine bse = new BaseSortEngine();
        Random rnd = new Random();

        final int ATTEMPTS = 100;
        final int ARRAY_SIZE = 20;

        for (int a = 0; a < ATTEMPTS; a++) {

            int arrayLength = rnd.nextInt(ARRAY_SIZE);
            while (arrayLength < 2) {
                arrayLength = rnd.nextInt(ARRAY_SIZE);
            }
            System.out.println("array length: " + arrayLength);

            byte[] vbyte = new byte[arrayLength];
            short[] vshort = new short[arrayLength];
            int[] vint = new int[arrayLength];
            long[] vlong = new long[arrayLength];
            float[] vfloat = new float[arrayLength];
            double[] vdouble = new double[arrayLength];

            for (int i = 0; i < arrayLength; i++) {
                short s = Short.MIN_VALUE;
                s += Integer.valueOf(rnd.nextInt(Short.MAX_VALUE)).shortValue();
                vshort[i] = s;

                int n = Integer.MIN_VALUE + rnd.nextInt(Integer.MAX_VALUE);
                vint[i] = n;
                vlong[i] = rnd.nextLong();
                vfloat[i] = rnd.nextFloat();
                vdouble[i] = rnd.nextDouble();
            }

            rnd.nextBytes(vbyte);

            int[] rndIndexes = indexGenerator.produce(arrayLength);
            int idx1 = rndIndexes[0];
            int idx2 = rndIndexes[1];
            System.out.printf("%s | swap  %d <--> %d%n", ArrayUtils.toString(vbyte), idx1, idx2);

            byte byteExp1 = vbyte[idx2];
            byte byteExp2 = vbyte[idx1];
            bse.swap(vbyte, idx1, idx2);
            Assert.assertEquals(byteExp1, vbyte[idx1]);
            Assert.assertEquals(byteExp2, vbyte[idx2]);

            short shortExp1 = vshort[idx2];
            short shortExp2 = vshort[idx1];
            bse.swap(vshort, idx1, idx2);
            Assert.assertEquals(shortExp1, vshort[idx1]);
            Assert.assertEquals(shortExp2, vshort[idx2]);

            int intExp1 = vint[idx2];
            int intExp2 = vint[idx1];
            bse.swap(vint, idx1, idx2);
            Assert.assertEquals(intExp1, vint[idx1]);
            Assert.assertEquals(intExp2, vint[idx2]);

            long longExp1 = vlong[idx2];
            long longExp2 = vlong[idx1];
            bse.swap(vlong, idx1, idx2);
            Assert.assertEquals(longExp1, vlong[idx1]);
            Assert.assertEquals(longExp2, vlong[idx2]);

        }
    }

}