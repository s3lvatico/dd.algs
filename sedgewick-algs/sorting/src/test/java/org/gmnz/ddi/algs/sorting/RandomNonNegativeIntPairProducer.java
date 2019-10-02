package org.gmnz.ddi.algs.sorting;

@FunctionalInterface
interface RandomNonNegativeIntPairProducer {

    int[] produce(int upperBound);
    
}